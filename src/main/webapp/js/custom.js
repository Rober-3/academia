function cifrar() {
		
		// Recuperar el valor de la contraseña del input a traves de su id.
		var cifrada = document.getElementById('contrasena').value;		
		
		// Conseguir el hash mediante la librería incluida en el pie de login.jsp
		var hash = md5(cifrada);
		
		// Guardar en el atributo value del input el código hash.
		document.getElementById('contrasena').value = hash;
				
		// Enviar el formulario.
		return true;
}

