package academia.modelo.pojo;

public class CursoUsuario {
	
	private int idCurso;
	private int idAlumno;
	
	public CursoUsuario() {
		super();
		this.idCurso = 0;
		this.idAlumno = 0;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	@Override
	public String toString() {
		return "CursoUsuario [idCurso=" + idCurso + ", idAlumno=" + idAlumno + "]";
	}
	
} // class
