package academia.modelo.dao;

import java.util.ArrayList;

import academia.interfaces.Crudable;
import academia.modelo.pojo.Curso;

public interface CursoDAO extends Crudable<Curso> {
	
	
	// MÉTODOS DEL PROFESOR
	
	/**
	 * Obtiene un curso por medio de su id y el id del profesor que lo imparte.
	 * @param idCurso Id del curso.
	 * @param idProfesor Id del profesor
	 * @return Curso
	 * @throws Exception 
	 */
	Curso getByIdByProfe(int idCurso, int idProfesor) throws Exception;
	
	/**
	 * Obtiene todos los cursos que imparte un profesor.
	 * @param idProfesor Id del profesor
	 * @return ArrayList&lt;Curso&gt;
	 */
	ArrayList<Curso> getAllByProfe(int idProfesor);
	
	/**
	 * Obtiene todos los cursos que imparte un profesor mostrando el número de alumnos inscritos en cada curso.
	 * @param idProfesor Id del profesor
	 * @return ArrayList&lt;Curso&gt;
	 * @throws Exception 
	 */
	ArrayList<Curso> getAllByProfeWithNumAlumnos(int idProfesor) throws Exception;
	
	/**
	 * Permite que un profesor borre un curso que imparte.
	 * @param idCurso Id del curso a borrar
	 * @param idProfesor Id del profesor que borra el curso
	 * @return Curso borrado
	 * @throws Exception 
	 */
	Curso deleteByProfe(int idCurso, int idProfesor) throws Exception;
	
	
	
	// MÉTODOS DEL ALUMNO
	
	/**
	 * Obtiene todos los cursos en los que está inscrito un alumno.
	 * @param idAlumno Id del alumno.
	 * @return ArrayList&lt;Curso&gt;
	 */
	ArrayList<Curso> getAllByAlumno(int idAlumno);
	
	/**
	 * Obtiene todos los cursos en los que no está inscrito un alumno para permitirle inscribirse en ellos.
	 * @param idAlumno Id del alumno
	 * @return ArrayList&lt;Curso&gt;
	 */
	ArrayList<Curso> getAllDisponibles(int idAlumno);
	

} // interface
