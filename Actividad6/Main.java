package CursoJava_ArchivosBinarios.Actividad6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static List<Producto> productos = new ArrayList<>();
    public final static String RUTA = "CursoJava_ArchivosBinarios/Actividad6/Datos";

    public static void main(String[] args) {
        cargarDatos();
        menu();
    }

    private static void menu() {
        boolean condicion = true;
        while (condicion) {
            System.out.println("---- Menu Principal ----");

            try {
                int opcion = Integer.parseInt(br.readLine());
                condicion = menuSwitch(opcion);
            } catch (NumberFormatException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean menuSwitch(int opcion) {
        switch (opcion) {
            case 1:
                anadirProductos();
                break;
            case 2:
                ListarProductos();
                break;
            case 3:
                BuscarProductoPorCodigo();
                break;
            case 4:
                ActualizarStock();
                break;
            case 5:
                EliminarProducto();
                break;
            case 6:
                guardarDatos();
                return false;
        }
        return true;
    }

    private static void anadirProductos() {
        try {
            System.out.println("Escribe el nombre: ");
            String nombre = br.readLine();
            System.out.println("Escribe la cantidad del stock:");
            int stock = Integer.parseInt(br.readLine());
            System.out.println("Cual es su precio: ");
            double precio = Double.parseDouble(br.readLine());
            System.out.println("Escribe el nombre de su provedor");
            String provedor = br.readLine();
            Producto p1 = new Producto(nombre, stock, precio, provedor);
            productos.add(p1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ListarProductos() {
        if (!productos.isEmpty()) {
            for (Producto p : productos) {
                p.verDatos();
            }
        }
    }

    private static void BuscarProductoPorCodigo() {
        try {
            System.out.println("Escribe el codigo de producto: ");
            int codigo = Integer.parseInt(br.readLine());
            for (Producto p : productos) {
                if (p.getCodigo() == codigo) {
                    p.verDatos();
                    return;
                }
            }
            System.out.println("No se encontro producto con este codigo");
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void ActualizarStock() {
        try {
            System.out.println("Escribe el codigo de producto: ");
            int codigo = Integer.parseInt(br.readLine());
            Iterator<Producto> pr = productos.iterator();
            while (pr.hasNext()) {
                Producto producto = pr.next();
                if (producto.getCodigo() == codigo) {
                    System.out.println("Cual es stock nuevo: ");
                    int stock = Integer.parseInt(br.readLine());
                    producto.setStock(stock);
                    return;
                }
            }
            System.out.println("No se econtro prodcuto con codigo asi");

        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void EliminarProducto() {
        try {
            System.out.println("Escribe el codigo de producto: ");
            int codigo = Integer.parseInt(br.readLine());
            Iterator<Producto> pr = productos.iterator();
            while (pr.hasNext()) {
                Producto producto = pr.next();
                if (producto.getCodigo() == codigo) {
                    pr.remove();
                    return;
                }
            }
            System.out.println("No se econtro prodcuto con codigo asi");

        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void cargarDatos() {
        File archivo = new File(RUTA);
        if (!archivo.exists()) {
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA))) {
            productos = (List<Producto>) ois.readObject();
            Producto.setContador(ois.readInt());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void guardarDatos() {
        ObjectOutputStream aux = null;
        try (FileOutputStream fos = new FileOutputStream(RUTA)) {
            aux = new ObjectOutputStream(fos);
            aux.writeObject(productos);
            aux.writeInt(Producto.getContador());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
