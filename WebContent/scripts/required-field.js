/*
 *  Script pour l'affichage des tooltips pour les champs requis
 */ 
$(document).ready(function() {
	
	// Tooltip pour l'astérisque
    $('.required-icon').tooltip({
		placement: 'left',
		title: 'Champs obligatoire'
    });
	
	// Pour cacher le tooltip crée par le navigateur par défaut à cause de l'attribut 'required' (On cache le message par défaut quand le titre est vide...)
	$('input[required]').hover( function(){ $(this).attr('title',' ') }, function(){ $(this).removeAttr('title') });
});