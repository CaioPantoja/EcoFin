
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>EcoFin - Entradas</title>
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
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
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
</head>
<body>
  <div class="container mt-4 mb-5">
    <div class="app-header rounded-top">
      <h4>EcoFin</h4>
    </div>

    <div class="entry-card position-relative">
      <button class="btn-add"><i class="fas fa-plus"></i></button>
      <p class="text-muted fw-bold">Entradas:</p>

      <div class="entry-item">
        <span class="entry-label">Salário:</span><br>
        R$ 10.000,00 <span class="float-end">Data 10/08/2024</span>
        <i class="fas fa-pen float-end me-2"></i>
      </div>
      <div class="entry-item">
        <span class="entry-label">Salário:</span><br>
        R$ 10.000,00 <span class="float-end">Data 10/07/2024</span>
        <i class="fas fa-pen float-end me-2"></i>
      </div>
      <div class="entry-item border-0">
        <span class="entry-label">Renda Aluguel:</span><br>
        R$ 7.000,00 <span class="float-end">Data 07/07/2024</span>
        <i class="fas fa-pen float-end me-2"></i>
      </div>
    </div>
  </div>

  <div class="footer-menu">
    <i class="fas fa-home"></i>
    <i class="fas fa-arrow-down"></i>
    <i class="fas fa-arrow-up"></i>
    <i class="fas fa-chart-line"></i>
    <i class="fas fa-user"></i>
  </div>
</body>
</html>
