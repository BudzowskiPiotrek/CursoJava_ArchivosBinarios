package CursoJava_ArchivosBinarios.Actividad1;

import java.io.Serializable;

public class Profesor implements Serializable{
    private String nombre;
    private String email;

    public Profesor(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public void mostrarInfo() {
        System.out.println("Profesor: " + nombre + ", Email: " + email);
    }
}
