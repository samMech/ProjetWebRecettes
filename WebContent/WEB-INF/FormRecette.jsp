<!DOCTYPE html>
<html lang="en">
<head>
	<title>La Boîte à Ingrédients</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/styles.css">
	<script type="text/javascript" src="required-field.js"></script>
	<link rel="stylesheet" type="text/css" href="required-field-block.css">
</head>
<body>

	<!--La barre de navigation-->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Logo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="bienvenue.html"><span
							class="glyphicon glyphicon-home"></span> Accueil</a></li>
					<li><a href="recherche.html">Nouvelle liste d'épicerie</a></li>
					<li class="active"><a href="formRecettes.html">Nouvelle
							recette</a></li>
					<li>
						<form class="navbar-form" id="formRechercheRapide"
							action="recherche.html">
							<div class="form-group input-group">
								<input type="text" class="form-control"
									placeholder="Recherche rapide" name="texteRecherche"
									id="texteRecherche">
								<div class="input-group-btn">
									<button class="btn btn-info" type="submit" id="rechercheRapide">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</div>
							</div>
						</form>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#en"><span class="glyphicon glyphicon-globe"></span>
							English</a></li>
					<li><a href="index.html"><span
							class="glyphicon glyphicon-log-out"></span> Déconnexion</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<br>
	<br>
	<br>
	<br>

	<!--Le contenu central-->
	<div class="container-fluid wrapText">
		<div class="row content">

			<!--La barre de navigation gauche-->
			<div class="col-sm-2 col-lg-3 hidden-xs"></div>

			<!--Le panneau central-->
			<div class="col-sm-8 col-lg-6 text-left">

				<div class="panel panel-primary">
					<div class="panel-heading text-center">
						<h1>Nouvelle recette</h1>
					</div>
				</div>

				<!--Section Formulaire-->
				<form id="formRecette" method="POST" action="viewRecette.html">
					<!--Première section -->
					<div class="panel panel-info">
						<div class="panel-heading text-center">
							<h3>Informations générales</h3>
						</div>
						<div class="panel-body">
							<!--Section nom-->
							<div class="form-group">
								<label for="nomRecette">Nom </label>
								<div class="required-field-block">
									<input type="text" class="form-control" id="nomRecette"
										name="nomRecette" required>
									<div class="required-icon">
										<div class="text">*</div>
									</div>
								</div>
							</div>

							<!--Section description-->
							<div class="form-group">
								<label for="descRecette">Description</label>
								<textarea class="form-control" id="descRecette"
									name="descRecette"></textarea>
							</div>

							<!--Section temps de preparation -->
							<div class="form-group">
								<label for="tempsRecette">Temps de préparation</label>
								<div class="form-inline" id="tempsRecette">
									<input class="form-control form-control-inline" type="number"
										min="0" step="1" max="99" id="heureRecette"
										name="heureRecette"> <label for="heureRecette">
										h</label> <input class="form-control form-control-inline"
										type="number" min="0" step="1" max="59" id="minRecette"
										name="minRecette"> <label for="minRecette"> m</label>
								</div>
							</div>
						</div>
					</div>
					<!--Section Ingrédients-->
					<div class="panel panel-info">
						<div class="panel-heading text-center">
							<h3>Ingrédients</h3>
						</div>
						<div class="panel-body">
							<ul class="list-group" name="listeIngredients">
								<li class="list-group-item noBorder media" name="ingredient1">
									<div class="form-group media-body autoWidth">
										<input class="form-control form-control-inline" type="text"
											size="22" placeholder="Ingrédient" id="ingredient1"
											name="nomIngredient1" /> <input
											class="form-control form-control-inline" type="text" size="5"
											placeholder="Quantité" id="qte1" name="qte1" /> <select
											class="form-control form-control-inline" id="unite1"
											name="unite1">
											<option>g</option>
											<option>L</option>
											<option>mL</option>
											<option>g</option>
											<option>tasse(s)</option>
											<option>tbsp</option>
											<option>oz</option>
											<option>tsp</option>
											<optgroup>Tbs</optgroup>
										</select>
									</div>
									<div class="media-right media-middle">
										<span class="mouseIcon glyphicon glyphicon-plus-sign green"></span>
										<span class="mouseIcon glyphicon glyphicon-minus-sign red"></span>
									</div>
								</li>
								<li class="list-group-item noBorder media">
									<div class="form-group media-body autoWidth">
										<input class="form-control form-control-inline" type="text"
											size="22" placeholder="Ingrédient" id="ingredient2"
											name="nomIngredient2" /> <input
											class="form-control form-control-inline" type="text" size="5"
											placeholder="Quantité" id="qte2" name="qte2" /> <select
											class="form-control form-control-inline" id="unite2"
											name="unite2">
											<option>g</option>
											<option>L</option>
											<option>mL</option>
											<option>g</option>
											<option>tasse(s)</option>
											<option>tbsp</option>
											<option>oz</option>
											<option>tsp</option>
											<optgroup>Tbs</optgroup>
										</select>
									</div>
									<div class="media-right media-middle">
										<span class="mouseIcon glyphicon glyphicon-plus-sign green"></span>
										<span class="mouseIcon glyphicon glyphicon-minus-sign red"></span>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<!-- Section instructions -->
					<div class="panel panel-info">
						<div class="panel-heading text-center">
							<h3>Instructions</h3>
						</div>
						<div class="panel-body">
							<ul class="list-group" name="listeInstructions">
								<li class="list-group-item noBorder media">
									<div class="media-left media-top">
										<label for="instruction1">1.</label>
									</div>
									<div class="media-body autoWidth">
										<textarea cols="100" placeholder="Instruction"
											class="form-control" id="instruction1" name="instruction1"></textarea>
									</div>
									<div class="media-right media-middle">
										<span
											class="span3 mouseIcon glyphicon glyphicon-plus-sign green"></span>
										<span
											class="span3 mouseIcon glyphicon glyphicon-minus-sign red"></span>
									</div>
									<div class="media-right media-middle">
										<span
											class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-up blue"></span>
										<span
											class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-down blue"></span>
									</div>
								</li>
								<li class="list-group-item noBorder media">
									<div class="media-left media-top">
										<label for="instruction1">2.</label>
									</div>
									<div class="media-body autoWidth">
										<textarea cols="100" placeholder="Instruction"
											class="form-control" id="instruction2" name="instruction2"></textarea>
									</div>
									<div class="media-right media-middle">
										<span
											class="span3 mouseIcon glyphicon glyphicon-plus-sign green"></span>
										<span
											class="span3 mouseIcon glyphicon glyphicon-minus-sign red"></span>
									</div>
									<div class="media-right media-middle">
										<span
											class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-up blue"></span>
										<span
											class="span3 mouseIcon glyphicon glyphicon glyphicon-circle-arrow-down blue"></span>
									</div>
								</li>
							</ul>
						</div>
					</div>

					<!-- Section bouton enregistrer -->
					<button type="submit" class="btn btn-primary pull-left"
						id="btnSubmitRecette">Enregistrer</button>

				</form>

				<!--La barre de navigation droite-->
				<div class="col-sm-2 col-lg-3 hidden-xs"></div>

			</div>
		</div>

		<!--Le bas de page-->
		<br />
		<footer class="container-fluid text-center">
			<p>
				<span class="glyphicon glyphicon-copyright-mark"></span> 2016 La
				Boîte à Ingrédients
			</p>
		</footer>
	</div>
</body>
</html>