USE academia;

-- 1. Listado de alumnos en el curso 1, mostrar detalle del profesor.

SELECT a.id 'id_alumno', CONCAT(a.nombre, ' ' , a.apellidos) AS 'alumno' , curso, 
	   p.id 'id_profesor', CONCAT(p.nombre, ' ', p.apellidos) AS 'profesor'
FROM  alumnos a, profesores p, cursos c, alumnosCurso ac
WHERE c.id = 1 AND a.id = ac.idAlumno AND ac.idCurso = c.id AND c.idProfesor = p.id
ORDER BY a.nombre ASC LIMIT 500;


-- 2. Contar el número de alumnos en curso 2.

SELECT COUNT(a.id) 'num_Alumnos_curso_2'
FROM alumnos a, alumnosCurso ac, cursos c
WHERE c.id = 2 AND a.id = ac.idAlumno AND ac.idCurso = c.id;


-- 3. Listar todos los alumnos de la bbdd.

SELECT a.id 'id_alumno', CONCAT(a.nombre, ' ' , a.apellidos) AS 'alumno'
FROM  alumnos a
ORDER BY a.apellidos ASC LIMIT 500;


-- 4. Listar todos los profesores y su curso.

SELECT p.id 'id_profesor', CONCAT(p.nombre, ' ', p.apellidos) AS 'profesor', c.curso, c.identificador, c.horas 
FROM  profesores p, cursos c
WHERE c.idProfesor = p.id
ORDER BY p.nombre ASC LIMIT 500;
