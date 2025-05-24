<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
      <meta charset="UTF-8">
      <title>EcoFin - Saídas</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
      <style>
        body {
          background-color: #dcdcdc;
          font-family: Arial, sans-serif;
        }

        .app-header {
          background-color: #183D4A;
          color: white;
          padding: 1rem;
          border-top-left-radius: 10px;
          border-top-right-radius: 10px;
          position: relative;
        }

        .app-header::after {
          content: '';
          position: absolute;
          top: 0;
          right: 0;
          width: 80px;
          height: 100%;
          background: url('https://via.placeholder.com/80x80') no-repeat;
          background-size: cover;
          border-top-right-radius: 10px;
        }

        .entry-card {
          background-color: white;
          border-radius: 15px;
          padding: 1rem;
          box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
          margin-top: 1rem;
        }

        .entry-item {
          border-bottom: 1px solid #ccc;
          padding: 0.5rem 0;
        }

        .entry-label {
          font-weight: bold;
        }

        .footer-menu {
          background-color: #183D4A;
          color: white;
          position: fixed;
          bottom: 0;
          left: 0;
          width: 100%;
          display: flex;
          justify-content: space-around;
          padding: 0.5rem 0;
          border-top-left-radius: 10px;
          border-top-right-radius: 10px;
        }

        .footer-menu i {
          font-size: 1.5rem;
        }

        .btn-add {
          position: absolute;
          right: 15px;
          top: 15px;
          background-color: transparent;
          border: none;
          color: #183D4A;
          font-size: 1.2rem;
        }
      </style>
      <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
      <script>
        function toggleForm() {
          const form = document.getElementById('transactionForm');
          form.classList.toggle('d-none');
        }
      </script>
    </head>

    <body>
      <div class="container mt-4 mb-5">
        <div class="app-header rounded-top">
          <h4>EcoFin</h4>
        </div>

        <div class="entry-card position-relative">
          <!-- botão que mostra/oculta o form -->
          <button class="btn btn-success" onclick="toggleForm()">
            Adicionar nova saída
          </button>

          <!-- formulário inicialmente escondido -->
          <form id="transactionForm" action="${pageContext.request.contextPath}/saidas" method="post"
            class="mb-4 mt-2 d-none">
            <div class="mb-2">
              <label for="amount" class="form-label">Valor (R$)</label>
              <input type="number" step="0.01" name="amount" id="amount" class="form-control" required>
            </div>
            <div class="mb-2">
              <label for="date" class="form-label">Data</label>
              <input type="date" name="date" id="date" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-success">Salvar</button>
          </form>

        </div>
        <div class="entry-card position-relative">
          <p class="text-muted fw-bold">Saídas:</p>

          <!-- Se não houver nenhuma saída -->
          <c:if test="${empty saidas}">
            <div class="entry-item border-0">
              <p class="text-center text-muted">Não há dados de saída para exibir.</p>
            </div>
          </c:if>

          <!-- Lista de saídas -->
          <c:forEach var="e" items="${saidas}" varStatus="st">
            <div class="entry-item ${st.last ? 'border-0' : ''}">
              <div>
                <span class="entry-label">Valor:</span>
                R$ ${e.amount}
                <span class="float-end">Data ${e.date}</span>
              </div>
            </div>
          </c:forEach>
        </div>

        <!-- seu footer-menu -->
    </body>

    </html>