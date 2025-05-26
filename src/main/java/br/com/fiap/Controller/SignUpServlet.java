package br.com.fiap.Controller;

import br.com.fiap.model.User;
import br.com.fiap.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("sign-up.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String telefone = request.getParameter("telefone");
            String endereco = request.getParameter("endereco");


            if (nome == null || nome.isEmpty() ||
                    email == null || email.isEmpty() ||
                    senha == null || senha.isEmpty()) {
                request.setAttribute("erro", "Nome, e-mail e senha são obrigatórios");
                request.getRequestDispatcher("sign-up.jsp").forward(request, response);
                return;
            }


            User user = userService.createUser(nome, email, senha, telefone, endereco);

            if (user != null) {
                request.setAttribute("sucesso", "Cadastro realizado com sucesso! Faça login.");
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("erro", "Erro ao cadastrar usuário");
                request.getRequestDispatcher("sign-up.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro no servidor: " + e.getMessage());
            request.getRequestDispatcher("sign-up.jsp").forward(request, response);
        }
    }
}