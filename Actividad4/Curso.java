package CursoJava_ArchivosBinarios.Actividad4;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private Set<Alumno> alumno;
    private transient Set<Profesor> profesor;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.alumno = new HashSet<>();
        this.profesor = new HashSet<>();
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Alumno> getAlumno() {
        return alumno;
    }

    public Set<Profesor> getProfesor() {
        return profesor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlumno(Set<Alumno> alumno) {
        this.alumno = alumno;
    }

    public void setProfesor(Set<Profesor> profesor) {
        this.profesor = profesor;
    }

    public void agregarAlumno(Alumno a) {
        alumno.add(a);
    }

    public void agregarProfesor(Profesor a) {
        profesor.add(a);
    }

    public void verDatos() {
        System.out.println("Nombre del curso: " + nombre);

        if (!alumno.isEmpty()) {
            System.out.println("\n - Alumnos:");
            for (Alumno a : alumno) {
                System.out.println("    - " + a.getNombre() + ", nota: " + a.getNota());
            }
        } else {
            System.out.println(" - No tiene alumnos Asignados");
        }
        System.out.println("\n - Profesores:");

        if (profesor == null) {
            System.out.println("    - no disponible");
        } else {
            for (Profesor p : profesor) {
                System.out.println("    - " + p.getNombre() + ", correo: " + p.getEmail());
            }
        }
    }
}
