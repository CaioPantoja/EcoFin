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
        System.out.println("[SaidasServlet] Encaminhando para saidas.jsp");

        // TODO Deixar o id do user dinamico, deixei fixo o user 4
        List<Transaction> saidas = TransactionService.getTransactionsWithdrawalByUserId(4);

        System.out.println(saidas);
        
        // 3) Coloque no request
        req.setAttribute("saidas", saidas);
        
        // 4) Encaminhe para a JSP
        req.getRequestDispatcher("saidas.jsp")
           .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("[SaidasServlet] doPost iniciado");

        // TODO: deixar o usurId dinamico
        // TODO: Verificar questão do account
        // 1) Carrega a lista de contas
        System.out.println("[SaidasServlet] Buscando contas do usuário com ID=4");
        List<Account> accounts = AccountService.getAccountsByUserId(4);
        System.out.println("[SaidasServlet] Contas encontradas: " + accounts.size());

        // 2) Lê os parâmetros do form
        // (Descomente se tiver o campo type no form)
        // String type = req.getParameter("type");
        String amountParam = req.getParameter("amount");
        System.out.println("[SaidasServlet] Parâmetro amount recebido: " + amountParam);
        double amount = Double.parseDouble(amountParam);
        System.out.println("[SaidasServlet] Valor parseado: " + amount);

        String date = req.getParameter("date");
        System.out.println("[SaidasServlet] Parâmetro date recebido: " + date);

        // TODO: Definir uma conta Id para a nova Transaction
        // 3) Filtra a conta de ID=6
        System.out.println("[SaidasServlet] Filtrando conta com ID=6");
        Account target = accounts.stream()
            .filter(a -> a.getId() == 6)
            .findFirst()
            .orElseThrow(() -> {
                System.out.println("[SaidasServlet] ERRO: conta ID=6 não encontrada");
                return new RuntimeException("Conta com id=6 não encontrada");
            });

        // 4) Executa a transação (saque ou depósito)
        System.out.println("[SaidasServlet] Executando saque de R$" + amount
            + " na conta ID=" + target.getId());
        TransactionService.withdraw(target, amount, date);

        System.out.println("[SaidasServlet] Saque processado com sucesso");

        // 5) Redireciona de volta (Post/Redirect/Get)
        System.out.println("[SaidasServlet] Redirecionando para /saidas");
        resp.sendRedirect(req.getContextPath() + "/saidas");
    }

}
