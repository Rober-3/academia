package academia.modelo.dao;

public interface CursoUsuarioDAO {
	
	/**
	 * Permite que un alumno se inscriba en un curso.
	 * @param idCurso Id del curso.
	 * @param idAlumno Id del alumno.
	 */
	public void inscribirAlumno(int idAlumno, int idCurso);

}
