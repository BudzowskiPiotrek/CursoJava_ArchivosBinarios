package CursoJava_ArchivosBinarios.Actividad2;

import java.io.Serializable;

public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    public static int contador = 0;
    private int id;
    private String titulo;
    private String autor;
    private int anio;
    private Genero genero;

    public Libro(String titulo, String autor, int anio, Genero genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.id = contador;
        contador++;
    }

    public static void setContador(int contador) {
        Libro.contador = contador;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public static int getContador() {
        return contador;
    }

    public int getId() {
        return id;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public Genero getGenero() {
        return genero;
    }

    public void verDatos() {
        System.out.println("Id: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + anio);
        System.out.println("Genero: " + genero);
    }
}
