<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8" />
  <title>EcoFin - Login</title>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
  <style>
    body {
      background-color: #e0e0e0;
      font-family: 'Segoe UI', sans-serif;
      min-height: 100vh;
      display: flex;
      flex-direction: column;
    }

    .container-login {
      max-width: 600px;
      width: 100%;
      background-color: #fff;
      border-radius: 1rem;
      box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
      overflow: hidden;
      margin: auto;
    }

    .login-wrapper {
      flex: 1;
      display: flex;
      align-items: center;
      justify-content: center;
      padding: 20px;
    }

    .toggle-buttons {
      display: flex;
      justify-content: center;
      background-color: #f8f9fa;
      padding: 1rem 0;
      border-bottom: 1px solid #ddd;
    }

    .toggle-buttons a {
      margin: 0 10px;
      text-decoration: none;
      font-weight: bold;
      color: #264653;
      padding: 8px 20px;
      border-radius: 20px;
      transition: background-color 0.3s;
    }

    .toggle-buttons a.active,
    .toggle-buttons a:hover {
      background-color: #264653;
      color: #fff;
    }

    .form-container {
      padding: 2rem;
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

<ui:header />


<div class="login-wrapper">
  <div class="container-login">

    <div class="toggle-buttons">
      <a href="login.jsp" class="active">Login</a>
      <a href="sign-up.jsp">Sign In</a>
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
</div>

</body>
</html>