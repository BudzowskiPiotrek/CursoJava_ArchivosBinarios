package CursoJava_ArchivosBinarios.Actividad3;

import java.io.Serializable;

public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;
    public static int contador = 0;
    private int id;
    private String nombre;
    private int telefono;
    private String email;

    public Contacto(String nombre, int telefono, String email) {
        this.id = contador;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        contador++;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public static int getContador() {
        return contador;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public static void setContador(int contador) {
        Contacto.contador = contador;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void verDatos() {
        System.out.println("Id: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Telefono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("----   -----   ----   ----");
    }
}