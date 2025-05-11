package CursoJava_ArchivosBinarios.Actividad1;

import java.io.*;
import java.util.ArrayList;

public class Main {
    // creamos las variables staticas para el nombre del fichero y del propio
    // ArrayList
    private static final String ARCHIVO = "asignaturas.obj";
    private static ArrayList<Asignatura> asignaturas = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Cargar datos si existen (deserializar)
        cargarDatos();

        // Todo lo que ocurre a continuación ya lo hemos visto a lo largo del curso
        // Mostrar asignaturas actuales
        if (!asignaturas.isEmpty()) {
            System.out.println("\n📚 Asignaturas registradas:");
            for (Asignatura a : asignaturas) {
                System.out.println("-----------");
                a.verDatos();
            }
        } else {
            System.out.println("No hay asignaturas registradas.");
        }

        // Agregar nuevas asignaturas
        try {
            System.out.println("\n¿Deseas añadir nuevas asignaturas? (s/n)");
            String respuesta = br.readLine();

            while (respuesta.equalsIgnoreCase("s")) {
                System.out.print("Código: ");
                String codigo = br.readLine();

                System.out.print("Nombre: ");
                String nombre = br.readLine();

                System.out.print("Créditos: ");
                int creditos = Integer.parseInt(br.readLine());

                System.out.print("Nombre del profesor: ");
                String nombreProf = br.readLine();

                System.out.print("Email del profesor: ");
                String emailProf = br.readLine();

                Profesor profe = new Profesor(nombreProf, emailProf);
                Asignatura nueva = new Asignatura(codigo, nombre, creditos, profe);
                asignaturas.add(nueva);

                System.out.println("Asignatura añadida.\n¿Deseas añadir otra? (s/n)");
                respuesta = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        }

        // Guardar al salir (serialización)
        guardarDatos();
        System.out.println("✅ Datos guardados. ¡Hasta la próxima!");
    }

    // ------PARTE NUEVA----//
    // Cargar datos desde archivo
    private static void cargarDatos() {
        try (FileInputStream fis = new FileInputStream(ARCHIVO)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            asignaturas = (ArrayList<Asignatura>) ois.readObject();
        } catch (FileNotFoundException e) {
            // No existe aún, no hay datos
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
    }

    // Guardar datos al archivo (try clásico)
    private static void guardarDatos() {
        ObjectOutputStream oos = null;
        try (FileOutputStream fos = new FileOutputStream(ARCHIVO)) {
            oos = new ObjectOutputStream(fos);
            oos.writeObject(asignaturas);
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
}
