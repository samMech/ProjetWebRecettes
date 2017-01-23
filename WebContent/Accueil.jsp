<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>La Bo�te à Ingrédients</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="styles.css">
	<script type="text/javascript" src="carousel.js"></script>
	<link rel="stylesheet" type="text/css" href="carousel.css">
	<script type="text/javascript" src="required-field.js"></script>
	<link rel="stylesheet" type="text/css" href="required-field-block.css">
</head>
<body>

	<!--La barre de navigation-->
	<jsp:include page="WEB-INF/navbar.jspf"></jsp:include>
		
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
						<h1>La Boîte à Ingrédients</h1>
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
								<form id="formConnexion" method="POST" action="bienvenue.html">
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
										<a class="pull-right" href="resetPasswordl.html">Mot de passe oublié?</a><!--Password reset-->
										<div class="input-group required-field-block">
											<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
											<input type="password" class="form-control" id="pwd" name="pwd" required/>
											<div class="required-icon">
												<div class="text">*</div>
											</div>
										</div>
									</div>
									<!--Option-->
									<div class="form-group checkbox">
										<label><input type="checkbox" id="optConnexion" name="optConnexion"/> Rester connecté</label>
									</div>
									<!--Enter-->
									<div class="form-group text-center">
									    <button type="submit" class="btn btn-primary btn-block" id="connexion"><span class="glyphicon glyphicon-log-in"></span> Se connecter</button>
									</div>
								</form>
								<!--Nouveau compte-->
								<div class="panel-footer text-center">
									<label class="small">---Pas encore de compte ?---</label>
									<button type="button" class="btn btn-default btn-block" onclick="document.location.href='creerCompte.html'">Créer un nouveau compte</button>
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
								Ce site vous permet de créer et modifier une
								liste d'épicerie en fonction des recettes que
								vous voulez cuisinez.

								Connectez-vous ou créez un nouveau compte
								dès maintenant pour gérer votre propre livre de recettes en ligne.
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
	<br/>
	<footer class="container-fluid text-center">
		<p><span class="glyphicon glyphicon-copyright-mark"></span> 2016 La Boîte à Ingrédients</p>
	</footer>

</body>
</html>