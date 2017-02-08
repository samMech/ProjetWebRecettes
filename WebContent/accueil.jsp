<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%--Importation des librairies JSTL--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--On vÈrifie si l'usager est dÈj‡ connectÈ--%>
<c:if test="${sessionScope.Usager != null}">
	<%--Redirection vers la page de bienvenue--%>
	<jsp:forward page="/ConnexionServlet?action=BIENVENUE"></jsp:forward>
</c:if>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>La BoÓte √† Ingr√©dients</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/styles.css">
	<script type="text/javascript" src="scripts/carousel.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/carousel.css">
	<script type="text/javascript" src="scripts/required-field.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/required-field-block.css">
</head>
<body>

	<!--La barre de navigation-->
	<jsp:include page="WEB-INF/jspf/navbar.jsp"></jsp:include>
		
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
						<h1>La BoÓte ‡† IngrÈdients</h1>
					</div>
					<div class="panel-body" id="imgTitre">
						<!--Carousel simple-->
						<div id="carouselAccueil" class="carousel fade" data-ride="carousel">
							<div class="carousel-inner"></div>
						</div>
					</div>
				</div>
				
				<!--Le contenu-->
				<div class="row">
				
					<!--Le panneau de connexion-->
					<div class="col-sm-5">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h2>Connexion</h2>
							</div>
							<div class="panel-body">
								<form id="formConnexion" method="POST" action="ConnexionServlet">
									<!--Login-->
									<div class="form-group">
										<label for="email">Adresse courriel:</label>
										<div class="input-group required-field-block">
											<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
											<input type="email" class="form-control hideTitleTooltip" id="email" name="email" required/>
											<div class="required-icon">
												<div class="text">*</div>
											</div>
										</div>
									</div>
									<!--Password-->
									<div class="form-group">
										<label for="pwd">Mot de passe:</label>
										<a class="pull-right" href="resetPassword.jsp">Mot de passe oubli√©?</a><!--Password reset-->
										<div class="input-group required-field-block">
											<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
											<input type="password" class="form-control" id="pwd" name="pwd" required pattern="[0-9a-zA-Z!@#$%&]{8}"/>
											<div class="required-icon">
												<div class="text">*</div>
											</div>
										</div>
									</div>
									<!--Option-->
									<div class="form-group checkbox">
										<label><input type="checkbox" id="optConnexion" name="optConnexion"/> Rester connect√©</label>
									</div>	
																	
									<c:if test="${requestScope.erreurConnexion == true}">
									<!--Erreur-->
									<div class="form-group text-center">
										<h3 class="text-center"><span class="label label-warning">Veuillez vÈrifier que votre adresse courriel et mot de passe sont valides.</span></h3><br />
									</div>									
									</c:if>	
																	
									<!--Enter-->
									<div class="form-group text-center">
										<input type="hidden" name="action" value="SE_CONNECTER" />
									    <button type="submit" class="btn btn-primary btn-block" id="connexion"><span class="glyphicon glyphicon-log-in"></span> Se connecter</button>
									</div>
								</form>
								<!--Nouveau compte-->
								<div class="panel-footer text-center">
									<label class="small">---Pas encore de compte ?---</label>
									<button type="button" class="btn btn-default btn-block" onclick="document.location.href='creerCompte.jsp'">Cr√©er un nouveau compte</button>
								</div>
							</div>
						</div>
					</div>
				
					<!--Le texte de bienvenue-->	
					<div class="col-sm-7">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3>Bienvenue !</h3>
							</div>
							<div class="panel-body">
								<p>	
								Ce site vous permet de cr√©er et modifier une
								liste d'√©picerie en fonction des recettes que
								vous voulez cuisinez.

								Connectez-vous ou cr√©ez un nouveau compte
								d√®s maintenant pour g√©rer votre propre livre de recettes en ligne.
								</p>
							</div>							
						</div>
					</div>
					
				</div>
			</div>
				
			<!--La barre de navigation droite-->
			<div class="col-lg-2 hidden-md"></div>
		
		</div>
	</div>

	<!--Le bas de page-->
	<jsp:include page="WEB-INF/jspf/footer.jsp"></jsp:include>

</body>
</html>