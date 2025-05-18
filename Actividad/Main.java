package CursoJava_ArchivosBinarios.Actividad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String RUTA = "";

    public static void main(String[] args) {

    }

    private static void cargarDatos() {
        File archivo = new File(RUTA);
        if (!archivo.exists()) {
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA))) {
            lista = (List<Tipo>) ois.readObject();
            Tipo.setContador(ois.readInt());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void guardarDatos() {
        ObjectOutputStream aux = null;
        try (FileOutputStream fos = new FileOutputStream(RUTA)) {
            aux = new ObjectOutputStream(fos);
            aux.writeObject(lista);
            aux.writeInt(Tipo.getContador());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
