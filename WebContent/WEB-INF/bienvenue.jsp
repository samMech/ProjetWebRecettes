<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%--Importation des librairies JSTL--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>La Boîte à Ingrédients</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/styles.css">
	<script type="text/javascript" src="scripts/carousel.js"></script>	
	<link rel="stylesheet" type="text/css" href="styles/carousel.css">
</head>
<body>

	<!--La barre de navigation-->
	<jsp:include page="jspf/navbar.jsp"></jsp:include>

	<!--Le contenu central-->  
	<div class="container-fluid wrapText">
		<div class="row content">
	  					
			<!--La barre de navigation gauche-->
			<div class="col-lg-2 hidden-md"></div>
			
			<!--Le panneau central-->	
			<div class="col-lg-8">
				
				<!--Titre de la page-->
				<div class="panel panel-primary text-center">
					<div class="panel-heading">
						<h1>Bienvenue ${sessionScope.Usager.nomUsager}</h1>
					</div>
					<div class="panel-body" id="imgTitre">
						<!--Carousel simple-->
						<div id="carouselAccueil" class="carousel fade" data-ride="carousel">
							<div class="carousel-inner"></div>
						</div>
					</div>
				</div>
				
				<!--Le contenu-->
				<div class="panel panel-info text-center">			
					<div class="panel-heading">
						<h3><span>Vos plus récentes recettes</span></h3>
					</div>
				</div>
				
				<c:choose>
					<c:when test="${! requestScope.recettesRecentes.isEmpty()}">
						<!--Le contenu-->
						<div id="recettesRecentes">
							<ul class="nav nav-tabs nav-justified">
								<c:forEach var="recette" items="${requestScope.recettesRecentes}">
									<li ${status.first ? class="active" : ''}>
										<h4><a data-toggle="tab" href="RecetteServlet?action=voirRecette&idRecette=${recette.idRecette}">Recette ${index + 1}</a></h4>
									</li>
								</c:forEach>
							</ul>
						</div>
						<div class="panel panel-info">			
							<div class="panel-body tab-content row">
								<c:forEach var="recette" items="${requestScope.recettesRecentes}">
									<div id="recette${index+1}" class="tab-pane fade in ${status.first ? active : ''}">
										<div class="col-sm-2 text-center">
											<button class="btn btn-primary" onclick="document.location.href='RecetteServlet?action=voirRecette&idRecette=${recette.idRecette}'">Voir la recette</button>								
										</div>
										<br/>
										<div class="col-sm-10">
											<p>${recette.descriptionRecette}</p>
											<h4><span class="label label-info">Temps de préparation: ${recette.dureeRecette} min</span></h4>
										</div>
									</div>
								</c:forEach>								
							</div>							
						</div>
					</c:when>
					<c:otherwise>
						<div class="panel-footer text-center">
							Pas encore de recette ? Ajoutez-en à votre livre dès maintenant !
						</div>		
					</c:otherwise>
				</c:choose>
				
			</div>
			
			<!--La barre de navigation droite-->
			<div class="col-lg-2 hidden-md"></div>
		
		</div>
	</div>

	<!--Le bas de page-->
	<jsp:include page="jspf/footer.jsp"></jsp:include>

</body>
</html>