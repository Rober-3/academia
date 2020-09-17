package academia.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import academia.modelo.ConnectionManager;
import academia.modelo.dao.UsuarioDAO;
import academia.modelo.pojo.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
	
	private static final Logger LOG = Logger.getLogger(UsuarioDAOImpl.class);
	
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
	
	private static final String SQL_GET_BY_ID = "SELECT id, nombre, apellidos, rol, contrasena "
											  + "FROM usuarios WHERE id = ?;";
	
	private static final String SQL_BUSCAR = 	"SELECT id, nombre, apellidos, rol FROM usuarios "
										   + 	"WHERE nombre = ? AND contrasena = MD5(?);";
	
	
	@Override
	public Usuario getById(int idPojo) throws Exception {
		
		Usuario usuario = new Usuario();
		
		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);
				
				){
			
			pst.setInt(1, idPojo);
			LOG.debug(pst);
			
			try (ResultSet rs = pst.executeQuery()) {
				
				if (rs.next()) {
					
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setApellidos(rs.getString("apellidos"));
					usuario.setRol(rs.getInt("rol"));
					usuario.setContrasena(rs.getString("contrasena"));
					
				} // if
				
			} // try interno
			
			
		} catch (Exception e) {
			LOG.error(e);
			
		} // try_catch
		
		return usuario;
	}

	@Override
	public Usuario buscar(String nombre, String contrasena) {

		Usuario usuario = new Usuario();
		
		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_BUSCAR);
				
				){
			
			pst.setString(1, nombre);
			pst.setString(2, contrasena);
			LOG.debug(pst);
			
			try (ResultSet rs = pst.executeQuery()) {
				
				if (rs.next()) {
					
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setApellidos(rs.getString("apellidos"));
					usuario.setRol(rs.getInt("rol"));
					
				} else {
					usuario = null;
				}
				
			} // try interno
			
			
		} catch (Exception e) {
			LOG.error(e);
			
		} // try_catch

		return usuario;

	} // buscar

	

	/// TODO Métodos por implementar.

	@Override
	public ArrayList<Usuario> getAll() throws Exception {
		return null;
	} // getAll

	
	
	@Override
	public Usuario insert(Usuario pojo) throws Exception {
		return null;
	} // insert

	
	
	@Override
	public Usuario update(Usuario pojo) throws Exception {
		return null;
	} // update

	
	
	@Override
	public Usuario delete(int idPojo) throws Exception {
		return null;
	} // delete

	
} // class
