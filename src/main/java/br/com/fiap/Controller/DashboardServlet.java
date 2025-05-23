package br.com.fiap.Controller;

import br.com.fiap.service.AccountService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private final AccountService accountService = new AccountService();

    private void carregarDashboard(HttpServletRequest request) {
        // Futuro: Recupere o ID do usuário autenticado da sessão
//         HttpSession session = request.getSession(false);
//         if (session == null || session.getAttribute("userId") == null) {
//             request.setAttribute("error", "Usuário não autenticado.");
//             return;
//         }

        int userId = 1; // Temporário, substituir por: (int) session.getAttribute("userId")
        Double total = accountService.getTotalBalanceByUserId(userId);
        request.setAttribute("totalBalance", total);
    }

    private void processarRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        carregarDashboard(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processarRequisicao(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processarRequisicao(request, response);
    }
}
