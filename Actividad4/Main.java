package CursoJava_ArchivosBinarios.Actividad4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String ARCHIVO = "CursoJava_ArchivosBinarios/Actividad2/cursos.dat";
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static List<Curso> cursos = new ArrayList<>();

    public static void main(String[] args) {
        cargarDatos();
        leerCursos();
        // cursos.add(new Curso("Primero"));
        // cursos.add(new Curso("Segundo"));
        meterPersonal();
        guardarDatos();

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODO PARA IMPRIMIR DATOS DE LOS CURSOS
    private static void leerCursos() {
        for (Curso curso : cursos) {
            curso.verDatos();
        }
    }

    // METODO METER PERSONAL ES PARA BSUCAR EL CURSO POR EL NOMBRE Y POSTERIORMETE
    // AÑADIRLE PROFESORES Y ALUMNOS
    private static void meterPersonal() {
        try {
            System.out.println("Dime nombre del curso, (Primero/Segundo)");
            String respuesta = br.readLine();
            System.out.println("Quieres meter Alumno o Profesor (a/p)");
            String tipo = br.readLine();
            System.out.println("Dime el nombre");
            String nombre = br.readLine();
            double nota = 0;
            String correo = null;
            if (tipo.equalsIgnoreCase("a")) {
                System.out.println("Cual es su nota: ");
                nota = Double.parseDouble(br.readLine());
            } else {
                System.out.println("Dime su correo");
                correo = br.readLine();
            }
            for (Curso c : cursos) {
                if (c.getNombre().equalsIgnoreCase(respuesta)) {
                    if (tipo.equalsIgnoreCase("a")) {
                        c.agregarAlumno(new Alumno(nombre, nota));
                    } else if (tipo.equalsIgnoreCase("p")) {
                        c.agregarProfesor(new Profesor(nombre, correo));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODO PARA GUARDAR LOS DATOS Y TAMBIEN EL STATICO 
    private static void guardarDatos() {
        ObjectOutputStream oos = null;
        try (FileOutputStream fos = new FileOutputStream(ARCHIVO)) {
            oos = new ObjectOutputStream(fos);

            oos.writeInt(Alumno.getContador());
            oos.writeObject(cursos);
            
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
    
    // METODO PARA CARGAR LOS DATOS Y TAMBIEN EL STATICO 
    private static void cargarDatos() {
        try (FileInputStream fis = new FileInputStream(ARCHIVO)) {
            ObjectInputStream ois = new ObjectInputStream(fis);

            Alumno.setContador(ois.readInt());
            cursos = (ArrayList<Curso>) ois.readObject();

        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error");
        }
    }

}
