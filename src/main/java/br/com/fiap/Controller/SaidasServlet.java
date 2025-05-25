package br.com.fiap.Controller;

import br.com.fiap.model.Account;
import br.com.fiap.model.Transaction;
import br.com.fiap.model.User;
import br.com.fiap.service.AccountService;
import br.com.fiap.service.TransactionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/saidas")
public class SaidasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        System.out.println("[SaidassServlet] Requisição recebida");

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();

        List<Transaction> saidas = TransactionService.getTransactionsWithdrawalByUserId(userId);
        req.setAttribute("saidas", saidas);

        System.out.println(saidas);

        List<Account> accounts = AccountService.getAccountsByUserId(userId);
        req.setAttribute("accounts", accounts);
        
        req.getRequestDispatcher("saidas.jsp")
           .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("[SaidasServlet] doPost iniciado");

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();

        String accParam = req.getParameter("accountId");
        System.out.println("[SaidasServlet] accountId recebido: " + accParam);
        int accountId = Integer.parseInt(accParam);

        Account target = AccountService.getAccountsByUserId(userId).stream()
            .filter(a -> a.getId() == accountId)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Conta não encontrada: " + accountId));
        System.out.println("[SaidasServlet] Conta alvo: ");

        double amount = Double.parseDouble(req.getParameter("amount"));
        String date   = req.getParameter("date");
        System.out.println("[SaidasServlet] amount=" + amount + ", date=" + date);

        TransactionService.withdraw(target, amount, date);

        System.out.println("[SaidasServlet] Redirecionando para /saidas");
        resp.sendRedirect(req.getContextPath() + "/saidas");
    }

}
