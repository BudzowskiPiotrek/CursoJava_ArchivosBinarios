# 📚 Curso Java Archivos Binarios

## 📝 Actividad 1


Vamos a crear un programa que almacene en un fichero externo un listado de asignaturas, las asignaturas tendrán información sobre el nombre y los créditos y además el profesor que la imparte pero este último elemento no será serializable, es decir no se almacenará en el fichero por lo que cuando recojamos los campos no quedará guardado el profesor de cada asignatura.

- ⚠️ El parametro serialVersionUID, no es un parámetro obligatorio pero si altamente recomendable. Es un identificador único que sirve para verificar la compatibilidad de versiones de una clase durante el proceso de deserialización.
    - 🔄 Si serializas un objeto, y luego cambias la clase (por ejemplo, agregas un atributo), Java usará ese `serialVersionUID` para verificar que la clase actual sea compatible con la versión antigua.
    - ❌ Si no coinciden, se lanza una excepción: `InvalidClassException`.
- 🧑‍🏫 Declaramos el campo Profesor como transient puesto que no se va a almacenar ya que no implementa la interfaz serializable y en el caso de intentarlo daría error.

## 📖 Actividad 2

- 📘 Registro Básico de Libros:
    - Crea una clase `Libro` con atributos como título, autor, año y género.
    - El programa debe:
        - 📝 Pedir al usuario datos de varios libros.
        - 💾 Guardarlos en un archivo binario `libros.dat`
        - 📂 Lee el contenido del archivo al reiniciar y mostrar los libros registrados.
     
## 📇 Actividad 3

- 📱 Agenda de Contactos con Modificación:
    - Crea una clase `Contacto` con: nombre, teléfono, email.
    - El programa debe:
        - ➕ Permitir añadir, 📋 ver todos, 🔍 buscar por nombre y ✏️ **modificar** un contacto.
        - Al modificar, cargar todos los contactos, cambiar los datos del contacto deseado por nombre, y volver a guardar el archivo.
          
## 🏫 Actividad 4

- 👩‍🎓 Curso y Alumnos con `transient`:
    - Crea las clases `Alumno` (Serializable) con nombre y nota. `Curso` (Serializable) con nombre del curso, lista de alumnos y profesor (transient). `Profesor` nombre y email (NO Serializable)
    - El programa debe:
        - 🧑‍🎓Crear varios cursos con alumnos y profesor asignado.
        - 💾 Serializar los cursos en `cursos.dat`
        - 📄 Leer los cursos y mostrar toda la información, el campo de profesor debe mostrar “no disponible”.
          
## 🧑‍🤝‍🧑 Actividad 5

- 🔀 Fusionar Archivos Binarios de Personas:
    - Crea una clase `Persona` (Serializable) con nombre y edad.
    - Crea dos archivos binarios:
        - `grupo1.dat` que contiene una lista de personas.
        - `grupo2.dat` que contiene otra lista de personas.
    - El programa debe:
        - 📥 leer ambos archivos.
        - 🧩 fusionar las listas en una sola ordenadas por edades.
        - 💽 guardar el resultado en fusionado.dat.
          
## 🛒 Actividad 6

- 🧾 Sistema de Inventario con múltiples funcionalidades:
    - Crea la clase `Producto` (Serializable) con código, nombre, stock, precio y proveedor.
    - El programa debe ofrecer un menú con las opciones:
        - ➕ Añadir producto
        - 📋 Listar productos
        - 🔍 Buscar producto por código
        - 🔁 Actualizar stock
        - ❌ Eliminar producto
        - 💾 Guardar y Salir
        
        - ⚠️ El proveedor no se guarda en el archivo
