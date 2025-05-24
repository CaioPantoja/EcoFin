<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>EcoFin Saídas</title>
  <style>
    :root { font-size: 62.5%; }
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      font-family: 'Segoe UI', sans-serif;
      background-color: #D9D9D9;
      color: #333;
    }
    .container {
      margin: 0 auto;
      padding: 4rem 3rem;
      background-color: #D9D9D9;
      min-height: 100vh;
    }
    .card {
      background: #ffffff;
      border-radius: 1rem;
      box-shadow: 0 0.2rem 0.6rem rgba(0, 0, 0, 0.1);
      overflow: hidden;
    }
    .card-header {
      background-color: #2d4b5a;
      color: white;
      padding: 1.2rem;
    }
    .card-body {
      padding: 1.2rem;
    }
    .transaction-table {
      width: 100%;
      border-collapse: collapse;
      background: white;
      border-radius: 1rem;
      overflow: hidden;
      box-shadow: 0 0.2rem 0.6rem rgba(0,0,0,0.1);
      margin-top: 2rem;
    }
    .transaction-table th,
    .transaction-table td {
      padding: 1.2rem;
      text-align: left;
      font-size: 1.4rem;
    }
    .transaction-table thead {
      background-color: #2d4b5a;
      color: white;
    }
    .transaction-table tbody tr:nth-child(even) {
      background-color: #f2f2f2;
    }
    .transaction-table tbody tr:hover {
      background-color: #e0e0e0;
    }
    .transaction-title {
      font-size: 1.8rem;
      color: #2d4b5a;
      margin-top: 2rem;
    }

    /* utilitários de espaçamento */
    .mb-3 { margin-bottom: 1.5rem; }
    .mb-4 { margin-bottom: 2rem; }
    .text-center { text-align: center; }

    /* estilização de labels */
    .form-label {
      display: block;
      font-size: 1.4rem;
      font-weight: 600;
      margin-bottom: 0.5rem;
      color: #2d4b5a;
    }

    /* estilização de inputs */
    .form-control {
      width: 100%;
      padding: 0.8rem 1rem;
      font-size: 1.4rem;
      border: 1px solid #ccc;
      border-radius: 0.5rem;
      outline: none;
      transition: border-color 0.2s;
    }
    .form-control:focus {
      border-color: #2d4b5a;
    }

    /* estilização de botões */
    .btn {
      display: inline-block;
      font-size: 1.4rem;
      padding: 0.8rem 1.2rem;
      border: none;
      border-radius: 0.5rem;
      cursor: pointer;
      text-decoration: none;
      text-align: center;
      transition: background-color 0.2s;
    }
    .btn-success {
      background-color: #2d4b5a;
      color: #fff;
    }
    .btn-success:hover {
      background-color: #253f4a;
    }
    .btn-primary {
      background-color: #2d4b5a;
      color: #fff;
    }
    .btn-primary:hover {
      background-color: #253f4a;
    }

    /* mostrar/ocultar form */
    #transactionForm.d-none { display: none; }
  </style>
  <script>
    function toggleForm() {
      document.getElementById('transactionForm')
              .classList.toggle('d-none');
    }
  </script>
</head>

<body>
  <ui:header />
  <div class="container">
    <div class="card">
      <!-- Cabeçalho -->
      <div class="card-header">
        <h2>Saídas</h2>
      </div>

      <!-- Corpo da card -->
      <div class="card-body">
        <!-- Botão para abrir form -->
        <button class="btn btn-success mb-3" onclick="toggleForm()">
          Adicionar nova saída
        </button>

        <!-- Form de cadastro -->
        <form id="transactionForm"
              action="${pageContext.request.contextPath}/saidas"
              method="post"
              class="d-none mb-4">
          <div class="mb-3">
            <label for="amount" class="form-label">Valor (R$)</label>
            <input type="number" step="0.01"
                   name="amount" id="amount"
                   class="form-control" required>
          </div>
          <div class="mb-3">
            <label for="date" class="form-label">Data</label>
            <input type="date"
                   name="date" id="date"
                   class="form-control" required>
          </div>
          <button type="submit" class="btn btn-primary">
            Salvar
          </button>
        </form>

        <!-- Título da tabela -->
        <h3 class="transaction-title">Lista de Saídas</h3>

        <!-- Tabela de resultados -->
        <table class="transaction-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Conta</th>
              <th>Valor</th>
              <th>Data</th>
            </tr>
          </thead>
          <tbody>
            <!-- mensagem se vazio -->
            <c:if test="${empty saidas}">
              <tr>
                <td colspan="4" class="text-center">
                  Nenhuma saída encontrada.
                </td>
              </tr>
            </c:if>

            <!-- iteração das saídas -->
            <c:forEach var="e" items="${saidas}">
              <tr>
                <td>${e.transactionId}</td>
                <td>${e.accountName}</td>
                <td>R$ ${e.amount}</td>
                <td>${e.date}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <ui:menu active="Out"/>
</body>
</html>
