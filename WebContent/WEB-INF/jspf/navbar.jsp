<%@page session="true" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Logo</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
		
			<c:if test="${sessionScope.Usager != null}">
			<ul class="nav navbar-nav">
				<li><a href="ConnexionServlet"><span class="glyphicon glyphicon-home"></span> Accueil</a></li>
				<li class="active"><a href="RechercheServlet?action=chargerPage">Nouvelle liste d'épicerie</a></li>
				<li><a href="RecetteServlet?action=chargerFormulaire">Nouvelle recette</a></li>
				<li>
					<form class="navbar-form" id="formRechercheRapide" action="RechercheServlet?action=SEARCH">
						<div class="form-group input-group">
							<input type="text" class="form-control" placeholder="Recherche rapide" name="texteRecherche" id="texteRecherche">
							<div class="input-group-btn">
								<button class="btn btn-info" type="submit" id="rechercheRapide"><i class="glyphicon glyphicon-search"></i></button>
							</div>
						</div>
					</form>
				</li>
			</ul>
			</c:if>
			
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#en"><span class="glyphicon glyphicon-globe"></span> English</a></li>
				<li>
									
					<c:choose>
					   <c:when test="${sessionScope.Usager != null}">
					       <a href="ConnexionServlet?action=DECONNEXION"><span class="glyphicon glyphicon-log-out"></span>Déconnexion</a> 
					    </c:when>
					    <c:otherwise>
					        <a href="ConnexionServlet"><span class="glyphicon glyphicon-log-in"></span> Connexion</a>
					    </c:otherwise>
					</c:choose>
					
				</li>
			</ul>			
		</div>
	</div>
</nav>
<br><br><br><br>