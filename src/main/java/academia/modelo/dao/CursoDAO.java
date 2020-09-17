package academia.modelo.dao;

import java.util.ArrayList;

import academia.interfaces.Crudable;
import academia.modelo.pojo.Curso;

public interface CursoDAO extends Crudable<Curso> {
	
	
	// MÉTODOS DEL PROFESOR
	
	/**
	 * Obtiene un curso de la base de datos por medio de su id y el id del profesor que lo imparte.
	 * @param idCurso Id del curso.
	 * @param idProfesor Id del profesor.
	 * @return Curso.
	 * @throws Exception 
	 */
	Curso getByIdByProfe(int idCurso, int idProfesor) throws Exception;
	
	/**
	 * Obtiene todos los cursos de la base de datos pertenecientes a un profesor.
	 * @param idProfesor Id del profesor.
	 * @return Lista de cursos.
	 */
	ArrayList<Curso> getAllByProfe(int idProfesor);
	
	/**
	 * Permite que un profesor inserte un curso en la base de datos.
	 * @param idProfesor Id del profesor que inserta el curso.
	 * @return Curso insertado.
	 * @throws Exception 
	 */
	Curso insertByProfe(int idProfesor, Curso curso) throws Exception;
	
	/**
	 * Permite que un profesor borre un curso de la base de datos.
	 * @param idCurso Id del curso a borrar.
	 * @param idProfesor Id del profesor que borra el curso.
	 * @return Curso borrado.
	 * @throws Exception 
	 */
	Curso deleteByProfe(int idCurso, int idProfesor) throws Exception;
	
	
	
	// MÉTODOS DEL ALUMNO
	
	/**
	 * Obtiene todos los cursos en los que está inscrito un alumno.
	 * @param idAlumno Id del alumno.
	 * @return Lista de cursos.
	 */
	ArrayList<Curso> getAllByAlumno(int idAlumno);
	
	/**
	 * Obtiene todos los cursos en los que no está inscrito un alumno para permitirle inscribirse en ellos.
	 * @param idAlumno Id del alumno.
	 * @return Lista de cursos.
	 */
	ArrayList<Curso> getAllDisponibles(int idAlumno);
	

} // interface
