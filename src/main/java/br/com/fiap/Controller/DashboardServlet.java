package br.com.fiap.Controller;

import br.com.fiap.model.User;
import br.com.fiap.service.UserService;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        User user = userService.loginUser(email, password);
//
//        System.out.println(email);
//        System.out.println(password);
//
//        if (user != null) {
//            HttpSession session = request.getSession();
//            session.setAttribute("user", user);
//            System.out.println(user);
//            response.sendRedirect("dashboard");
//
//        } else {
//
//        }
//        request.setAttribute("error", "Email ou senha inválidos.");
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}