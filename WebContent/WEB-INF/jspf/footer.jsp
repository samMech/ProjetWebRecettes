<%@page session="true" contentType="text/html" pageEncoding="UTF-8"%>

<%--Importation des librairies JSTL--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--Initialisation de la locale--%>
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="ressources_i18n.Locale"/>

<br/>
<footer class="navbar-default footer">
  <div class="container-fluid text-center">
    <p><span class="glyphicon glyphicon-copyright-mark"></span> <fmt:message key="footer.copyright"/></p>
  </div>
</footer>
