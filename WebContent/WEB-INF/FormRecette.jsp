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
			<div class="col-sm-2 col-lg-3 hidden-xs"></div>

			<!--Le panneau central-->
			<div class="col-sm-8 col-lg-6 text-left">

				<div class="panel panel-primary">
					<div class="panel-heading text-center">
						<h1>Nouvelle recette</h1>
					</div>
				</div>

				<!--Section Formulaire-->
				<form id="formRecette" method="POST" action="RecetteServlet">
					<!--Première section -->
					<div class="panel panel-info">
						<div class="panel-heading text-center">
							<h3>Informations générales</h3>
						</div>
						<div class="panel-body">
							<!--Section nom-->
							<div class="form-group">
								<label for="nomRecette">Nom </label>
								<div class="required-field-block">
									<input type="text" class="form-control" id="nomRecette"
										name="nomRecette" required>
									<div class="required-icon">
										<div class="text">*</div>
									</div>
								</div>
							</div>
							
							<!-- Section Type de recette-->
							<div class="form-group">
								<label for="typeRecette">Type </label>
								<div class="required-field-block">
									<select	class="form-control form-control-inline" id="typeRecette" name="typeRecette">
										<c:forEach var="type" items="${requestScope.typesRecette}">
											<option value="${type.idType}"><fmt:message key="application.typeRecette.${type.typeRecette}"/></option>
										</c:forEach>		
									</select>
								</div>
							</div>

							<!--Section description-->
							<div class="form-group">
								<label for="descRecette">Description</label>
								<textarea class="form-control" id="descRecette"
									name="descRecette"></textarea>
							</div>

							<!--Section temps de preparation -->
							<div class="form-group">
								<label for="tempsRecette">Temps de préparation</label>
								<div class="form-inline" id="tempsRecette">
									<input class="form-control form-control-inline" type="number" min="0" step="1" max="99" id="heureRecette" name="heureRecette" value="0">
									<label for="heureRecette">h</label> 
									<input class="form-control form-control-inline"	type="number" min="0" step="1" max="59" id="minRecette"	name="minRecette" value="0">
									<label for="minRecette"> m</label>
								</div>
							</div>
						</div>
					</div>
					<!--Section Ingrédients-->
					<div class="panel panel-info">
						<div class="panel-heading text-center">
							<h3>Ingrédients</h3>
						</div>
						<div class="panel-body">
							<ul class="list-group">
								<li class="list-group-item noBorder media">
									<div class="form-group media-body autoWidth">
										<select	class="form-control form-control-inline" name="categorie1">
											<c:forEach var="categorie" items="${requestScope.categories}">
											<option value="${categorie.idCategorieIng}"><fmt:message key="application.categorieIngredient.${categorie.nomCategorieIng}"/></option>
										</c:forEach>
										</select>
										<input class="form-control form-control-inline" type="text"	size="22" placeholder="Ingrédient"	name="nomIngredient1" /> 
										<input class="form-control form-control-inline" type="text" size="5" placeholder="Quantité" name="qte1" />
										<select	class="form-control form-control-inline" name="unite1">
											<option value="0">---</option>
											<c:forEach var="unit" items="${requestScope.unites}">
												<option value="${unit.idUnite}"><fmt:message key="application.unites.${unit.nomUnite}"/></option>
											</c:forEach>
										</select>
									</div>
									<div class="media-right media-middle">
										<span class="mouseIcon glyphicon glyphicon-plus-sign green" onclick="ajouterIngredient(this)"></span>
										<span class="mouseIcon glyphicon glyphicon-minus-sign red" onclick="supprimerIngredient(this)"></span>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<!-- Section instructions -->
					<div class="panel panel-info">
						<div class="panel-heading text-center">
							<h3>Instructions</h3>
						</div>
						<div class="panel-body">
							<ul class="list-group">
								<li class="list-group-item noBorder media">
									<div class="media-left media-top">
										<label for="instruction1">1.</label>
									</div>
									<div class="media-body autoWidth">
										<textarea cols="100" placeholder="Instruction"
											class="form-control" name="instruction1"></textarea>
									</div>
									<div class="media-right media-middle">
										<span
											class="span3 mouseIcon glyphicon glyphicon-plus-sign green" onclick="ajouterInstruction(this)"></span>
										<span
											class="span3 mouseIcon glyphicon glyphicon-minus-sign red" onclick="supprimerInstruction(this)"></span>
									</div>
									<div class="media-right media-middle">
										<span
											class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-up blue" onclick="monterInstruction(this)"></span>
										<span
											class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-down blue" onclick="descendreInstruction(this)"></span>
									</div>
								</li>
								
							</ul>
						</div>
					</div>

					<!-- Section bouton enregistrer -->
					<button type="submit" class="btn btn-primary pull-left"
						id="btnSubmitRecette">Enregistrer</button>
					<input type="hidden" name="action" value="ajouterRecette">
				</form>

				<!--La barre de navigation droite-->
				<div class="col-sm-2 col-lg-3 hidden-xs"></div>

			</div>
		</div>

		<!--Le bas de page-->
	<jsp:include page="jspf/footer.jsp"></jsp:include>
	</div>
</body>
</html>