package academia.modelo.pojo;

import java.util.ArrayList;

import javax.validation.constraints.NotEmpty;

public class Curso {
	
	private int id;
	
	@NotEmpty(message = ": este campo no puede quedar vacío")
	private String nombre;
	
	@NotEmpty(message = ": este campo no puede quedar vacío")
	private String codigo;
	
	@NotEmpty(message = ": este campo no puede quedar vacío")
	
	private int horas;
	private Usuario profesor;
	private ArrayList<Usuario> alumnos;
	
	public Curso() {
		super();
		this.id = 0;
		this.nombre = "";
		this.codigo = "";
		this.horas = 0;
		this.profesor = new Usuario();
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

	public ArrayList<Usuario> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Usuario> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", horas=" + horas + "]";
	}
	
} // class
