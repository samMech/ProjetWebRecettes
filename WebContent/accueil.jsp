<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%--Importation des librairies JSTL--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--On v�rifie si l'usager est d�j� connect�--%>
<c:if test="${sessionScope.Usager != null}">
	<%--Redirection vers la page de bienvenue--%>
	<jsp:forward page="/ConnexionServlet?action=BIENVENUE"></jsp:forward>
</c:if>

<%--On v�rifie si la langue de la session a �t� initialis�e--%>
<c:if test="${sessionScope.langue == null}">
	<%--Passage par la servlet pour initialiser la langue avant de revenir ici--%>
	<jsp:forward page="/I18nServlet"></jsp:forward>
</c:if>

<%--Initialisation de la locale--%>
<fmt:setLocale value="${sessionScope.langue != null ? sessionScope.langue : pageContext.request.locale.language}"/>
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
	<script type="text/javascript" src="scripts/carousel.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/carousel.css">
	<script type="text/javascript" src="scripts/required-field.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/required-field-block.css">
</head>
<body>

	<!--La barre de navigation-->
	<jsp:include page="WEB-INF/jspf/navbar.jsp"></jsp:include>
		
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
								<h2><fmt:message key="accueil.form.titre"/></h2>
							</div>
							<div class="panel-body">
								<form id="formConnexion" method="POST" action="ConnexionServlet">
									<!--Login-->
									<div class="form-group">
										<label for="email"><fmt:message key="accueil.form.login"/></label>
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
										<label for="pwd"><fmt:message key="accueil.form.password"/></label>
										<a class="pull-right" href="CompteServlet?url=resetPassword.jsp"><fmt:message key="accueil.form.passwordOublie"/></a><!--Password reset-->
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
										<label><input type="checkbox" id="optConnexion" name="optConnexion" value="true"/> <fmt:message key="accueil.form.resterConnecte"/></label>
									</div>	
																	
									<c:if test="${requestScope.erreurConnexion == true}">
									<!--Erreur-->
									<div class="form-group text-center">
										<h3 class="text-center"><span class="label label-warning"><fmt:message key="accueil.form.erreurInfosConnexion"/></span></h3><br />
									</div>									
									</c:if>	
																	
									<!--Enter-->
									<div class="form-group text-center">
										<input type="hidden" name="action" value="SE_CONNECTER" />
									    <button type="submit" class="btn btn-primary btn-block" id="connexion"><span class="glyphicon glyphicon-log-in"></span> <fmt:message key="accueil.form.submit"/></button>
									</div>
								</form>
								<!--Nouveau compte-->
								<div class="panel-footer text-center">
									<label class="small">---<fmt:message key="accueil.form.compte"/>---</label>
									<button type="button" class="btn btn-default btn-block" onclick="document.location.href='CompteServlet?url=creerCompte.jsp'"><fmt:message key="accueil.form.creerCompte"/></button>
								</div>
							</div>
						</div>
					</div>
				
					<!--Le texte de bienvenue-->	
					<div class="col-sm-7">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3><fmt:message key="accueil.panel.bienvenue"/></h3>
							</div>
							<div class="panel-body">
								<p>
									<fmt:message key="accueil.panel.message1"/>
									<br /><br />
									<fmt:message key="accueil.panel.message2"/>
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