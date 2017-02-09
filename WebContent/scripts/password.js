/**
 * Script pour la fonction vérifiant si les 2 mots de passes sont identiques
 */

function comparerPasswords(){
	
	var pwd1 = $("#pwd")
	var pwd2 = $("#pwd2")
	
	if(pwd1.value != pwd2.value){
		pwd2.setCustomValidity('<fmt:message key="compte.form.erreurPwdDifferents"/>');
	}
	else{
		pwd2.setCustomValidity('');
	}	
	
	return 	
}