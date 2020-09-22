package academia.modelo.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Curso {
	
	private int id;
	
	@NotEmpty(message = " introduce el nombre del curso.")
	private String nombre;
	
	@NotEmpty(message = " introduce el código del curso.")
	private String codigo;
	
	@Min(value = 1, message = ": el número de horas no puede ser menor a 1.")
	private int horas;
	
	private Usuario profesor;
	private int numeroAlumnos;
	
	// TODO Devolver un ArrayList con todos los alumnos y sus datos.
	// private ArrayList<Usuario> alumnos;
	
	public Curso() {
		super();
		this.id = 0;
		this.nombre = "";
		this.codigo = "";
		this.horas = 0;
		this.profesor = new Usuario();
		this.numeroAlumnos = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public Usuario getProfesor() {
		return profesor;
	}

	public void setProfesor(Usuario profesor) {
		this.profesor = profesor;
	}

	public int getNumeroAlumnos() {
		return numeroAlumnos;
	}

	public void setNumeroAlumnos(int numeroAlumnos) {
		this.numeroAlumnos = numeroAlumnos;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", horas=" + horas + ", profesor="
				+ profesor + ", numeroAlumnos=" + numeroAlumnos + "]";
	}

} // class
