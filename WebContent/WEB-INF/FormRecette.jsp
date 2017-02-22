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
						<h1><fmt:message key="formrecette.titre"/></h1>
					</div>
				</div>

				<!--Section Formulaire-->
				<form id="formRecette" method="POST" action="RecetteServlet">
					<!--Première section -->
					<div class="panel panel-info">
						<div class="panel-heading text-center">
							<h3><fmt:message key="formrecette.info.titre"/></h3>
						</div>
						<div class="panel-body">
							<!--Section nom-->
							<div class="form-group">
								<label for="nomRecette"><fmt:message key="formrecette.info.nom"/></label>
								<div class="required-field-block">
									<input type="text" class="form-control" id="nomRecette"
										name="nomRecette" required value="${recette.nomRecette}">
									<div class="required-icon">
										<div class="text">*</div>
									</div>
								</div>
							</div>
							
							<!-- Section Type de recette-->
							<div class="form-group">
								<label for="typeRecette"><fmt:message key="formrecette.info.type"/> </label>
								<div class="required-field-block">
									<select	class="form-control form-control-inline" id="typeRecette" name="typeRecette">
										<c:forEach var="type" items="${requestScope.typesRecette}">
											<c:if test="${type.idType == recette.typesRecette.idType}">
												<option value="${type.idType}" selected><fmt:message key="application.typeRecette.${type.typeRecette}"/></option>
											</c:if>
											<c:if test="${type.idType != recette.typesRecette.idType}">
												<option value="${type.idType}"><fmt:message key="application.typeRecette.${type.typeRecette}"/></option>
											</c:if>
										</c:forEach>		
									</select>
								</div>
							</div>

							<!--Section description-->
							<div class="form-group">
								<label for="descRecette"><fmt:message key="formrecette.info.desc"/></label>
								<div class="required-field-block">
									<textarea class="form-control" id="descRecette"
										name="descRecette" required>${recette.descriptionRecette}</textarea>
									<div class="required-icon">
										<div class="text">*</div>
									</div>
								</div>
							</div>

							<!--Section temps de preparation -->
							<div class="form-group">
								<label for="tempsRecette"><fmt:message key="formrecette.info.prepTime"/></label>
								<div class="form-inline" id="tempsRecette">
									<input class="form-control form-control-inline" type="number" min="0" step="1" max="99" id="heureRecette" name="heureRecette" value="${requestScope.heureRecette}" required>
									<label for="heureRecette">h</label> 
									<input class="form-control form-control-inline"	type="number" min="0" step="1" max="59" id="minRecette"	name="minRecette" value="${requestScope.minuteRecette}" required>
									<label for="minRecette"> m</label>
								</div>
							</div>
						</div>
					</div>
					<!--Section Ingrédients-->
					<div class="panel panel-info">
						<div class="panel-heading text-center">
							<h3><fmt:message key="formrecette.ingredients.titre"/></h3>
						</div>
						<div class="panel-body">
							<ul class="list-group">
							
							<!-- Si c'est un premier ajout de recette, afficher première ligne d'ingredient -->
							<c:if test="${recette == null }">
								<li class="list-group-item noBorder media">
									<div class="form-group media-body autoWidth">
										<select	class="form-control form-control-inline" name="categorie1">
											<c:forEach var="categorie" items="${requestScope.categories}">
												
													<option value="${categorie.idCategorieIng}"><fmt:message key="application.categorieIngredient.${categorie.nomCategorieIng}"/></option>
												
											</c:forEach>
										</select>
										<input class="form-control form-control-inline" type="text"	size="22" placeholder="Ingrédient"	name="nomIngredient1" value="" required/> 
										<input class="form-control form-control-inline" type="number" min="0" step="1" max="999" size="5" placeholder="Quantité" name="qte1" value="" required/>
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
							</c:if>
							
							<c:forEach var="ingredient" items="${recette.mesures}" varStatus="index">
								<li class="list-group-item noBorder media">
									<div class="form-group media-body autoWidth">
										<select	class="form-control form-control-inline" name="categorie${index.count}">
											<c:forEach var="categorie" items="${requestScope.categories}">
												<c:if test="${categorie.idCategorieIng == ingredient.ingredient.categoriesIngredient.idCategorieIng}">
													<option value="${categorie.idCategorieIng}" selected><fmt:message key="application.categorieIngredient.${categorie.nomCategorieIng}"/></option>
												</c:if>
												<c:if test="${categorie.idCategorieIng != ingredient.ingredient.categoriesIngredient.idCategorieIng}">
													<option value="${categorie.idCategorieIng}"><fmt:message key="application.categorieIngredient.${categorie.nomCategorieIng}"/></option>
												</c:if>
											</c:forEach>
										</select>
										<input class="form-control form-control-inline" type="text"	size="22" placeholder="Ingrédient"	name="nomIngredient${index.count}" value="${ingredient.ingredient.nomIngredient }" required/> 
										<input class="form-control form-control-inline" type="number" min="0" step="1" max="999" size="5" placeholder="Quantité" name="qte${index.count}" value="${ingredient.quantite }" required/>
										<select	class="form-control form-control-inline" name="unite${index.count}">
											<option value="0">---</option>
											<c:forEach var="unit" items="${requestScope.unites}">
												<c:if test="${unit.idUnite == ingredient.unite.idUnite}">
													<option value="${unit.idUnite}" selected><fmt:message key="application.unites.${unit.nomUnite}"/></option>
												</c:if>
												<c:if test="${unit.idUnite != ingredient.unite.idUnite}">
													<option value="${unit.idUnite}"><fmt:message key="application.unites.${unit.nomUnite}"/></option>
												</c:if>
											</c:forEach>
										</select>
									</div>
									<div class="media-right media-middle">
										<span class="mouseIcon glyphicon glyphicon-plus-sign green" onclick="ajouterIngredient(this)"></span>
										<span class="mouseIcon glyphicon glyphicon-minus-sign red" onclick="supprimerIngredient(this)"></span>
									</div>
								</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<!-- Section instructions -->
					<div class="panel panel-info">
						<div class="panel-heading text-center">
							<h3><fmt:message key="formrecette.instructions.titre"/></h3>
						</div>
						<div class="panel-body">
							<ul class="list-group">
							
								<!-- si nouvelle recette, afficher  premier ligne d'instructions -->
								<c:if test="${recette == null}">
									<li class="list-group-item noBorder media">
									<div class="media-left media-top">
										<label for="instruction1">1.</label>
									</div>
									<div class="media-body autoWidth">
										<textarea cols="100" placeholder="Instruction"
											class="form-control" name="instruction1" required></textarea>
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
								</c:if>
								
								<c:forEach var="instruction" items="${recette.instructions}" varStatus="index">
								<li class="list-group-item noBorder media">
									<div class="media-left media-top">
										<label for="instruction${index.count}">${index.count}.</label>
									</div>
									<div class="media-body autoWidth">
										<textarea cols="100" placeholder="Instruction"
											class="form-control" name="instruction${index.count}">${instruction.descInstruction}</textarea>
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
								</c:forEach>
							</ul>
						</div>
					</div>

					<!-- Section bouton enregistrer -->
					<button type="submit" class="btn btn-primary pull-left"
						id="btnSubmitRecette"><fmt:message key="formrecette.enregistrer.button"/></button>
					<input type="hidden" name="action" value="ajouterRecette">
					<input type="hidden" name="idRecetteAModifier" value="${recette.idRecette}">
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