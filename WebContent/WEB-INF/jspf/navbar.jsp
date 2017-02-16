<%@page session="true" contentType="text/html" pageEncoding="UTF-8"%>

<%--Importation des librairies JSTL--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--Initialisation de la locale--%>
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="ressources_i18n.Locale"/>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-left" href="ConnexionServlet"><img class="img-responsive img-rounded" src="images/logo.png" alt="logo.png"/></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">	
			<ul class="nav navbar-nav">
				<li><a href="ConnexionServlet"><span class="glyphicon glyphicon-home"></span> <fmt:message key="navbar.accueil"/></a></li>
				
				<c:if test="${sessionScope.Usager != null}">
					<li class="active"><a href="RechercheServlet"><fmt:message key="navbar.nouvelleListe"/></a></li>
					<li><a href="RecetteServlet?action=chargerFormulaire"><fmt:message key="navbar.nouvelleRecette"/></a></li>
					<li>
						<form class="navbar-form" id="formRechercheRapide" action="RechercheServlet?action=QUICK_SEARCH">
							<div class="form-group input-group">
								<input type="text" class="form-control" placeholder="<fmt:message key="navbar.rechercheRapide"/>" name="texteRecherche" id="texteRecherche">
								<div class="input-group-btn">
									<button class="btn btn-primary" type="submit" id="rechercheRapide"><i class="glyphicon glyphicon-search"></i></button>
								</div>
							</div>
						</form>
					</li>
				</c:if>
				
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<li>
					<c:choose>
						<c:when test='${! sessionScope.langue.equals("fr")}'>
							<a href="I18nServlet?langue=fr"><span class="glyphicon glyphicon-globe"></span> Français</a>
						</c:when>
						<c:when test='${! sessionScope.langue.equals("en")}'>
							<a href="I18nServlet?langue=en"><span class="glyphicon glyphicon-globe"></span> English</a>
						</c:when>
					</c:choose>			
				</li>
				<li>
									
					<c:choose>
					   <c:when test="${sessionScope.Usager != null}">
					       <a href="ConnexionServlet?action=DECONNEXION"><span class="glyphicon glyphicon-log-out"></span> <fmt:message key="navbar.logout"/></a> 
					    </c:when>
					    <c:otherwise>
					        <a href="ConnexionServlet"><span class="glyphicon glyphicon-log-in"></span> <fmt:message key="navbar.login"/></a>
					    </c:otherwise>
					</c:choose>
					
				</li>
			</ul>			
		</div>
	</div>
</nav>
<br><br><br><br>