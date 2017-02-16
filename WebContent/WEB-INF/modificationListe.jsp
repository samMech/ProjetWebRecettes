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
</head>
<body>

	<!--La barre de navigation-->
	<jsp:include page="jspf/navbar.jsp"></jsp:include>
	
	<!--Le contenu central-->  
	<div class="container-fluid wrapText">
		<div class="row content">
	  					
			<!--La barre de navigation gauche-->
			<div class="col-md-2 col-lg-3 hidden-sm"></div>
			
			<!--Le panneau central-->	
			<div class="col-md-8 col-lg-6">
				
				<!--Titre de la page-->
				<div class="panel panel-primary text-center">
					<div class="panel-heading">
						<h1>Modification de la liste d'épicerie</h1>
					</div>
				</div>
				
				<!--Le contenu-->
				<div class="panel panel-info">
				
					<!--Titre du contenu-->
					<div class="panel-heading">
						<h3>Ingrédients</h3>
					</div>
						
					<!--Liste des ingrédients-->
					<div class="panel-body">
						
						<form id="formIngredients" method="POST" action="affichageListe.html">
							<div class="list-group">
							
								<div class="list-group-item noBorder" id="ingredient1" name="ingredient1">
									<div class="form-group media">
										<div class="media-body autoWidth">
											<input class="form-control form-control-inline" type="text" size="22" placeholder="Nom de l'ingrédient" value="Ingrédient 1" id="nom1" name="nom1"/>
											<input class="form-control form-control-inline" type="text" size="5" placeholder="Quantité" value="Qte 1" id="quantite1" name="quantite1"/>
											<select class="form-control form-control-inline" id="unite1" name="unite1">
												<option>g</option>
												<option>L</option>
												<option>mL</option>
												<option>g</option>
												<option>tasse(s)</option>
												<option>tbsp</option>
												<option>oz</option>
												<option>tsp</option>
												<optgroup>Tbs.</optgroup>
											</select>
										</div>
										<div class="media-right media-middle">
											<span class="span3 mouseIcon glyphicon glyphicon-plus-sign green"></span>
											<span class="span3 mouseIcon glyphicon glyphicon-minus-sign red"></span>
										</div>
										<div class="media-right media-middle">
											<span class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-up blue"></span>
											<span class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-down blue"></span>
										</div>
									</div>
								</div>
								
								<div class="list-group-item noBorder" id="ingredient2" name="ingredient2">
									<div class="form-group media">
										<div class="media-body autoWidth">
											<input class="form-control form-control-inline" type="text" size="22" placeholder="Nom de l'ingrédient" value="Ingrédient 2" id="nom2" name="nom2"/>
											<input class="form-control form-control-inline" type="text" size="5" placeholder="Quantité" value="Qte 2" id="quantite2" name="quantite2"/>
											<select class="form-control form-control-inline" id="unite2" name="unite2">
												<option>g</option>
												<option>L</option>
												<option>mL</option>
												<option>g</option>
												<option>tasse(s)</option>
												<option>tbsp</option>
												<option>oz</option>
												<option>tsp</option>
												<optgroup>Tbs.</optgroup>
											</select>
										</div>
										<div class="media-right media-middle">
											<span class="span3 mouseIcon glyphicon glyphicon-plus-sign green"></span>
											<span class="span3 mouseIcon glyphicon glyphicon-minus-sign red"></span>
										</div>
										<div class="media-right media-middle">
											<span class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-up blue"></span>
											<span class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-down blue"></span>
										</div>
									</div>
								</div>
								
								<div class="list-group-item noBorder" id="ingredient3" name="ingredient3">
									<div class="form-group media">
										<div class="media-body autoWidth">
											<input class="form-control form-control-inline" type="text" size="22" placeholder="Nom de l'ingrédient" value="Ingrédient 3" id="nom3" name="nom3"/>
											<input class="form-control form-control-inline" type="text" size="5" placeholder="Quantité" value="Qte 3" id="quantite3" name="quantite3"/>
											<select class="form-control form-control-inline" id="unite3" name="unite3">
												<option>g</option>
												<option>L</option>
												<option>mL</option>
												<option>g</option>
												<option>tasse(s)</option>
												<option>tbsp</option>
												<option>oz</option>
												<option>tsp</option>
												<optgroup>Tbs.</optgroup>
											</select>
										</div>
										<div class="media-right media-middle">
											<span class="span3 mouseIcon glyphicon glyphicon-plus-sign green"></span>
											<span class="span3 mouseIcon glyphicon glyphicon-minus-sign red"></span>
										</div>
										<div class="media-right media-middle">
											<span class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-up blue"></span>
											<span class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-down blue"></span>
										</div>
									</div>
								</div>
								
								<div class="list-group-item noBorder" id="ingredient4" name="ingredient4">
									<div class="form-group media">
										<div class="media-body autoWidth">
											<input class="form-control form-control-inline" type="text" size="22" placeholder="Nom de l'ingrédient" value="Ingrédient 4" id="nom4" name="nom4"/>
											<input class="form-control form-control-inline" type="text" size="5" placeholder="Quantité" value="Qte 4" id="quantite4" name="quantite4"/>
											<select class="form-control form-control-inline" id="unite4" name="unite4">
												<option>g</option>
												<option>L</option>
												<option>mL</option>
												<option>g</option>
												<option>tasse(s)</option>
												<option>tbsp</option>
												<option>oz</option>
												<option>tsp</option>
												<optgroup>Tbs.</optgroup>
											</select>
										</div>
										<div class="media-right media-middle">
											<span class="span3 mouseIcon glyphicon glyphicon-plus-sign green"></span>
											<span class="span3 mouseIcon glyphicon glyphicon-minus-sign red"></span>
										</div>
										<div class="media-right media-middle">
											<span class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-up blue"></span>
											<span class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-down blue"></span>
										</div>
									</div>
								</div>
								
								<div class="list-group-item noBorder" id="ingredient5" name="ingredient5">
									<div class="form-group media">
										<div class="media-body autoWidth">
											<input class="form-control form-control-inline" type="text" size="22" placeholder="Nom de l'ingrédient" value="Ingrédient 5" id="nom5" name="nom5"/>
											<input class="form-control form-control-inline" type="text" size="5" placeholder="Quantité" value="Qte 5" id="quantite5" name="quantite5"/>
											<select class="form-control form-control-inline" id="unite3" name="unite5">
												<option>g</option>
												<option>L</option>
												<option>mL</option>
												<option>g</option>
												<option>tasse(s)</option>
												<option>tbsp</option>
												<option>oz</option>
												<option>tsp</option>
												<optgroup>Tbs.</optgroup>
											</select>
										</div>
										<div class="media-right media-middle">
											<span class="span3 mouseIcon glyphicon glyphicon-plus-sign green"></span>
											<span class="span3 mouseIcon glyphicon glyphicon-minus-sign red"></span>
										</div>
										<div class="media-right media-middle">
											<span class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-up blue"></span>
											<span class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-down blue"></span>
										</div>
									</div>
								</div>
								
								<div class="list-group-item noBorder" id="ingredient6" name="ingredient6">
									<div class="form-group media">
										<div class="media-body autoWidth">
											<input class="form-control form-control-inline" type="text" size="22" placeholder="Nom de l'ingrédient" value="Ingrédient 6" id="nom6" name="nom6"/>
											<input class="form-control form-control-inline" type="text" size="5" placeholder="Quantité" value="Qte 6" id="quantite6" name="quantite6"/>
											<select class="form-control form-control-inline" id="unite6" name="unite6">
												<option>g</option>
												<option>L</option>
												<option>mL</option>
												<option>g</option>
												<option>tasse(s)</option>
												<option>tbsp</option>
												<option>oz</option>
												<option>tsp</option>
												<option>Tbs.</option>
											</select>
										</div>
										<div class="media-right media-middle">
											<span class="span3 mouseIcon glyphicon glyphicon-plus-sign green"></span>
											<span class="span3 mouseIcon glyphicon glyphicon-minus-sign red"></span>
										</div>
										<div class="media-right media-middle">
											<span class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-up blue"></span>
											<span class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-down blue"></span>
										</div>
									</div>
								</div>
								
								<div class="list-group-item noBorder">
									<button type="submit" class="btn btn-primary" id="finaliserListe">Finaliser</button>
								</div>
							</div>
						</form>
					</div>	
				</div>
				
				<!--Retour à la page précédente-->
				<ul class="pager text-center">
					<li><a href="recherche.html">Retour</a></li>
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