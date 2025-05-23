package br.com.fiap.controller;

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
    System.out.println("EntradasServlet.doGet() invocado");

    HttpSession session = req.getSession(false);
    Integer userId = (session != null) ? (Integer) session.getAttribute("userId") : null;

    System.out.println("Usuario da sessao: " + userId);

    if (userId == null) {
        System.out.println("Usuario nao autenticado, redirecionando para login");
        resp.sendRedirect("/login");
        return;
    }

    try {
        System.out.println("Buscando transacoes para userId=" + userId);
        List<Transaction> todas = dao.findByUserId(userId);
        System.out.println("Encontradas " + todas.size() + " transacoes no total");

        List<Transaction> entradas = todas.stream()
            .filter(t -> "IN".equals(t.getType()))
            .collect(Collectors.toList());
        System.out.println("Filtradas " + entradas.size() + " entradas (type=IN)");

        req.setAttribute("entradas", entradas);
        System.out.println("Chamando forward para entradas.jsp");
        req.getRequestDispatcher("entradas.jsp")
           .forward(req, resp);

    } catch (Exception e) {
        System.out.println("Erro durante busca de transacoes:");
        e.printStackTrace();
        throw new ServletException(e);
    }
}


}
