package CursoJava_ArchivosBinarios.Actividad2;

import java.io.Serializable;

public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private String autor;
    private int anio;
    private Genero genero;

    public Libro(String titulo, String autor, int anio, Genero genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
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
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + anio);
        System.out.println("Genero: " + genero);
    }

    @Override
    public String toString() {
        return "Libro [titulo=" + titulo + ", autor=" + autor + ", anio=" + anio + ", genero=" + genero + "]";
    }

}
