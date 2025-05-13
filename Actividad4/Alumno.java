package CursoJava_ArchivosBinarios.Actividad4;

import java.io.Serializable;

public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    public static int contador = 0;
    private int id;
    private String nombre;
    private double nota;

    public Alumno(String nombre, double nota) {
        this.id = contador;
        this.nombre = nombre;
        this.nota = nota;
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

    public double getNota() {
        return nota;
    }

    public static void setContador(int contador) {
        Alumno.contador = contador;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    public void verDatos(){
        System.out.println("Id: "+id);
        System.out.println("Nombre: "+ nombre);
        System.out.println("Nota: " + nota);
        System.out.println("---- ---- ---- ----");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        long temp;
        temp = Double.doubleToLongBits(nota);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alumno other = (Alumno) obj;
        if (id != other.id)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (Double.doubleToLongBits(nota) != Double.doubleToLongBits(other.nota))
            return false;
        return true;
    }


}
