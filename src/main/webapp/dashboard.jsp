<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.fiap.model.Transaction" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>EcoFin Dashboard</title>
    <style>
        :root {
            font-size: 62.5%;
        }
        * { box-sizing: border-box; margin: 0; padding: 0; }
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f5f5f5;
            color: #333;
        }
        .container {
            margin: 0 auto;
            padding: 4rem 3rem;
            background-color: #D9D9D9;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            gap: 2rem;
        }
        .top-cards {
            display: flex;
            justify-content: space-between;
            align-items: center;
            gap: 1rem;
        }
        .card {
            flex: 1;
            background: #ffffff;
            border-radius: 1rem;
            box-shadow: 0 0.2rem 0.6rem rgba(0,0,0,0.1);
            padding: 1.2rem;
        }
        .card h2 {
            font-size: 1.2rem;
            color: #666;
        }
        .card .value {
            font-size: 1.8rem;
            font-weight: bold;
            color: #2d4b5a;
            margin-top: 0.4rem;
        }
        .highlight {
            background-color: #2d4b5a;
            color: white;
        }
        .highlight .value {
            color: #ffffff;
        }
        .filter-icon {
            width: 6rem;
            height: 6rem;
            background: #2d4b5a;
            border-radius: 30%;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .filter-icon img {
            width: 1.6rem;
            height: 1.6rem;
        }
        .card-filter {
            display: flex;
            gap: 1rem;
            flex: 1;
        }

        .transaction-table {
            width: 100%;
            border-collapse: collapse;
            background: white;
            border-radius: 1rem;
            overflow: hidden;
            box-shadow: 0 0.2rem 0.6rem rgba(0,0,0,0.1);
        }

        .transaction-table th, .transaction-table td {
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
    </style>
</head>
<body>
<div class="container">
    <div class="top-cards">
        <div class="card highlight">
            <h2 style="color: white">Receita Total:</h2>
            <p class="value">${totalBalance}</p>
        </div>
        <div class="card-filter">
            <div class="card">
                <h2>A alcançar:</h2>
                <p class="value" style="color: #2ca58d;">${amountMissing}</p>
            </div>
            <div class="filter-icon">
                <img src="https://i.ibb.co/zW0jGFG8/Vector.png" alt="Filtro" />
            </div>
        </div>
    </div>

    <h3 class="transaction-title">Últimas Transações</h3>
    <table class="transaction-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Conta</th>
            <th>Tipo</th>
            <th>Valor</th>
            <th>Data</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
            if (transactions != null && !transactions.isEmpty()) {
                for (Transaction t : transactions) {
        %>
        <tr>
            <td><%= t.getTransactionId() %></td>
            <td><%= t.getAccountName() %></td>
            <td><%= t.getType() %></td>
            <td>R$ <%= String.format("%.2f", t.getAmount()) %></td>
            <td><%= t.getDate() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr><td colspan="5">Nenhuma transação encontrada.</td></tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
