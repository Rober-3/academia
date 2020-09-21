package academia.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import academia.modelo.ConnectionManager;
import academia.modelo.dao.CursoDAO;
import academia.modelo.pojo.Curso;
import academia.modelo.pojo.Usuario;

public class CursoDAOImpl implements CursoDAO{

	private static final Logger LOG = Logger.getLogger(CursoDAOImpl.class);

	private CursoDAOImpl() {
		super();
	}

	private static CursoDAOImpl INSTANCE = null;

	public static synchronized CursoDAOImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CursoDAOImpl();
		}
		return INSTANCE;
	}
	
	private static final String SQL_GET_BY_ID = 		  "SELECT id, curso, codigo, horas FROM cursos c WHERE id = ?";
	
	private static final String SQL_GET_BY_ID_BY_PROFE =  "SELECT c.id, c.curso, c.codigo, c.horas "
													   +  "FROM cursos c, usuarios u "
													   +  "WHERE c.id_profesor = u.id AND c.id = ? AND u.id = ? "
													   +  "ORDER BY c.curso ASC LIMIT 500;";

	private static final String SQL_GET_ALL =			  "SELECT c.id, c.curso, c.codigo, c.horas, "
											+			  "       u.id 'id_profesor', u.nombre 'nombre_profesor', " 
											+			  "	     u.apellidos 'apellidos_profesor' "
											+			  "FROM cursos c, usuarios u "
											+			  "WHERE c.id_profesor = u.id "
											+			  "ORDER BY c.curso ASC LIMIT 500;";

	private static final String SQL_GET_ALL_BY_PROFE =    "SELECT c.id, c.curso, c.codigo, c.horas "
													 +	  "FROM cursos c, usuarios u "
													 +	  "WHERE c.id_profesor = u.id AND u.id = ? "
													 +	  "ORDER BY c.curso ASC LIMIT 500;";
	
	// Cursos del alumno con subconsulta.
	private static final String SQL_GET_ALL_BY_ALUMNO =   "SELECT c.id 'id_curso', c.curso, c.codigo, c.horas, u.id 'id_profesor', "
													  +   "       u.nombre 'nombre_profesor', u.apellidos 'apellidos_profesor' "
													  +   "FROM cursos c, usuarios u "
													  +   "WHERE c.id_profesor = u.id AND c.id IN "
													  +	  "(SELECT id_curso FROM alumnosCurso ac WHERE id_alumno = ?) "
													  +	  "ORDER BY c.curso ASC LIMIT 500;";
	
	// Cursos del alumno sin subconsulta.
