<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/styles.css">
	<script type="text/javascript" src="scripts/required-field.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/required-field-block.css">
	<script type="text/javascript" src="scripts/dynamicList.js"></script>
</head>
<body>

	<!--La barre de navigation-->
	<jsp:include page="jspf/navbar.jsp"></jsp:include>

	<!--Le contenu central-->  
	<div class="container-fluid">
		<div class="row content">
	  					
			<!--La barre de navigation gauche-->
			<div class="col-lg-2 hidden-xs"></div>
			
			<!--Section de contenu-->
			<div class="col-lg-8">
				<div class="panel panel-primary">
					<div class="panel-heading text-center">
						<h1>${recette.nomRecette}</h1>
					</div>
					<div class="panel-body">
						<p>${recette.descriptionRecette}</p>
						<h4><span class="label label-info"><fmt:message key="viewrecette.info.prepTime"/> ${requestScope.dureeRecette}</span></h4>
					</div>
				</div>
				
				<div class="row">
				
					<!--Menu de navigation-->
					<div class="col-sm-2 col-sm-push-10 text-center">	
						<ul class="nav nav-pills nav-stacked" data-spy="affix" data-offset-top="160">
							<li>
								<form method="POST" action="RecetteServlet">
									<input type="hidden" name="idRecetteToModify" value="${recette.idRecette}">
									<input type="hidden" name="action" value="modifierRecette">	
									<button type="submit" class="btn btn-primary" id="modifier">
										<span class="glyphicon glyphicon-edit"></span> <span class="espacement"><fmt:message key="viewrecette.modifier.button"/>    </span>
									</button>
								</form>	
							</li>
							<br>
							<li>
								<form method="POST" action="RecetteServlet">
									<input type="hidden" name="idRecetteToDelete" value="${recette.idRecette}">
									<input type="hidden" name="action" value="supprimerRecette">
									<button type="submit" class="btn btn-primary" id="Supprimer">
										<span class="glyphicon glyphicon-trash"></span> <span class="espacement"><fmt:message key="viewrecette.supprimer.button"/></span>
									</button>
								</form>							
							</li>							
						</ul>
						<br />
					</div>
				
					<!--Les ingrédient-->				
					<div class="col-sm-4 col-sm-pull-2">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3><fmt:message key="viewrecette.ingredients.titre"/></h3>
							</div>
							<div class="panel-body">
								<div class="list-group">
									<ul id="listeIngredients">
										<c:forEach var="mesure" items="${recette.mesures}">
											<li>${mesure.ingredient.nomIngredient} : ${mesure.quantite}<fmt:message key="application.unites.${mesure.unite.nomUnite}"/></li><br />
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
					</div>
				
					<!--Les instructions-->
					<div class="col-sm-6 col-sm-pull-2">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3><fmt:message key="viewrecette.instructions.titre"/></h3>
							</div>
							<div class="panel-body">
								<div class="list-group">
									<ol id="listeInstructions">									
										<c:forEach var="instruction" items="${recette.instructions}">
											<li>${instruction.descInstruction}</li>
											<br>
										</c:forEach>										
									</ol>
								</div>
							</div>
						</div>
					</div>
				
				</div>
			</div>
			
			<!--La barre de navigation droite-->
			<div class="col-lg-2 hidden-xs"></div>	
		</div>
	</div>

	<!--Le bas de page-->
	<jsp:include page="jspf/footer.jsp"></jsp:include>

</body>
</html>