package br.com.fiap.Controller;

import br.com.fiap.model.User;
import br.com.fiap.service.AccountService;
import br.com.fiap.service.GoalService;
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
    private final GoalService goalService = new GoalService();

    private void carregarDashboard(HttpServletRequest request, int userId) throws IOException {

        Double total = accountService.getTotalBalanceByUserId(userId);
        Double amountMissing = goalService.getAmountMissingToReachGoals(userId);
        request.setAttribute("totalBalance", total);
        request.setAttribute("amountMissing", amountMissing);
    }


    private void processarRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();

        carregarDashboard(request, userId);

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
