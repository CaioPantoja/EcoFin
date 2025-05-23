package br.com.fiap.Controller;

import br.com.fiap.dao.TransactionDao;
import br.com.fiap.model.Transaction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/entradas")
public class EntradasServlet extends HttpServlet {

    private final TransactionDao dao = new TransactionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("[EntradasServlet] Requisição recebida");

//        HttpSession session = req.getSession(false);
//        Integer userId = (session != null) ? (Integer) session.getAttribute("userId") : null;

//        if (userId == null) {
//            System.out.println("[EntradasServlet] Usuário não autenticado, redirecionando para login");
//            resp.sendRedirect("login");
//            return;
//        }

//        try {
//            System.out.println("[EntradasServlet] Buscando transações do usuário ID: " + userId);
//            List<Transaction> todas = dao.findByUserId(userId);
//            System.out.println("[EntradasServlet] Transações encontradas: " + todas.size());

//            List<Transaction> entradas = todas.stream()
//                    .filter(t -> "IN".equalsIgnoreCase(t.getType()))
//                    .collect(Collectors.toList());

//            System.out.println("[EntradasServlet] Transações de entrada (IN): " + entradas.size());

//            req.setAttribute("entradas", entradas);

            System.out.println("[EntradasServlet] Encaminhando para entradas.jsp");
            req.getRequestDispatcher("entradas.jsp").forward(req, resp);

//        } catch (Exception e) {
            System.err.println("[EntradasServlet] Erro ao processar transações:");
//            e.printStackTrace();
            req.setAttribute("erro", "Erro ao carregar transações");
//            req.getRequestDispatcher("erro.jsp").forward(req, resp);
//        }
    }
}
