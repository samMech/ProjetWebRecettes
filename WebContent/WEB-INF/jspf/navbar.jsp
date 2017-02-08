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
				<li><a href="bienvenue.html"><span class="glyphicon glyphicon-home"></span> Accueil</a></li>
				<li class="active"><a href="recherche.html">Nouvelle liste d'épicerie</a></li>
				<li><a href="formRecettes.html">Nouvelle recette</a></li>
				<li>
					<form class="navbar-form" id="formRechercheRapide" action="recherche.html">
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
					<a href="index.html">						
						<c:choose>
						   <c:when test="${sessionScope.Usager != null}">
						       <span class="glyphicon glyphicon-log-out"></span>Déconnexion 
						    </c:when>
						    <c:otherwise>
						        <span class="glyphicon glyphicon-log-in"></span> Connexion
						    </c:otherwise>
						</c:choose>
					</a>
				</li>
			</ul>			
		</div>
	</div>
</nav>
<br><br><br><br>