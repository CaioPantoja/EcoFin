package br.com.fiap.Controller;

import br.com.fiap.model.Account;
import br.com.fiap.model.User;
import br.com.fiap.service.AccountService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/novaConta")
public class NovaContaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = user.getUserId();

        String accountName = request.getParameter("name");
        String accountType = request.getParameter("accountType");
        double initialBalance;

        try {
            initialBalance = Double.parseDouble(request.getParameter("balance"));
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Valor do saldo inválido");
            request.getRequestDispatcher("novaConta.jsp").forward(request, response);
            return;
        }

        if (accountName == null || accountName.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Nome da conta é obrigatório");
            request.getRequestDispatcher("novaConta.jsp").forward(request, response);
            return;
        }

        if (initialBalance < 0) {
            request.setAttribute("errorMessage", "Saldo não pode ser negativo");
            request.getRequestDispatcher("novaConta.jsp").forward(request, response);
            return;
        }

        try {
            Account newAccount = AccountService.createAccount(
                    userId,
                    accountName,
                    accountType,
                    initialBalance
            );

            session.setAttribute("contas", AccountService.getAccountsByUserId(userId));
            response.sendRedirect("dashboard");
            return;

        } catch (Exception e) {
            request.setAttribute("errorMessage", "Erro ao criar conta: " + e.getMessage());
            request.getRequestDispatcher("novaConta.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = user.getUserId();

        request.setAttribute("contasUsuario", AccountService.getAccountsByUserId(userId));
        request.getRequestDispatcher("novaConta.jsp").forward(request, response);
    }
}
