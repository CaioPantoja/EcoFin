<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>EcoFin - Login</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #e0e0e0;
      font-family: 'Segoe UI', sans-serif;
    }

    .container {
      max-width: 360px;
      margin: 50px auto;
      background-color: #fff;
      border-radius: 1rem;
      box-shadow: 0 10px 20px rgba(0,0,0,0.1);
      overflow: hidden;
    }

    .header {
      background-color: #264653;
      color: #fff;
      text-align: center;
      padding: 2rem 1rem 1rem;
    }

    .header h1 {
      font-size: 1.8rem;
      font-weight: bold;
    }

    .form-container {
      padding: 1rem 2rem 2rem;
    }

    .form-container input {
      border: none;
      border-bottom: 1px solid #333;
      border-radius: 0;
    }

    .btn-custom {
      background-color: #264653;
      color: #fff;
      width: 100%;
      border-radius: 1rem;
      font-weight: bold;
      margin-top: 1rem;
    }

    .link-small {
      font-size: 0.8rem;
    }

    .erro {
      color: red;
      font-size: 0.9rem;
    }
  </style>
</head>
<body>

<div class="container">
  <div class="header">
    <h1>EcoFin</h1>
  </div>

  <div class="form-container">
    <form action="login" method="post">
      <div class="mb-3">
        <label class="form-label">E-mail:</label>
        <input type="email" class="form-control" name="email" required />
      </div>
      <div class="mb-2">
        <label class="form-label">Senha:</label>
        <input type="password" class="form-control" name="password" required />
      </div>
      <div class="mb-3 text-end">
        <a href="#" class="link-small">Esqueceu a senha? Clique aqui.</a>
      </div>

      <% if (request.getAttribute("erro") != null) { %>
        <div class="erro"><%= request.getAttribute("erro") %></div>
      <% } %>

      <button type="submit" class="btn btn-custom">Login</button>
    </form>
  </div>
</div>

</body>
</html>
