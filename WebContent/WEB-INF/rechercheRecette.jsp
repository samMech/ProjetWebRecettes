<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%--Importation des librairies JSTL--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
</head>
<body>

	<!--La barre de navigation-->
	<jsp:include page="jspf/navbar.jsp"></jsp:include>
	
	<!--Le contenu central-->  
	<div class="container-fluid wrapText">
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
					<div class="col-sm-5 col-md-4">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h2>Paramètres de recherche</h2>
							</div>
							<div class="panel-body">
								<form id="formRecherche" method="POST">
									<!--Recherche par recette-->
									<div class="form-group">
										<label for="nomRecette">Recettes:</label>
										<input type="text" class="form-control" id="nomRecette" name="nomRecette">
									</div>
									<!--Recherche par ingrédient-->
									<div class="form-group">
										<label for="ingredientRecette">Ingrédients:</label>
										<input type="text" class="form-control" id="ingredientRecette" name="ingredientRecette">
									</div>
									<!--Recherche par temps de préparation-->
									<div class="form-group">
										<label for="tempsMaxRecette">Temps de préparation max:</label>
										<div class="form-inline" id="tempsMaxRecette">
											<input id="hMax" name="hMax" class="form-control form-control-inline" type="number" min="0" step="1" max="99"/>
											<label for="hMax">h</label>
											<input id="mMax" name="mMax" class="form-control form-control-inline" type="number" min="0" step="1" max="59"/>
											<label for="mMax">m</label>
										</div>	
									</div>
									<!--Boutons-->
									<div class="form-group row text-center">								
										<div class="col-xs-7">
											<button type="submit" class="btn btn-primary btn-block" id="recherche"><span class="glyphicon glyphicon-search"></span> Rechercher</button>
										</div>
										<div class="col-xs-5">
											<button type="reset" class="btn btn-primary btn-block" id="efface">Effacer</button>
										</div>										
									</div>
								</form>
							</div>
						</div>
					</div>
				
					<!--Le panneau des résultats-->	
					<div class="col-sm-4 col-md-5">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3>Recettes trouvées   <span class="badge" id="nbResultats">28</span></h3>								
							</div>
							<div class="panel-body">
								<div class="list-group" id="listeResultats">

									<div class="list-group-item topBorder media">
										<div class="media-body">
											<h4 class="list-group-item-heading"><a href="viewRecette.html" id="resultat1">Nom de la recette 1</a></h4>
											<h5><span class="label label-info">Temps de préparation: 25min</span></h5>
											<p class="list-group-item-text">
												Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et molestie est, ut commodo sapien. Integer non metus ac orci.
											</p> 
										</div>
										<div class="media-right media-top">
											<span class="mouseIcon glyphicon glyphicon-plus-sign green"></span>
										</div>
									</div>
									
									<div class="list-group-item topBorder media">
										<div class="media-body">
											<h4 class="list-group-item-heading"><a href="viewRecette.html" id="resultat2">Nom de la recette 2</a></h4>
											<h5><span class="label label-info">Temps de préparation: 15min</span></h5>
											<p class="list-group-item-text">
												Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et molestie est, ut commodo sapien. Integer non metus ac orci.
											</p> 
										</div>
										<div class="media-right media-top">
											<span class="mouseIcon glyphicon glyphicon-plus-sign green"></span>
										</div>
									</div>
									
									<div class="list-group-item topBorder media">
										<div class="media-body">
											<h4 class="list-group-item-heading"><a href="viewRecette.html" id="resultat3">Nom de la recette 3</a></h4>
											<h5><span class="label label-info">Temps de préparation: 40min</span></h5>
											<p class="list-group-item-text">
												Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et molestie est, ut commodo sapien. Integer non metus ac orci.
											</p> 
										</div>
										<div class="media-right media-top">
											<span class="mouseIcon glyphicon glyphicon-plus-sign green"></span>
										</div>
									</div>
									
									<div class="list-group-item topBorder media">
										<div class="media-body">
											<h4 class="list-group-item-heading"><a href="viewRecette.html" id="resultat4">Nom de la recette 4</a></h4>
											<h5><span class="label label-info">Temps de préparation: 60min</span></h5>
											<p class="list-group-item-text">
												Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et molestie est, ut commodo sapien. Integer non metus ac orci.
											</p> 
										</div>
										<div class="media-right media-top">
											<span class="mouseIcon glyphicon glyphicon-plus-sign green"></span>
										</div>
									</div>
									
									<div class="list-group-item topBorder media">
										<div class="media-body">
											<h4 class="list-group-item-heading"><a href="viewRecette.html" id="resultat5">Nom de la recette 5</a></h4>
											<h5><span class="label label-info">Temps de préparation: 30min</span></h5>
											<p class="list-group-item-text">
												Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et molestie est, ut commodo sapien. Integer non metus ac orci.
											</p> 
										</div>
										<div class="media-right media-top">
											<span class="mouseIcon glyphicon glyphicon-plus-sign green"></span>
										</div>
									</div>
									
									<div class="list-group-item topBorder media">
										<div class="media-body">
											<h4 class="list-group-item-heading"><a href="viewRecette.html" id="resultat6">Nom de la recette 6</a></h4>
											<h5><span class="label label-info">Temps de préparation: 95min</span></h5>
											<p class="list-group-item-text">
												Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et molestie est, ut commodo sapien. Integer non metus ac orci.
											</p> 
										</div>
										<div class="media-right media-top">
											<span class="mouseIcon glyphicon glyphicon-plus-sign green"></span>
										</div>
									</div>
									
								</div>													
							</div>
							<div class="panel-footer">
								<div class="text-center">
									<ul id="pagesBas" class="pagination pagination-sm">
										<li class="disabled"><a href="#" rel="previous">&laquo;</a></li>
										<li class="active"><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#" rel="next">&raquo;</a></li>
									</ul>
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
									
										<div class="list-group-item noBorder" id="recette1" name="recette1">
											<div class="media">												
												<div class="media-body">
													<a href="viewRecette.html" id="nomRecette1" name="nomRecette1" class="list-group-item-heading"><h4>Nom de la recette 1</h4></a>
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
										
										<div class="list-group-item noBorder" id="recette2" name="recette2">
											<div class="media">												
												<div class="media-body">
													<a href="viewRecette.html" id="nomRecette2" name="nomRecette2" class="list-group-item-heading"><h4>Nom de la recette 2</h4></a>
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