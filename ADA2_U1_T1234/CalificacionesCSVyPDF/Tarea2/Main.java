
public class Main {

    public static void main(String[] args) {
        ListasCSV listaAlumnos = new ListasCSV(); // creamos el objeto

        if (listaAlumnos.login() == true) { // metodo para validar los datos de usuario
            listaAlumnos.leerYEscribirArchivo("alumnos.csv", "listaCalificaciones.csv"); // llamamos al metodo
        } else {
            System.out.println("Muchos intentos fallidos. Intente mas tarde");
        }
        System.err.println();
    }

}
