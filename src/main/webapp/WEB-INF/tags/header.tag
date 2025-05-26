<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false" rtexprvalue="true" %>

<%--
  Tag file: header.tag
  Caminho: src/main/webapp/WEB-INF/tags/header.tag
  Uso em JSP: <%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
             <ui:header title="EcoFin" />
--%>

<header style="
  background-color: #284B63;
  height: 100px;
  display: flex;
  align-items: end;
  justify-content: start;
  padding: 10px 24px;
  border-radius: 0px 0px 20px 20px;
">
  <h1 style="
    margin: 0;
    color: #FFFFFF;
    font-family: Arial, sans-serif;
    font-size: 3.5rem;
  ">
    EcoFin
  </h1>
</header>
