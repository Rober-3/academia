function confirmar(nombre) {
	
	// Este método devuelve true si el usuario confirma la eliminación del curso y falso en caso contrario.
	// curso es el parámetro que se pasa desde profesor.jsp : ${c.curso}.
	
	if ( confirm('¿Estás seguro de querer eliminar ' + nombre + '?') ){
		
		console.debug('Continúa el evento por defecto del ancla.');
		
	}else {
		
		console.debug('Previene o detiene el evento del ancla.');
		event.preventDefault();
	}
	
}