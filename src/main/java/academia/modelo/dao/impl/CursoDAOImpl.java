package academia.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import academia.modelo.ConnectionManager;
import academia.modelo.dao.CursoDAO;
import academia.modelo.pojo.Curso;
import academia.modelo.pojo.Persona;

public class CursoDAOImpl implements CursoDAO{
	
	private static CursoDAOImpl INSTANCE = null;
	
	private CursoDAOImpl() {
		super();
	}
	
	public static synchronized CursoDAOImpl getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new CursoDAOImpl();
		}
		return INSTANCE;
	}
	
	private static final String SQL_LISTAR = "SELECT c.id 'id_curso', c.identificador, c.curso, c.horas,"
										   + 		"p.id 'id_profesor', p.nombre 'nombre_profesor', p.apellidos 'apellidos_profesor', p.rol "
										   + "FROM cursos c, personas p WHERE c.idProfesor = p.id;";
	
	@Override
	public ArrayList<Curso> listar() {
		
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		
		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_LISTAR);
				ResultSet rs = pst.executeQuery();
				
				) {
			
			while (rs.next()) {
				
				Persona profesor = new Persona();
				profesor.setId(rs.getInt("id_profesor"));
				profesor.setNombre(rs.getString("nombre_profesor"));
				profesor.setApellidos(rs.getString("apellidos_profesor"));
				profesor.setRol(rs.getInt("rol"));
				
				Curso curso = new Curso();
				curso.setId(rs.getInt("id_curso"));
				curso.setIdentificador(rs.getString("identificador"));
				curso.setNombre(rs.getString("curso"));
				curso.setHoras(rs.getInt("horas"));
				curso.setProfesor(profesor);
				
				cursos.add(curso);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cursos;
	}

}
