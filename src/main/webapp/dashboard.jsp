<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

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
            gap: 1.6rem;
        }

        .header {
            background-color: #2d4b5a;
            color: white;
            padding: 1.6rem;
            border-radius: 1rem 1rem 0 0;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header h1 {
            font-size: 2rem;
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

        .chart-card {
            display: flex;
            flex-direction: column;
            flex: 1;
            gap: 4rem;
            background: #f3f3f3;
            border-radius: 1.2rem;
            padding: 1rem;
        }

        .chart-card h3 {
            font-size: 1.4rem;
            margin-bottom: 0.8rem;
            color: #2d4b5a;
        }

        .chart-card img {
            width: 100%;
            border-radius: 0.8rem;
        }

        .nav {
            background: #2d4b5a;
            display: flex;
            justify-content: space-around;
            align-items: center;
            border-radius: 0 0 1rem 1rem;
            padding: 1rem 0;
            margin-top: auto;
        }

        .nav a {
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 1rem;
            border-radius: 50%;
            width: 3.6rem;
            height: 3.6rem;
        }

        .nav img {
            width: 2rem;
            height: 2rem;
        }

        .nav a.active {
            background-color: #ffffff30;
        }

        .charts {
            display: flex;
            justify-content: space-between;
            gap: 7rem;
        }

        .card-filter {
            display: flex;
            gap: 1rem;
            flex: 1;
        }

        @media (max-width: 1440px) {
            .charts {
                flex-direction: column;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <div class="top-cards">
        <div class="card highlight">
            <h2>Receita Total:</h2>
            <p class="value">${totalBalance}</p>
        </div>
        <div class="card-filter">
            <div class="card">
                <h2>A alcançar:</h2>
                <p class="value" style="color: #2ca58d;">R$ 1.390,90</p>
            </div>
            <div class="filter-icon">
                <img src="https://i.ibb.co/zW0jGFG8/Vector.png" alt="Filtro" />
            </div>
        </div>
    </div>

    <div class="charts">
        <div class="chart-card">
            <h3>Movimentação / Mês:</h3>
            <img src="https://i.ibb.co/mr0DnkJd/transaction-Grafhic.png" alt="Transacton Graffic" />
        </div>

        <div class="chart-card">
            <h3>Receita / Mês:</h3>
            <img src="https://i.ibb.co/yKht4p2/Group-9.png" alt="Recipes Graffic" />
        </div>
    </div>

</div>
</body>
</html>
