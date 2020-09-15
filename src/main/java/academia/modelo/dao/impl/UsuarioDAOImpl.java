package academia.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import academia.modelo.ConnectionManager;
import academia.modelo.dao.UsuarioDAO;
import academia.modelo.pojo.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
	
	private UsuarioDAOImpl() {
		super();
	}
	
	private static UsuarioDAOImpl INSTANCE = null;
	
	public static synchronized UsuarioDAOImpl getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAOImpl();
		}
		return INSTANCE;
	}
	
	
	private static final String SQL_BUSCAR = "SELECT id, nombre, apellidos, rol, contrasena FROM personas "
										   + "WHERE nombre = ? AND contrasena = ?;";

	@Override
	public Usuario buscar(String nombre, String contrasena) {

		Usuario usuario = new Usuario();
		
		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_BUSCAR);
				
				){
			
			pst.setString(1, nombre);
			pst.setString(2, contrasena);
			
			try (ResultSet rs = pst.executeQuery()) {
				
				if (rs.next()) {
					
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setApellidos(rs.getString("apellidos"));
					usuario.setRol(rs.getInt("rol"));
					usuario.setContrasena(rs.getString("contrasena"));
					
				} else {
					usuario = null;
				}
				
			} // try interno
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} // try_catch

		return usuario;

	} // buscar

} // class
