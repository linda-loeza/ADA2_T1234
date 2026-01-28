import java.io.*;
import java.util.*;

public class ListasCSV {
    // atributos
    private BufferedReader lector; // lee el archivo
    private String linea; // lee cada linea del archivo
    private String alumno[] = null; // almacena cada linea leida

    public void leerYEscribirArchivo(String nombreArchivo, String archivoSalida) {
        Scanner entrada = new Scanner(System.in);
        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            PrintWriter escritor = new PrintWriter(new FileWriter(archivoSalida));

            while ((linea = lector.readLine()) != null) { // si la linea esta vacia no inicia
                alumno = linea.split(",");// toma la linea y divide las partes con una ,

                System.out.println("Ingrese la calificacion para " + alumno[3] + ": ");
                String calificacion = entrada.next();

                try {
                    if (Integer.parseInt(calificacion) < 0 || Integer.parseInt(calificacion) > 100) {
                        System.out.println("Intente de nuevo");
                        do {
                            System.out.println("Ingrese la calificacion para " + alumno[3] + ": ");
                            calificacion = entrada.next();
                        } while (calificacion == null);
                    } else {
                        escritor.println(
                                alumno[0] + "," + alumno[1] + "," + alumno[2] + "," + alumno[3] + "," + calificacion);
                        System.out.println("Calificacion guardada para " + alumno[3]);
                    }
                } catch (NumberFormatException e1) {
                    System.out.println("Error: Entrada no valida. Intente de nuevo.");
                }
            }
            escritor.close();
            lector.close();
            entrada.close();

            linea = null;
            alumno = null;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}