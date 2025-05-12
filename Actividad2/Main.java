package CursoJava_ArchivosBinarios.Actividad2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {
    private static final String ARCHIVO = "CursoJava_ArchivosBinarios/Actividad2/libros.obj";
    private static ArrayList<Libro> libros = new ArrayList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        cargarDatos();
        verSiHayDatos();
        agregarLibro();
        guardarDatos();
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODO BUCLE PARA AGREGAR LIBROS
    private static void agregarLibro() {
        try {
            System.out.println("\n¿Deseas añadir nuevos libros? (s/n)");
            String respuesta = br.readLine();
            while (respuesta.equalsIgnoreCase("s")) {
                System.out.println("Cual es su titulo: ");
                String titulo = br.readLine();

                System.out.println("Nombre del autor: ");
                String autor = br.readLine();

                System.out.println("cual fue su año: ");
                int anio = Integer.parseInt(br.readLine());

                System.out.println("Cual es su genero (COMEDIA, TRAGEDIA, FICION): ");
                String genero = br.readLine().toUpperCase();
                Genero g = Genero.valueOf(genero);

                Libro nuevo = new Libro(titulo, autor, anio, g);
                libros.add(nuevo);

                System.out.println("Quieres añadir otro (s/n)");
                respuesta = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        }
    }

    // METODO QUE MIRA SI LA ARRAY DE LIBRO TIENE DATOS
    private static void verSiHayDatos() {
        if (!libros.isEmpty()) {
            System.out.println("\n📚 Libros registradas:");
            for (Libro a : libros) {
                System.out.println("-----------");
                a.verDatos();
            }
        } else {
            System.out.println("No hay libros registradas.");
        }
    }

    // METODO PARA CARGAR DESDE EL ARCHIVO LA ARRAY DEL LIBRO
    private static void cargarDatos() {
        try (FileInputStream fis = new FileInputStream(ARCHIVO)) {
            ObjectInputStream ois = new ObjectInputStream(fis);

            Libro.setContador(ois.readInt()); // CARGAMOS EL NUMERO ESTATICO GUARDADO
            libros = (ArrayList<Libro>) ois.readObject();

        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
    }

    // METODO PARA GUARDAR EL ARCHIVO LA ARRAY DEL LIBRO
    private static void guardarDatos() {
        ObjectOutputStream oos = null;
        try (FileOutputStream fos = new FileOutputStream(ARCHIVO)) {
            oos = new ObjectOutputStream(fos);

            oos.writeInt(Libro.getContador()); // PARA GUARDAR EL VALOR ESTATICO
            oos.writeObject(libros);
            
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
}
