<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%--Importation des librairies JSTL--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--On v�rifie si l'usager est d�j� connect�--%>
<c:if test="${sessionScope.Usager != null}">
	<%--Redirection vers la page de bienvenue--%>
	<jsp:forward page="/ConnexionServlet?action=BIENVENUE"></jsp:forward>
</c:if>

<!DOCTYPE html>
<html>
<head>
	<title>La Bo�te � Ingr�dients</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/styles.css">
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
						<h1>La Bo�te � Ingr�dients</h1>
					</div>
				</div>
				
				<!--Le contenu-->
				<div class="row">
				
					<!--Le panneau de connexion-->
					<div class="col-sm-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h2>R�initialiser votre compte</h2>
							</div>
							<div class="panel-body">
								<form id="formConnexion" method="POST" action="CompteServlet">
									<div class="form-group">
										<label for="email">Adresse courriel:</label>
										<div class="input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
											<input type="email" class="form-control" id="email" name="email" required/>
										</div>
									</div>
									
									<c:if test="${requestScope.usagerInexistant == true}">
									<!--Erreur-->
									<div class="form-group text-center">
										<h3 class="text-center"><span class="label label-warning">L'adresse courriel fournie ne correspond � aucun usager existant !</span></h3><br />
									</div>									
									</c:if>	
									
									<!--Enter-->
									<div class="form-group text-center">
										<input type="hidden" name="action" value="RESET_PASSWORD" />
									    <button type="submit" class="btn btn-primary btn-block" id="connexion"><span class="glyphicon glyphicon-log-in"></span> R�initialiser</button>
									</div>
								</form>
								<!--Nouveau compte-->
								<div class="panel-footer text-center">
									<label class="small">---Cliquez ici pour retourner � la page d'accueil---</label>
									<button type="button" class="btn btn-default btn-block" onClick="document.location.href='ConnexionServlet?action=CANCEL'">Se Connecter</button>
								</div>
							</div>
						</div>
					</div>
				
					<!--Le texte de bienvenue-->	
					<div class="col-sm-6">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3>Instructions</h3>
							</div>
							<div class="panel-body">
								<ul>
									<li>Pour r�initialiser votre mot de passe, entrez votre adresse courriel.</li>
									<li>Un courriel vous sera envoy� avec un nouveau mot de passe.</li>
								</ul>
								
								<c:choose>
									<c:when test="${requestScope.erreurEnvoiEmail == true}">
										<h3 class="text-center"><span id="messageConfirmation" class="label label-danger">Une erreur est survenue, veuillez r�-essayer plus tard.</span></h3>
									</c:when>
									<c:when test="${requestScope.confirmationEmail == true }">
										<h3 class="text-center"><span id="messageConfirmation" class="label label-success">Un courriel contenant votre nouveau mot de passe vous a �t� envoy�.</span></h3>
									</c:when>
								</c:choose>
																								
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