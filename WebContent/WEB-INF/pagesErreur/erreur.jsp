<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%--Importation des librairies JSTL--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--Initialisation de la locale--%>
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="ressources_i18n.Locale"/>

<!DOCTYPE html>
<html>
<head>
	<title><fmt:message key="application.nom"/></title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/styles.css">
</head>
<body>

	<!--La barre de navigation-->
	<jsp:include page="../jspf/navbar.jsp"></jsp:include>

	<!--Le contenu central-->  
	<div class="container-fluid">
		<div class="row content">
	  					
			<!--La barre de navigation gauche-->
			<div class="col-lg-2 hidden-md"></div>
			
			<!--Le panneau central-->	
			<div class="col-lg-8">
								
				<!--Le contenu-->
				<div class="row">
					
					<!-- Bordure gauche -->
					<div class="col-sm-2"></div>
								
					<!--Le texte de bienvenue-->	
					<div class="col-sm-8 text-center">		
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3><fmt:message key="application.nom"/></h3>
							</div>
							<div class="panel body">
								<h3><span class="label label-danger"><fmt:message key="erreur.info.messageerreur"/></span></h3>
							</div>
							<div class="panel-footer">
								<a href="ConnexionServlet"><fmt:message key="erreur.info.retour"/></a>
							</div>												
						</div>
					</div>
					
					<!-- Bordure droite -->
					<div class="col-sm-2"></div>
					
				</div>
			</div>
				
			<!--La barre de navigation droite-->
			<div class="col-lg-2 hidden-md"></div>
		
		</div>
	</div>

	<!--Le bas de page-->
	<jsp:include page="../jspf/footer.jsp"></jsp:include>

</body>
</html>