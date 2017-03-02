<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%--Importation des librairies JSTL--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--On vérifie si l'usager est déjà connecté--%>
<c:if test="${sessionScope.Usager != null}">
	<%--Redirection vers la page de bienvenue--%>
	<jsp:forward page="/ConnexionServlet?action=BIENVENUE"></jsp:forward>
</c:if>

<%--Initialisation de la locale--%>
<fmt:setLocale value="${sessionScope.langue != null ? sessionScope.langue : pageContext.request.locale.language}"/>
<fmt:setBundle basename="ressources_i18n.Locale"/>

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
	<script type="text/javascript" src="scripts/password.js"></script>
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
						<h1><fmt:message key="application.nom"/></h1>
					</div>
				</div>
				
				<!--Le contenu-->
				<div class="row">
				
					<!--Le panneau de connexion-->
					<div class="col-sm-5">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h2><fmt:message key="compte.form.titre"/></h2>
							</div>
							<div class="panel-body">
								<form id="formConnexion" method="POST" action="CompteServlet">
									<!--Login-->
									<div class="form-group">
										<label for="userName"><fmt:message key="compte.form.nom"/></label>
										<div class="input-group required-field-block col-lg-12">
											<input type="text" class="form-control " id="userName" name="userName" required/>
											<div class="required-icon">
												<div class="text">*</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="email"><fmt:message key="compte.form.email"/></label>
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
										<label for="pwd"><fmt:message key="compte.form.password"/></label>
										<div class="input-group required-field-block">
											<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
											<input type="password" class="form-control" id="pwd" name="pwd" required pattern="[0-9a-zA-Z!@#$%&]{8}" onchange="comparerPasswords();"/>
											<div class="required-icon">
												<div class="text">*</div>
											</div>
										</div>
									</div>
									<!--Confirm Password-->
									<div class="form-group">
										<label for="pwd"><fmt:message key="compte.form.password2"/></label>
										<div class="input-group required-field-block">
											<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
											<input type="password" class="form-control" id="pwd2" name="pwd2" required pattern="[0-9a-zA-Z!@#$%&]{8}" onkeyup="comparerPasswords();"/>
											<div class="required-icon">
												<div class="text">*</div>
											</div>
										</div>
									</div>
									
									<c:choose>
										<c:when test="${requestScope.usagerExistant == true}">
											<!--Erreur-->
											<div class="form-group text-center">
												<h3 class="text-center"><span class="label label-warning"><fmt:message key="compte.form.erreurEmailExistant"/></span></h3><br />
											</div>									
										</c:when>
										<c:when test="${requestScope.pwdInvalide == true}">
											<!--Erreur-->
											<div class="form-group text-center">
												<h3 class="text-center"><span class="label label-warning"><fmt:message key="compte.form.erreurPasswordInvalide"/></span></h3><br />
											</div>									
										</c:when>
										<c:when test="${requestScope.erreurEnvoiEmail == true}">
											<!--Erreur-->
											<div class="form-group text-center">
												<h3 class="text-center"><span class="label label-danger"><fmt:message key="compte.form.erreurCreation"/></span></h3><br />
											</div>									
										</c:when>	
									</c:choose>
									
									<!--Enter-->
									<div class="form-group text-center">
										<input type="hidden" name="action" value="CREATE_ACCOUNT" />
										<input type="hidden" id="msgErreurPasswordsDifferents" value="<fmt:message key="compte.form.erreurPwdDifferents"/>" />
									    <button type="submit" class="btn btn-primary btn-block" id="connexion"><span class="glyphicon glyphicon-log-in"></span> <fmt:message key="compte.form.submit"/></button>
									</div>
								</form>
								<!--Nouveau compte-->
								<div class="panel-footer text-center">
									<label class="small">---<fmt:message key="compte.retour.titre"/>---</label>
									<button type="button" class="btn btn-default btn-block" onClick="document.location.href='ConnexionServlet?action=CANCEL'"><fmt:message key="compte.retour.bouton"/></button>
								</div>
							</div>
						</div>
					</div>
				
					<!--Le texte de bienvenue-->	
					<div class="col-sm-7">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3><fmt:message key="compte.panel.titre"/></h3>
							</div>
							<div class="panel-body">
								<ul>
									<li><fmt:message key="compte.panel.instruction1"/></li>
									<li><fmt:message key="compte.panel.instruction2"/></li>
									<li>
										<fmt:message key="compte.panel.instruction3a"/><br />
										<fmt:message key="compte.panel.instruction3b"/><br />
										<fmt:message key="compte.panel.instruction3c"/>
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
	<jsp:include page="jspf/footer.jsp"></jsp:include>

</body>
</html>