//	private static final String SQL_GET_ALL_BY_ALUMNO =   "SELECT c.id, c.curso, c.codigo, c.horas "
//			  										  +   "FROM cursos c, alumnosCurso ac, usuarios u "
//			  										  +   "WHERE c.id = ac.id_curso AND ac.id_alumno = u.id AND u.id = ? "
//			  										  +	  "ORDER BY c.curso ASC LIMIT 500;";
	
	// Cursos en los que un alumno no está inscrito (implica una subconsulta).
	private static final String SQL_GET_ALL_DISPONIBLES = "SELECT c.id 'id_curso', c.curso, c.codigo, c.horas, u.id 'id_profesor', "
														+ "       u.nombre 'nombre_profesor', u.apellidos 'apellidos_profesor' "
														+ "FROM cursos c, usuarios u "
														+ "WHERE c.id_profesor = u.id AND c.id NOT IN "
														+ "(SELECT id_curso FROM alumnosCurso ac WHERE id_alumno = ?) "
														+ "ORDER BY c.curso ASC LIMIT 500;";

	private static final String SQL_INSERT =			  "INSERT INTO cursos (curso, codigo, horas, id_profesor) VALUES (?, ?, ?, ?);";
	
	private static final String SQL_DELETE_BY_PROFE =	  "DELETE FROM cursos WHERE id = ? AND id_profesor = ?;";



	@Override
	public Curso getById(int idPojo) throws Exception {

		Curso curso = new Curso();
		
		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);
				
				) {
			
			pst.setInt(1, idPojo);
			LOG.debug(pst);
			
			try (ResultSet rs = pst.executeQuery()) {
				
				if (rs.next()) {
					
					curso.setId(rs.getInt("id"));
					curso.setNombre(rs.getString("curso"));
					curso.setCodigo(rs.getString("codigo"));
					curso.setHoras(rs.getInt("horas"));
					
				} else {
					throw new Exception("No se ha encontrado ningún curso asociado a ese id.");
				}
				
			} // try interno
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return curso;
		
	} // getById
	
	
	
	@Override
	public Curso getByIdByProfe(int idCurso, int idProfesor) throws Exception {
		
		Curso curso = new Curso();
		
		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID_BY_PROFE);
				
				) {
			
			pst.setInt(1, idCurso);
			pst.setInt(2, idProfesor);
			LOG.debug(pst);
			
			try (ResultSet rs = pst.executeQuery()) {
				
				if (rs.next()) {
					
					curso.setId(rs.getInt("id"));
					curso.setNombre(rs.getString("curso"));
					curso.setCodigo(rs.getString("codigo"));
					curso.setHoras(rs.getInt("horas"));
					
				} else {
					throw new Exception("No se ha encontrado ningún curso asociado a tu id.");
				}
				
			} // try interno
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return curso;

	} // getByIdByProfe



	@Override
	public ArrayList<Curso> getAll() {

		ArrayList<Curso> cursos = new ArrayList<Curso>();

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();

				) {

			LOG.debug(pst);

			while (rs.next()) {

				Usuario profesor = new Usuario();
				profesor.setId(rs.getInt("id_profesor"));
				profesor.setNombre(rs.getString("nombre_profesor"));
				profesor.setApellidos(rs.getString("apellidos_profesor"));

				Curso curso = new Curso();
				curso.setId(rs.getInt("id"));
				curso.setNombre(rs.getString("curso"));
				curso.setCodigo(rs.getString("codigo"));
				curso.setHoras(rs.getInt("horas"));
				curso.setProfesor(profesor);
				cursos.add(curso);
				
			} // while

		} catch (Exception e) {
			LOG.error(e);
		}

		return cursos;

	} // getAll



	@Override
	public ArrayList<Curso> getAllByProfe(int idProfesor) {

		ArrayList<Curso> cursos = new ArrayList<Curso>();

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_BY_PROFE);

				) {

			pst.setInt(1, idProfesor);
			LOG.debug(pst);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {

					Curso curso = new Curso();
					
					curso.setId(rs.getInt("id"));
					curso.setNombre(rs.getString("curso"));
					curso.setCodigo(rs.getString("codigo"));
					curso.setHoras(rs.getInt("horas"));
					
					cursos.add(curso);

				} // while

			} // try interno

		} catch (Exception e) {
			LOG.error(e);
		}

		return cursos;

	} // getAllByProfe

	

	@Override
	public ArrayList<Curso> getAllByAlumno(int idAlumno) {

		ArrayList<Curso> cursos = new ArrayList<Curso>();

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_BY_ALUMNO);

				) {

			pst.setInt(1, idAlumno);
			LOG.debug(pst);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					
					Usuario profesor = new Usuario();
					profesor.setId(rs.getInt("id_profesor"));
					profesor.setNombre(rs.getString("nombre_profesor"));
					profesor.setApellidos(rs.getString("apellidos_profesor"));

					Curso curso = new Curso();
					curso.setId(rs.getInt("id_curso"));
					curso.setNombre(rs.getString("curso"));
					curso.setCodigo(rs.getString("codigo"));
					curso.setHoras(rs.getInt("horas"));
					curso.setProfesor(profesor);
					cursos.add(curso);

				} // if

			} // try interno

		} catch (Exception e) {
			LOG.error(e);
		}

		return cursos;

	} // getAllByAlumno
	
	
	
	@Override
	public ArrayList<Curso> getAllDisponibles(int idAlumno) {
		ArrayList<Curso> cursos = new ArrayList<Curso>();

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_DISPONIBLES);

				) {

			pst.setInt(1, idAlumno);
			LOG.debug(pst);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					
					Usuario profesor = new Usuario();
					profesor.setId(rs.getInt("id_profesor"));
					profesor.setNombre(rs.getString("nombre_profesor"));
					profesor.setApellidos(rs.getString("apellidos_profesor"));

					Curso curso = new Curso();
					curso.setId(rs.getInt("id_curso"));
					curso.setNombre(rs.getString("curso"));
					curso.setCodigo(rs.getString("codigo"));
					curso.setHoras(rs.getInt("horas"));
					curso.setProfesor(profesor);
					cursos.add(curso);

				} // if

			} // try interno

		} catch (Exception e) {
			LOG.error(e);
		}
		
		return cursos;
		
	} // getAllDisponibles
	


	@Override
	public Curso insert(Curso curso) throws Exception {

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);

				){

			pst.setString(1, curso.getNombre());
			pst.setString(2, curso.getCodigo());
			pst.setInt(3, curso.getHoras());
			pst.setInt(4, curso.getProfesor().getId());
			LOG.debug(pst);
			
			int affectedRows = pst.executeUpdate();
			
			if (affectedRows == 1) {
				
				try (ResultSet rsKeys = pst.getGeneratedKeys()){
					
					if (rsKeys.next()) {
						int id = rsKeys.getInt(1);
						curso.setId(id);
					}
					
				} // try interno
				
			} else {
				throw new Exception("Ha habido un problema al intentar insertar el curso " + curso + ".");
			}

		} // try externo
		
		return curso;

	} // insert



	@Override
	public Curso deleteByProfe(int idCurso, int idProfesor) throws Exception {

		Curso curso = getByIdByProfe(idCurso, idProfesor);

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE_BY_PROFE);

				){

			pst.setInt(1, idCurso);
			pst.setInt(2, idProfesor);
			LOG.debug(pst);

			pst.executeUpdate();

		} catch (Exception e) {
			LOG.error(e);
		}

		return curso;

	} // deleteByProfe



	// TODO Métodos por implementar.
	
	@Override
	public Curso update(Curso pojo) throws Exception {
		return null;
	} // update

	

	@Override
	public Curso delete(int idPojo) throws Exception {
		return null;
	} // delete


} // class
