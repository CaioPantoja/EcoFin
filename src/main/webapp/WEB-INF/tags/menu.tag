<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="active" required="false" rtexprvalue="true" %>

<%--
  Tag file: bottomnav.tag
  Path: src/main/webapp/WEB-INF/tags/bottomnav.tag
  Usage in JSP:
    <%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
    <ui:bottomnav active="Home" />
--%>

<div style="position: fixed; bottom: 0; left: 0; width: 100%; height: 100px; display: flex; justify-content: center; align-items: center; z-index: 1000;">
  <div style="width: 350px; height: 60px; background-color: #1C3C5A; display: flex; justify-content: space-around; align-items: center; border-radius: 16px; box-shadow: 0 -2px 8px rgba(0,0,0,0.2);">
    <a href="${pageContext.request.contextPath}/dashboard" style="text-decoration: none;padding:10px;${active == 'Home' ? 'background-color: #3C6E71; border-radius:100%' : ''}">
      <img src="https://i.ibb.co/9HrSFRSR/Vector.png"" alt="Home" style="width:24px; height:24px;"/>
    </a>
    <a href="${pageContext.request.contextPath}/entradas" style="text-decoration: none;padding:10px;${active == 'In' ? 'background-color: #3C6E71; border-radius:100%' : ''}">
      <img src="https://i.ibb.co/C5hX2NFQ/Vector-1.png" alt="In" style="width:24px; height:24px;"/>
    </a>
    <a href="${pageContext.request.contextPath}/saidas" style="text-decoration: none;padding:10px;${active == 'Out' ? 'background-color: #3C6E71; border-radius:100%' : ''}">
      <img src="https://i.ibb.co/cSpxhQbp/Vector-2.png"" alt="Out" style="width:24px; height:24px;"/>
    </a>
    <a href="${pageContext.request.contextPath}/" style="text-decoration: none;padding:10px;${active == 'transaction' ? 'background-color: #3C6E71; border-radius:100%' : ''}">
      <img src="https://i.ibb.co/PsDbbd7p/octicon-goal-24.png"" alt="transaction" style="width:24px; height:24px;"/>
    </a>
    <a href="${pageContext.request.contextPath}/" style="text-decoration: none;padding:10px;${active == 'Profile' ? 'background-color: #3C6E71; border-radius:100%' : ''}">
      <img src="https://i.ibb.co/KxNJCS3g/Vector-3.png"" alt="Profile" style="width:24px; height:24px;"/>
    </a>
  </div>
</div>
