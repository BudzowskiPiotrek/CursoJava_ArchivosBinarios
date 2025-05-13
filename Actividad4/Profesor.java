package CursoJava_ArchivosBinarios.Actividad4;

public class Profesor {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String email;

    public Profesor(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void verDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
    }

}
