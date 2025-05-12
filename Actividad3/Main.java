package CursoJava_ArchivosBinarios.Actividad3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String ARCHIVO = "CursoJava_ArchivosBinarios/Actividad3/Contactos.obj";
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static List<Contacto> contactos = new ArrayList<>();

    public static void main(String[] args) {
        cargarDatos();
        menu();
    }

    // METODO CON MENU PRINCIPAL
    private static void menu() {
        boolean flag = true;
        while (flag) {
            System.out.println("---- MENU PRINCIPAL----");
            System.out.println("Pulsa 1. Añadir contacto.");
            System.out.println("Pulsa 2. Ver todos los contactos.");
            System.out.println("Pulsa 3. Buscar por nombre.");
            System.out.println("Pulsa 4. Modificar un contacto");
            System.out.println("Pulsa 5. Para salir");
            try {
                int opcion = Integer.parseInt(br.readLine());
                flag = menuSwitch(opcion);
            } catch (NumberFormatException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    // METODO CON MENU PARTE DE SWITCH
    private static boolean menuSwitch(int opcion) {
        switch (opcion) {
            case 1:
                anadirContacto();
                break;
            case 2:
                verContactos();
                break;
            case 3:
                buscarPorNombre();
                break;
            case 4:
                modificar();
                break;
            case 5:
                guardarDatos();
                return false;
            default:
                System.out.println("Error, numero mal ingresado");
                break;
        }
        return true;
    }

    // METODO PARA CREAR CONTACTOS NUEVOS
    private static void anadirContacto() {
        try {
            System.out.println("Dime el nombre:");
            String nombre = br.readLine();
            if (nombre.matches(".{3,}")) {
                System.out.println("Nombre inválido.");
                return;
            }
            System.out.println("Dime su numero:");
            int numero = Integer.parseInt(br.readLine());
            if (!String.valueOf(numero).matches("\\d{9}")) {
                System.out.println("numero inválido.");
                return;
            }
            System.out.println("Cual es su correo?");
            String correo = br.readLine();
            if (!correo.matches("^[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("Correo inválido.");
                return;
            }

            Contacto nuevo = new Contacto(nombre, numero, correo);
            contactos.add(nuevo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODO PARA RECORER CONTACTOS Y VER SUS DATOS
    private static void verContactos() {
        if (!contactos.isEmpty()) {
            for (Contacto c : contactos) {
                c.verDatos();
            }
        }

    }

    // METODO PARA BUSCAR POR EL NOMBRE
    private static void buscarPorNombre() {
        try {
            System.out.println("Introduce el nombre del contacto:");
            String nombre = br.readLine();

            for (Contacto c : contactos) {
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    c.verDatos();
                    return;
                }
            }
            System.out.println("No se ha encontrado ningún contacto con ese nombre.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODO DE MODIFICAR, YA ME DABA PEREZA NI REUTILIZANDO CODIGO DE ANADIR CONTACTO NI CON EXPRESIONES
    private static void modificar() {
        try {
            System.out.println("Introduce el nombre del contacto a modificar:");
            String nombre = br.readLine().trim();

            Contacto aModificar = null;
            for (Contacto c : contactos) {
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    aModificar = c;
                }
            }

            if (aModificar != null) {
                System.out.println("Nuevo nombre:");
                String nuevoNombre = br.readLine();
                aModificar.setNombre(nuevoNombre);

                System.out.println("Nuevo teléfono: ");
                int nuevoTelefono = Integer.parseInt(br.readLine());
                aModificar.setTelefono(nuevoTelefono);

                System.out.println("Nuevo correo:");
                String nuevoCorreo = br.readLine();
                aModificar.setEmail(nuevoCorreo);
                
                System.out.println("Datos del contacto actualizados.");
            } else {
                System.out.println("No se ha encontrado ningún contacto con ese nombre.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODO PARA GUARDAR DATOS
    private static void guardarDatos() {
        ObjectOutputStream oos = null;
        try (FileOutputStream fos = new FileOutputStream(ARCHIVO)) {
            oos = new ObjectOutputStream(fos);

            oos.writeInt(Contacto.getContador());
            oos.writeObject(contactos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODO DE CARGAR DATOS
    private static void cargarDatos() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO));
            Contacto.setContador(ois.readInt());
            contactos = (ArrayList<Contacto>) ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
