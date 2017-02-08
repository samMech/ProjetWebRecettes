<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%--Importation des librairies JSTL--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--On vérifie si l'usager est déjà connecté--%>
<c:if test="${sessionScope.Usager != null}">
	<%--Redirection vers la page de bienvenue--%>
	<jsp:forward page="/ConnexionServlet?action=BIENVENUE"></jsp:forward>
</c:if>

<!DOCTYPE html>
<html>
<head>
	<title>La Boîte à Ingrédients</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/styles.css">
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
						<h1>La Boîte à Ingrédients</h1>
					</div>
				</div>
				
				<!--Le contenu-->
				<div class="row">
				
					<!--Le panneau de connexion-->
					<div class="col-sm-5">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h2>Créer un compte</h2>
							</div>
							<div class="panel-body">
								<form id="formConnexion" method="POST" action="CompteServlet">
									<!--Login-->
									<div class="form-group">
										<label for="userName">Nom d'utilisateur: </label>
										<div class="input-group required-field-block col-lg-12">
											<input type="text" class="form-control " id="userName" name="userName" required/>
											<div class="required-icon">
												<div class="text">*</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="email">Adresse courriel:</label>
										<div class="input-group required-field-block">
											<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
											<input type="email" class="form-control" id="email" name="email" required/>
											<div class="required-icon">
												<div class="text">*</div>
											</div>
										</div>
									</div>
									<!--Password-->
									<div class="form-group">
										<label for="pwd">Mot de passe:</label>
										<div class="input-group required-field-block">
											<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
											<input type="password" class="form-control" id="pwd" name="pwd" required/>
											<div class="required-icon">
												<div class="text">*</div>
											</div>
										</div>
									</div>
									<!--Confirm Password-->
									<div class="form-group">
										<label for="pwd">Confirmer le mot de passe: </label>
										<div class="input-group required-field-block">
											<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
											<input type="password" class="form-control" id="pwd" name="pwd" required pattern="[0-9a-zA-Z!@#$%&]{8}"/>
											<div class="required-icon">
												<div class="text">*</div>
											</div>
										</div>
									</div>
									
									<c:choose>
										<c:when test="${requestScope.usagerExistant == true}">
											<!--Erreur-->
											<div class="form-group text-center">
												<h3 class="text-center"><span class="label label-warning">Cette adresse courriel est déjà utilisée par un autre usager !</span></h3><br />
											</div>									
										</c:when>
										<c:when test="${requestScope.pwdInvalide == true}">
											<!--Erreur-->
											<div class="form-group text-center">
												<h3 class="text-center"><span class="label label-warning">Ce mot de passe est invalide !</span></h3><br />
											</div>									
										</c:when>
										<c:when test="${requestScope.erreurEnvoiEmail == true}">
											<!--Erreur-->
											<div class="form-group text-center">
												<h3 class="text-center"><span class="label label-danger">Une erreur est survenue, veuillez ré-essayer plus tard.</span></h3><br />
											</div>									
										</c:when>
										<c:otherwise>											
										</c:otherwise>
									</c:choose>
									
									<!--Enter-->
									<div class="form-group text-center">
										<input type="hidden" name="action" value="CREATE_ACCOUNT" />
									    <button type="submit" class="btn btn-primary btn-block" id="connexion"><span class="glyphicon glyphicon-log-in"></span> Créer un compte</button>
									</div>
								</form>
								<!--Nouveau compte-->
								<div class="panel-footer text-center">
									<label class="small">---Vous avez déjà un compte ?---</label>
									<button type="button" class="btn btn-default btn-block" onClick="document.location.href='ConnexionServlet?action=CANCEL'">Se connecter</button>
								</div>
							</div>
						</div>
					</div>
				
					<!--Le texte de bienvenue-->	
					<div class="col-sm-7">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3>Instructions</h3>
							</div>
							<div class="panel-body">
								<ul>
									<li>Tous les champs sont obligatoires</li>
									<li>L'adresse courriel doit être valide. Un code de confirmation vous sera envoyez par courriel pour compléter le processus d'inscription</li>
									<li>
										Le mot de passe doit contenir exactement 8 caractères (lettres et/ou chiffres)<br />
									    Seul les caractères spéciaux suivant sont autorisés: ! @ # $ % & <br />
									    Les caractères accentués ne sont pas autorisés
									</li>
								</ul>
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