

function validatePassword(){
   var password = document.getElementById("pass").value;
   var confirm_password = document.getElementById("validatePass").value;
   if (password != confirm_password) {
	   alert("Senhas diferentes");
   }
}
