package CursoJava_ArchivosBinarios.Actividad6;

import java.io.Serializable;

public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int contador = 0;
    private int codigo;
    private String nombre;
    private int stock;
    private double precio;
    private transient String provedor;

    public Producto(String nombre, int stock, double precio, String provedor) {
        this.codigo = contador;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.provedor = provedor;
        contador++;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public String getProvedor() {
        return provedor;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Producto.contador = contador;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    public void verDatos() {
        System.out.println("----- ----- ----- -----");
        System.out.println("La Id: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Stock: " + stock);
        System.out.println("Precio: " + precio);
        if (provedor != null) {
            System.out.println("Provedor: " + provedor);
        }

    }

}
