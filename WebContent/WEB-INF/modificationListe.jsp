<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%--Importation des librairies JSTL--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%--On v�rifie si l'usager est toujours connect�--%>
<c:if test="${sessionScope.Usager == null}">
	<%--Redirection vers la page de bienvenue--%>
	<jsp:forward page="/ConnexionServlet"></jsp:forward>
</c:if>

<%--Initialisation de la locale--%>
<fmt:setLocale value="${sessionScope.langue}" />
<fmt:setBundle basename="ressources_i18n.Locale" />

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="application.nom" /></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles/styles.css">
<script type="text/javascript" src="scripts/dynamicList.js"></script>
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
						<h1><fmt:message key="modificationListe.info.titre"/></h1>
					</div>
				</div>

				<!--Le contenu-->
				<div class="panel panel-info">

					<!--Titre du contenu-->
					<div class="panel-heading">
						<h3><fmt:message key="modificationListe.ingredients.titre"/></h3>
					</div>

					<!--Liste des ingr�dients-->
					<div class="panel-body">

						<form method="POST" action="ListeEpicerieServlet">
							<ul class="list-group">
								<c:forEach var="mesure"	items="${requestScope.listeEpicerie}" varStatus="index">
									<li class="list-group-item noBorder">
										<div class="form-group media">
											<div class="media-body autoWidth">
												<select	class="form-control form-control-inline" name="categorie${index.count}">
													<c:forEach var="categorie" items="${requestScope.categories}">
														<c:if test="${categorie.idCategorieIng == mesure.ingredient.categoriesIngredient.idCategorieIng}">
															<option value="${categorie.idCategorieIng}" selected><fmt:message key="application.categorieIngredient.${categorie.nomCategorieIng}"/></option>
														</c:if>
														<c:if test="${categorie.idCategorieIng != mesure.ingredient.categoriesIngredient.idCategorieIng}">
															<option value="${categorie.idCategorieIng}"><fmt:message key="application.categorieIngredient.${categorie.nomCategorieIng}"/></option>
														</c:if>
													</c:forEach>
												</select>
												<input class="form-control form-control-inline" type="text"	size="22" placeholder="Ingr�dient"	name="nomIngredient${index.count}" value="${mesure.ingredient.nomIngredient }" required/> 
												<input class="form-control form-control-inline" type="number" min="0" step="any" max="99999" size="5" placeholder="Quantit�" name="qte${index.count}" value="${mesure.quantite }" required/>
												<select	class="form-control form-control-inline" name="unite${index.count}">
													<option value="0">---</option>
													<c:forEach var="unit" items="${requestScope.unites}">
														<c:if test="${unit.idUnite == mesure.unite.idUnite}">
															<option value="<fmt:message key="application.unites.${unit.nomUnite}"/>" selected><fmt:message key="application.unites.${unit.nomUnite}"/></option>
														</c:if>
														<c:if test="${unit.idUnite != mesure.unite.idUnite}">
															<option value="<fmt:message key="application.unites.${unit.nomUnite}"/>"><fmt:message key="application.unites.${unit.nomUnite}"/></option>
														</c:if>
													</c:forEach>
												</select>
											</div>
											<div class="media-right media-middle">
												<span
													class="span3 mouseIcon glyphicon glyphicon-plus-sign green"  onclick="ajouterIngredientListe(this)"></span>
												<span
													class="span3 mouseIcon glyphicon glyphicon-minus-sign red"  onclick="supprimerIngredientListe(this)"></span>
											</div>
											<div class="media-right media-middle">
												<span
													class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-up blue" onclick="monterIngredientListe(this)"></span>
												<span
													class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-down blue" onclick="descendreIngredientListe(this)"></span>
											</div>
										</div>
									</li>
								</c:forEach>

							</ul>
							<div class="list-group-item noBorder">
								<input type="hidden" name="action" value="FINALISER_LISTE">
								<button type="submit" class="btn btn-primary" id="finaliserListe"><fmt:message key="modificationListe.finaliser.button"/></button>
							</div>
						</form>
					</div>
				</div>
			</div>

			<!--La barre de navigation droite-->
			<div class="col-md-2 col-lg-3 hidden-sm"></div>

		</div>
	</div>

	<!--Le bas de page-->
	<jsp:include page="jspf/footer.jsp"></jsp:include>

</body>
</html>