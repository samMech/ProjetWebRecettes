/**
 * Script pour la gestion du panier dans la page de recherche
 * 
 * Il faut une partie AJAX pour notifier la servlet de mettre à jour le panier dans la session
 * sans avoir à recharger la page (et perdre les résultats de la recherche)
 */

var req;
var isIE;

//Fonction pour initialiser la requête
function initRequest() {
    if (window.XMLHttpRequest) {
        if (navigator.userAgent.indexOf('MSIE') != -1) {
            isIE = true;
        }
        return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        return new ActiveXObject("Microsoft.XMLHTTP");//IE 6 ou 7
    }
}

// Fonction pour ajouter une une recette dans le panier'
function ajouterRecette(idRecette, nomRecette) {		
	// On vérifie si la recette est dans le panier
	var recette = document.getElementById("recettePanier" + idRecette);
	if(recette != null){
		incrementerRecette(idRecette);
	}
	else{
		ajouterRecettePanier(idRecette, nomRecette);
	}
}


// Fonction pour retirer une recette du panier
function retirerRecette() {		
	// On vérifie si la recette est dans le panier
	var recette = document.getElementById("recettePanier" + idRecette);
	if(recette != null){
		decrementerRecette(idRecette);
	}	
}

// Fonction pour incrémenter la quantité d'une recette existante dans le panier
function incrementerRecette(idRecette){	
	// On récupère le badge contenant la quantité
	var badge = document.getElementById("nbRecettes" + idRecette);
	var quantite = Number(badge.innerHTML);
	badge.innerHTML = quantite + 1
	
	// Envoie du changement à la servlet pour mettre le panier dans la session à jour
	var url = "ListeEpicerieServlet?action=INCREMENTER&idRecette=" + idRecette;
	req = initRequest();    
    req.open("GET", url, true);    
    req.onreadystatechange = ignorerReponse;
    req.send(null);	
}

// Fonction pour décrémenter la quantité d'une recette existane dans le panier
function decrementerRecette(idRecette){
	// On récupère le badge contenant la quantité
	var badge = document.getElementById("nbRecettes" + idRecette);
	var quantite = Number(badge.innerHTML);
	if(quantite == 0){
		retirerRecettePanier(idRecette);
	}
	else{
		badge.innerHTML = quantite - 1		
	}		
	
	// Envoie du changement à la servlet pour mettre le panier dans la session à jour
	var url = "ListeEpicerieServlet?action=DECREMENTER&idRecette=" + idRecette;
	req = initRequest();    
    req.open("GET", url, true);    
    req.onreadystatechange = ignorerReponse;
    req.send(null);
}

// Fonction pour traiter la réponse de la servlet
function ignorerReponse(){
	if (req.readyState == 4) {
        if (req.status == 200) {           
            return;          
        }
        else{
        	alert("Erreur Panier ! (" + req.readyState + ")");// Pour débogguer
        }
    }	
}

// Fonction pour ajouter une recette dans le panier
function ajouterRecettePanier(idRecette, nomRecette){
	// Récupération du panier
	var panier = document.getElementById("panierRecette");
	
	// Création des éléments
	var div = document.createElement('div');
	div.setAttribute("class", "list-group-item noBorder");
	div.setAttribute("id","recettePanier" + idRecette);
	
	var div2 = document.createElement('div');
	div2.setAttribute("class", "media");
	
	var div3a = document.createElement('div');
	div3a.setAttribute("class", "media-body");
	var h4 = document.createElement('h4');
	var lienRecette = document.createElement('a');
	lienRecette.setAttribute("href","RecetteServlet?voirRecette&idRecette=" + idRecette);
	lienRecette.setAttribute("class","list-group-item-heading");
	lienRecette.innerHTML = nomRecette;
	
	var div3b = document.createElement('div');
	div3b.setAttribute("class", "media-left media-middle");
	var span3b = document.createElement('span');
	span3b.setAttribute("class", "badge alert-info");
	span3b.setAttribute("id", "nbRecettes" + idRecette);
	span3b.innerHTML = 1;
	
	var div3c = document.createElement('div');
	div3c.setAttribute("class", "media-right media-middle");
	var span3c = document.createElement('span');
	span3c.setAttribute("class", "mouseIcon glyphicon glyphicon-plus-sign green");
	span3c.setAttribute("onclick", "ajouterRecette(" + idRecette + ",'" + nomRecette + "')");
	
	var div3d = document.createElement('div');
	div3d.setAttribute("class", "media-right media-middle");
	var span3d = document.createElement('span');
	span3d.setAttribute("class", "mouseIcon glyphicon glyphicon-minus-sign red");
	span3d.setAttribute("onclick", "retirerRecette(" + idRecette + ")");
	
	var input = document.createElement('input');
	input.setAttribute("type", "hidden");
	input.setAttribute("name", "recettePanier");
	input.setAttribute("value", idRecette);
	
	// Assemblage des éléments
	h4.appendChild(lienRecette);
	
	div3a.appendChild(h4);	
	div3b.appendChild(span3b);
	div3c.appendChild(span3c);
	div3d.appendChild(span3d);
	
	div2.appendchild(div3a);
	div2.appendchild(div3b);
	div2.appendchild(div3c);
	div2.appendchild(div3d);
	
	div.appendChild(div2);
	div.appendchild(input);
	
	panier.appendChild(div);			
}

// Fonction pour retirer une recette du panier
function retirerRecettePanier(idRecette){
	// Récupération du panier
	var panier = document.getElementById("panierRecette");
	
	// Récupération de la recette
	var recette = document.getElementById("recettePanier" + idRecette);
	
	// On supprime la recette du panier
	panier.removeChild(recette);
}