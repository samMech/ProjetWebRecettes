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
<html lang="en">
<head>
	<title><fmt:message key="application.nom"/></title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/styles.css">
	<script type="text/javascript" src="scripts/dynamicList.js"></script>
	<script type="text/javascript" src="scripts/rechercheAJAX.js"></script>
</head>
<body>

	<!--La barre de navigation-->
	<jsp:include page="jspf/navbar.jsp"></jsp:include>
	
	<!--Le contenu central-->  
	<div class="container-fluid">
		<div class="row content">
	  					
			<!--La barre de navigation gauche-->
			<div class="col-lg-1 hidden-md"></div>
			
			<!--Le panneau central-->	
			<div class="col-lg-10">
				
				<!--Titre de la page-->
				<div class="panel panel-primary text-center">
					<div class="panel-heading">
						<h1>Nouvelle liste d'épicerie</h1>
					</div>
				</div>
				
				<!--Le contenu-->
				<div class="row">
				
					<!--Le panneau de recherche-->
					<div class="col-sm-4 col-md-3">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h2>Recherche</h2>
							</div>
							<div class="panel-body">
								
									<!--Recherche libre-->
									<div class="form-group">
										<label for="texteRecherche">Recettes / Instruction / Ingrédient:</label>
										<input type="text" class="form-control" id="texteRecherche" name="texteRecherche" value="${requestScope.texteRecherche}"/>
									</div>
																		
									<!--Recherche par types de recette-->
									<div class="panel panel-info">
										<div class="panel-heading"><label>Type de recette:</label></div>
										<div class="panel-body">
											<select	class="form-group" id="typeRecherche" name="typeRecette" onchange="lancerRecherche()">
												<option value="-1" class="text-center">---</option>
												<c:forEach var="type" items="${requestScope.typesRecette}">
													<option value="${type.idType}"><fmt:message key="application.typeRecette.${type.typeRecette}"/></option>
												</c:forEach>		
											</select>
										</div>
									</div>
									
									<!--Recherche par catégorie d'ingrédients-->
									<div class="panel panel-info">
										<div class="panel-heading" style="margin: 0;"><label>Catégorie d'ingrédient:</label></div>
										<div class="panel-body">
											<ul class="form-group liste-recherche" id="categoriesRecherche">
												<c:forEach var="categorie" items="${requestScope.categoriesIngredient}">											
													<li><input type="checkbox" name="categories" value="${categorie.idCategorieIng}" onchange="lancerRecherche()"><span class="espacement">   </span><fmt:message key="application.categorieIngredient.${categorie.nomCategorieIng}"/></li>
												</c:forEach>
											</ul>
										</div>
									</div>
									
									<!--Recherche par temps de préparation-->
									<div class="panel panel-info">
										<div class="panel-heading"><label>Temps de préparation:</label></div>
										<div class="panel-body">
											<ul class="form-group liste-recherche" id="dureeRecherche">
												<li><input type="radio" name="durees" value="NONE" checked><span class="espacement">   </span><fmt:message key="recherche.duree"/></li>
												<c:forEach var="dureeMax" items="${requestScope.dureesMax}">											
													<li><input type="radio" name="durees" value="${dureeMax}" onchange="lancerRecherche()"><span class="espacement">   </span><fmt:message key="recherche.duree${dureeMax.value}"/></li>
												</c:forEach>
											</ul>
										</div>
									</div>
									
							</div>
						</div>
					</div>
				
					<!--Le panneau des résultats-->	
					<div class="col-sm-5 col-md-6">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3>Recettes trouvées   <span class="badge" id="nbResultats">28</span></h3>								
							</div>
							<div class="panel-body">
								<div class="list-group" id="listeResultats">
									
								</div>													
							</div>			
						</div>
					</div>
					
					<!--Le panneau des sélections-->	
					<div class="col-sm-3">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3>Recettes choisies   <span class="badge" id="nbSelections">2</span></h3>
							</div>
							<div class="panel-body">
								<form id="formRecettes" method="POST" action="modificationListe.html">
									<div class="list-group">						
									
										<div class="list-group-item noBorder" id="recette1">
											<div class="media">												
												<div class="media-body">
													<h4><a href="viewRecette.html" id="nomRecette1" class="list-group-item-heading">Nom de la recette 1</a></h4>
												</div>
												<div class="media-left media-middle">
													<span class="badge alert-info" id="nbSelections">x2</span>
												</div>
												<div class="media-right media-middle">
													<span class="mouseIcon glyphicon glyphicon-plus-sign green"></span>
												</div>
												<div class="media-right media-middle">
													<span class="mouseIcon glyphicon glyphicon-minus-sign red"></span>
												</div>
											</div>
										</div>
										
										<div class="list-group-item noBorder" id="recette2">
											<div class="media">												
												<div class="media-body">
													<h4><a href="viewRecette.html" id="nomRecette2" class="list-group-item-heading">Nom de la recette 2</a></h4>
												</div>												
												<div class="media-right media-middle">
													<span class="mouseIcon glyphicon glyphicon-plus-sign green"></span>
												</div>
												<div class="media-right media-middle">
													<span class="mouseIcon glyphicon glyphicon-minus-sign red"></span>
												</div>
											</div>
										</div>	
										
									</div>
									<div class="text-center">
										<button type="submit" class="btn btn-primary btn-block" id="creerListe">Créer la liste d'épicerie</button>
									</div>
								</form>
							</div>							
						</div>
					</div>
					
				</div>
			</div>
				
			<!--La barre de navigation droite-->
			<div class="col-lg-1 hidden-md"></div>
		
		</div>
	</div>

	<!--Le bas de page-->
	<jsp:include page="jspf/footer.jsp"></jsp:include>

</body>
</html>