package academia.modelo.dao;

import academia.modelo.pojo.Usuario;

public interface UsuarioDAO {
	
	/**
	 * Busca usuarios en la bbdd por su nombre y contraseña.
	 * @param nombre
	 * @param contrasena Se encuentra en texto plano y en la bbdd está cifrada en MD5.
	 * @return Si encuentra uno retorna un usuario que puede tener el rol de alumno o de profesor,
	 * 		   si no lo encuentra retorna null.
	 */
	Usuario buscar (String nombre, String contrasena);

}
