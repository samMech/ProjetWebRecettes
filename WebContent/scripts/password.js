/**
 * Script pour la fonction vérifiant si les 2 mots de passes sont identiques
 */

function comparerPasswords(){
	
	var pwd1 = document.getElementById("pwd");
	var pwd2 = document.getElementById("pwd2");
	
	if(pwd1.value != "" && pwd2.value != ""){	
		if(pwd1.value != pwd2.value){
			var msg = document.getElementById("msgErreurPasswordsDifferents").value;
			pwd2.setCustomValidity(msg);
		}
		else{
			pwd2.setCustomValidity('');
		}	
	}
	
	return 	
}