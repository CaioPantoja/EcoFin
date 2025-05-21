<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" %>
<html>
<head>
    <title>Login - Fintech</title>
</head>
<body>
<h2>Login</h2>
<form action="login" method="post">
    <label>Email:</label><br/>
    <input type="email" name="email" required><br/><br/>

    <label>Senha:</label><br/>
    <input type="password" name="password" required><br/><br/>

    <input type="submit" value="Entrar"><br/><br/>

    <a href="register.jsp">Ainda não tem conta? Cadastre-se</a>
</form>

<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
<p style="color: red;"><%= error %></p>
<%
    }
%>
</body>
</html>
