package CursoJava_ArchivosBinarios.Actividad5;

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
    public static void main(String[] args) {
        final String RUTA_UNO = "CursoJava_ArchivosBinarios/Actividad5/grupo1.dat";
        final String RUTA_DOS = "CursoJava_ArchivosBinarios/Actividad5/grupo2.dat";
        final String RUTA_TRES = "CursoJava_ArchivosBinarios/Actividad5/fusionado.dat";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // TODO LO DE ABAJO ES PARA CREAR ARCHIVOS Y SU CONTENIDO, UNA VEZ CREADO SE
        // CARGA CONTENIDO DIRECTAMENTE DESDE FICHEROS
        
        // List<Persona> listaUno = new ArrayList<>();
        // List<Persona> listaDos = new ArrayList<>();
        // meterDatos(listaUno, listaDos);
        // guardarDatos(listaUno, RUTA_UNO);
        // guardarDatos(listaDos, RUTA_DOS);

        // AQUI CREAMOS DOS ARRAY Y LES CARGAMOS SU CONTENIDO DESDE LOS FICHEROS
        List<Persona> listaUno = cargarDatos(RUTA_UNO);
        List<Persona> listaDos = cargarDatos(RUTA_DOS);

        // LO FUSIONAMOS DENTRO DE LA TERCERA, Y LA ORDENAMOS
        List<Persona> listaTres = fusionarListas(listaUno, listaDos);

        // LOS GUARDAMOS EN LISTA TRES.
        guardarDatos(listaTres, RUTA_TRES);
        verDatos(listaTres);
    }

    // METODO PARA IMPRIMIR DATOS PIDE UNA LISTA DE TIPO PERSONA Y LA RECORRE PARA
    // COMPROBAR QUE LO ORDENO BIEN
    private static void verDatos(List<Persona> lista) {
        for (Persona p : lista) {
            System.out.println(p.toString());
        }
    }

    // METODO CARGAR DATO, TE PIDE LA RUTA Y CARGA SU ARRAY DE TIPO PERSONA,
    // DEVUELVE CON RETURN SU CONTENIDO
    private static List<Persona> cargarDatos(String ruta) {
        List<Persona> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            lista = (List<Persona>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // METODO GUARDAR DATOS PIDE UNA ARRAY DE TIPO PERSONA Y UNA RUTA, Y LA GUARDA
    // AHI
    private static void guardarDatos(List<Persona> lista, String ruta) {
        try (ObjectOutputStream aux = new ObjectOutputStream(new FileOutputStream(ruta))) {
            aux.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODO DE FUSSIONAR DATOS TE PIDE DOS ARRAY DE TIPO PERSONA Y TE DEVUELVE UNA
    // MEZCLA DE AMBOS MEZCLADA Y ORDENADA TRAVES INTERFACE DESAROLLADA EN CLASE
    // PERSONA COMBARABLE, EL SORT LOS ORDENA
    private static List<Persona> fusionarListas(List<Persona> listaUno, List<Persona> listaDos) {
        List<Persona> listaNueva = new ArrayList<>();
        listaNueva.addAll(listaUno);
        listaNueva.addAll(listaDos);
        listaNueva.sort(null);
        return listaNueva;
    }

    // METODO PARA INGRESAR PRIMEROS ARCHIVOS, UNA VEZ USADO NO SE VUELVE A UTILIZAR
    // YA QUE SE TRABAJA CON FICHEROS QUE SE LOS GUARDA
    private static void meterDatos(List<Persona> listaUno, List<Persona> listaDos) {
        listaUno.add(new Persona("Ana", 25));
        listaUno.add(new Persona("Bruno", 30));
        listaUno.add(new Persona("Carla", 22));
        listaUno.add(new Persona("David", 28));
        listaUno.add(new Persona("Elena", 35));
        listaUno.add(new Persona("Fernando", 27));
        listaUno.add(new Persona("Gabriela", 31));
        listaUno.add(new Persona("Hugo", 24));
        listaUno.add(new Persona("Isabel", 29));
        listaUno.add(new Persona("Jorge", 26));

        listaDos.add(new Persona("Karen", 32));
        listaDos.add(new Persona("Luis", 23));
        listaDos.add(new Persona("María", 34));
        listaDos.add(new Persona("Nicolás", 21));
        listaDos.add(new Persona("Olga", 33));
        listaDos.add(new Persona("Pablo", 26));
        listaDos.add(new Persona("Quintín", 30));
        listaDos.add(new Persona("Rosa", 28));
        listaDos.add(new Persona("Samuel", 25));
        listaDos.add(new Persona("Tamara", 29));
    }
}
