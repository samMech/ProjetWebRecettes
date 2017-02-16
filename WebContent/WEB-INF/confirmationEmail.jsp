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
<html>
<head>
	<title><fmt:message key="application.nom"/></title>
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
	<jsp:include page="jspf/navbar.jsp"></jsp:include>

	<!--Le contenu central-->  
	<div class="container-fluid">
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
					
					<!-- Bordure gauche -->
					<div class="col-sm-2"></div>
								
					<!--Le texte de bienvenue-->	
					<div class="col-sm-8">		
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3>Un courriel a été envoyé à votre adresse courriel !</h3>
							</div>
							<div class="panel body">							
								<p>
									Pour compléter votre inscription, veuillez copier le code fournis à l'intérieur
									dans la zone de texte ci-dessous et cliquer sur confirmer
								</p>
								<form id="formConfirmationEmail" method="POST" action="CompteServlet">
									<!--Login-->
									<div class="form-group form-inline">
										<label for="userName">Code de confirmation:</label>
										<div class="input-group required-field-block col-lg-12">
											<input type="text" class="form-control " id="codeSoumis" name="codeSoumis" required />
											<div class="required-icon">
												<div class="text">*</div>
											</div>
										</div>
									</div>
									
									<c:choose>
										<c:when test="${requestScope.compteCree == true}">
											<div class="form-group text-center">
												<h3 class="text-center"><span class="label label-success">Votre compte a été créé avec succès.</span></h3><br />
												<a href="ConnexionServlet?action=none">Retournez à la page de connexion</a>
											</div>									
										</c:when>
										<c:otherwise>										
											<c:if test="${requestScope.erreurCodeConfirmation == true}">
												<div class="form-group text-center">
													<h3 class="text-center"><span class="label label-warning">Le code soumis est erroné. Vérifiez que vous avez bien copié le code fournit dans le courriel de confirmation que vous avez reçu.</span></h3><br />
												</div>									
											</c:if>
											<!--Enter-->
											<div class="form-group text-center">
												<input type="hidden" name="action" value="CONFIRM_EMAIL_NEW_ACCOUNT" />
											    <button type="submit" class="btn btn-primary btn-block" id="confirmation"><span class="glyphicon glyphicon-log-in"></span> Confirmer l'inscription</button>
											</div>	
										</c:otherwise>
									</c:choose>		
												
								</form>	
							</div>						
						</div>
					</div>
					
					<!-- Bordure droite -->
					<div class="col-sm-2"></div>
					
				</div>
			</div>
				
			<!--La barre de navigation droite-->
			<div class="col-lg-2 hidden-md"></div>
		
		</div>
	</div>

	<!--Le bas de page-->
	<jsp:include page="jspf/footer.jsp"></jsp:include>

</body>
</html>