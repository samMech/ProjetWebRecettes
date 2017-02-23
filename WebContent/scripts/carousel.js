/*
 *  Script pour la gestion du carrousel de la page d'accueil et de bienvenue
 */

$(document).ready(function (){
					
	// Les images du carrousel
	var images = [{
        url: "images/apple-1526578_960_720.jpg",
        alt: "Pommes"
    }, {
        url: "images/apple-1526581_960_720.jpg",
        alt: "Pommes"
    }, {
        url: "images/apple-1526584_960_720.jpg",
        alt: "Pommes"
    }, {
        url: "images/apple-1526601_960_720.jpg",
        alt: "Pommes"
    }, {
        url: "images/apple-1526602_960_720.jpg",
        alt: "Pommes"
    }, {
        url: "images/berries-1499900_960_720.jpg",
        alt: "Petits fruits"
    }, {
        url: "images/berries-1499902_960_720.jpg",
        alt: "Petits fruits"
    }, {
        url: "images/grapes-1526609_960_720.jpg",
        alt: "Raisins"
    }, {
        url: "images/vegetables-1529719_960_720.jpg",
        alt: "L�gumes"
    }, {
        url: "images/vegetables-1499904_960_720.jpg",
        alt: "L�gumes"
    }, {
        url: "images/vegetables-1499905_960_720.jpg",
        alt: "L�gumes"
    }, {
        url: "images/vegetables-1499906_960_720.jpg",
        alt: "L�gumes"
    }, {
        url: "images/seafood-1494193_960_720.jpg",
        alt: "Fruits de mer"
    }, {
        url: "images/seafood-1494194_960_720.jpg",
        alt: "Fruits de mer"
    }, {
        url: "images/sushi-1494195_960_720.jpg",
        alt: "Sushis"
    }, {
        url: "images/breakfast-1491729_960_720.jpg",
        alt: "C�r�ales et yogourts"
    }, {
        url: "images/pancake-1491731_960_720.jpg",
        alt: "Cr�pes"
    }, {
        url: "images/chocolate-1502455_960_720.jpg",
        alt: "Chocolat"
    }, {
        url: "images/chocolate-1502458_960_720.jpg",
        alt: "Chocolat"
    }, {
        url: "images/dessert-1491104_960_720.jpg",
        alt: "Desserts"
    }, {
        url: "images/dessert-1526592_960_720.jpg",
        alt: "Desserts"
    }, {
        url: "images/dessert-1526593_960_720.jpg",
        alt: "Desserts"
    }, {
        url: "images/dessert-1526598_960_720.jpg",
        alt: "Desserts"
    }, {
        url: "images/dessert-1526599_960_720.jpg",
        alt: "Desserts"
    }];
	
    // http://css-tricks.com/snippets/javascript/shuffle-array/
    images.sort(function () { return 0.5 - Math.random(); });// On organise les images al�atoirement

	// On remplit le carrousel avec les images
    $.each(images, function (index, image) {
        var element = $('<div class="item"><img class="img-responsive img-rounded center-block" src="' + image.url + '" alt="' + image.alt + '" /></div>')

        if (index === 0) {
            element.addClass("active");// La premi�re image active   
        }

        element.appendTo("#carouselAccueil div.carousel-inner");
    });
	
	// On ajuste les param�tres du carousel
	$('#carouselAccueil').carousel({
		interval: 8000
	});

	// Lancement du carousel
	$('#carouselAccueil').carousel('cycle');
});