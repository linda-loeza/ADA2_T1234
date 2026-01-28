public class Main {

    public static void main(String[] args) {
        ListasCSV listaAlumnos = new ListasCSV(); // creamos el objeto
        listaAlumnos.leerYEscribirArchivo("alumnos.csv", "listaCalificaciones.csv"); // llamamos al metodo
    }

}
