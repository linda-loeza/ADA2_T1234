import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ListasCSV listaAlumnos = new ListasCSV(); // creamos el objeto
        GenerarPDF generarPDF = new GenerarPDF();
        ArrayList<String> listaBuena = new ArrayList<>();

        if (listaAlumnos.login() == true) { // metodo para validar los datos de usuario
            listaAlumnos.leerYEscribirArchivo("alumnos.csv", "alumnosCalificados.csv");
            listaBuena = listaAlumnos.obtenerLista();
            generarPDF.crearDocumento("lista.pdf", listaBuena);
        } else {
            System.out.println("Muchos intentos fallidos. Intente mas tarde");
        }
        System.err.println();
    }

}
