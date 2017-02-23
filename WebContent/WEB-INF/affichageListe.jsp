<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%--Importation des librairies JSTL--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--On vérifie si l'usager est toujours connecté--%>
<c:if test="${sessionScope.Usager == null}">
	<%--Redirection vers la page de bienvenue--%>
	<jsp:forward page="/ConnexionServlet"></jsp:forward>
</c:if>

<%--Initialisation de la locale--%>
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="ressources_i18n.Locale"/>

<!DOCTYPE html>
<html>
<head>
	<title><fmt:message key="application.nom"/></title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/styles.css">
</head>
<body>

	<!--La barre de navigation-->
	<jsp:include page="jspf/navbar.jsp"></jsp:include>
	
	<!--Le contenu central-->  
	<div class="container-fluid">
		<div class="row content">
	  					
			<!--La barre de navigation gauche-->
			<div class="col-md-2 col-lg-3 hidden-sm"></div>
			
			<!--Le panneau central-->	
			<div class="col-md-8 col-lg-6">
				
				<!--Titre de la page-->
				<div class="panel panel-primary text-center">
					<div class="panel-heading">
						<h1>Liste d'épicerie finale</h1>
					</div>
				</div>
				
				<!--Le contenu-->
				<div class="panel panel-info">
					<div class="panel-body row">						
						<div class="col-sm-2 hidden-xs"></div>
						
						<div class="list-group col-sm-8">
							<div class="row">
							
								<!--Liste d'épicerie-->
								<div class="col-xs-8 col-sm-10">
									
									<div class="list-group-item-text col-xs-offset-1">
										<h4 class="list-group-item-heading page-header">Liste d'épicerie</h4>
										<ul id="listeIngredients">
											<c:forEach var="mesure" items="${recette.mesures}">
												<li>${mesure.ingredient.nomIngredient} : ${mesure.quantite}<fmt:message key="application.unites.${mesure.unite.nomUnite}"/></li><br />
											</c:forEach>
										</ul>
									</div>
								</div>
								
								<!--Menu de navigation-->
								<nav class="col-xs-4 col-sm-2">
									<ul class="nav nav-pills nav-stacked" data-spy="affix" data-offset-top="160">
										<li><button type="submit" class="btn btn-primary" id="imprimer"><span class="glyphicon glyphicon-print"></span> Imprimer</button></li>
										<li><button type="submit" class="btn btn-primary" id="connexion"><span class="glyphicon glyphicon-send"></span> Envoyer</button></li>
									</ul>
								</nav>
								
							</div>							
						</div>
						
						<div class="col-sm-2 hidden-xs"></div>
					</div>
				</div>
				
				<!--Retour à la page précédente-->
				<ul class="pager text-center">
					<li><a href="modificationListe.html">Retour</a></li>
				</ul>
				
			</div>
				
			<!--La barre de navigation droite-->
			<div class="col-md-2 col-lg-3 hidden-sm"></div>
		</div>
	</div>		

	<!--Le bas de page-->
	<jsp:include page="jspf/footer.jsp"></jsp:include>
	
</body>
</html>