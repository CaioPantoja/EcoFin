<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8" />
    <title>Criar Nova Conta</title>
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
        .login-wrapper {
            flex: 1;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }
        .container-login {
            max-width: 800px;
            width: 100%;
            background-color: #fff;
            border-radius: 1rem;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }
        .form-container {
            padding: 2rem;
        }
        .accounts-list {
            margin-top: 2rem;
            border-top: 1px solid #eee;
            padding-top: 1rem;
        }
    </style>
</head>
<body>

<ui:header />

<div class="login-wrapper">
    <div class="container-login">
        <div class="form-container">
            <%-- Mensagens --%>
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        ${errorMessage}
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>

            <c:if test="${not empty successMessage}">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                        ${successMessage}
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>

            <h2 class="text-center mb-4">Criar Nova Conta</h2>

            <form action="novaConta" method="post">
                <div class="mb-3">
                    <label for="name" class="form-label">Nome da Conta:</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>

                <div class="mb-3">
                    <label for="accountType" class="form-label">Tipo de Conta:</label>
                    <select class="form-select" id="accountType" name="accountType" required>
                        <option value="Checking">Conta Corrente</option>
                        <option value="Savings">Conta Poupança</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="balance" class="form-label">Saldo Inicial (USD):</label>
                    <input type="number" class="form-control" id="balance" name="balance"
                           step="0.01" min="0" required>
                </div>

                <button type="submit" class="btn btn-primary w-100">Criar Conta</button>
            </form>

            <%-- Lista de contas existentes --%>
            <c:if test="${not empty contasUsuario}">
                <div class="accounts-list">
                    <h5 class="mb-3">Suas Contas</h5>
                    <div class="list-group">
                        <c:forEach items="${contasUsuario}" var="conta">
                            <div class="list-group-item">
                                <h6>${conta.name}</h6>
                                <div>
                                    <span class="badge bg-${conta.accountType == 'Checking' ? 'primary' : 'success'}">
                                            ${conta.accountType == 'Checking' ? 'Corrente' : 'Poupança'}
                                    </span>
                                    <span class="ms-2">
                                        Saldo: <fmt:formatNumber value="${conta.balance}" type="currency" currencyCode="USD"/>
                                    </span>
                                </div>
                                <small class="text-muted">Nº ${conta.id}</small>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
<ui:menu/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>