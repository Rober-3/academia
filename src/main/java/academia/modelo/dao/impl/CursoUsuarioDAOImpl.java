package academia.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import academia.modelo.ConnectionManager;
import academia.modelo.dao.CursoUsuarioDAO;

public class CursoUsuarioDAOImpl implements CursoUsuarioDAO {

	private static final Logger LOG = Logger.getLogger(CursoUsuarioDAOImpl.class);


	private CursoUsuarioDAOImpl() {
		super();
	}

	private static CursoUsuarioDAOImpl INSTANCE = null;

	public static synchronized CursoUsuarioDAOImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CursoUsuarioDAOImpl();
		}
		return INSTANCE;
	}


	private static final String SQL_INSCRIBIR = "INSERT INTO alumnosCurso (id_alumno, id_curso) VALUES (?,?);";


	@Override
	public void inscribirAlumno(int idAlumno, int idCurso) {

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSCRIBIR,PreparedStatement.RETURN_GENERATED_KEYS);

				){

			pst.setInt(1, idAlumno);
			pst.setInt(2, idCurso);
			LOG.debug(pst);

			pst.executeUpdate();

		} catch (Exception e) {
			LOG.error(e);
		}

	} // inscribir

} // class
