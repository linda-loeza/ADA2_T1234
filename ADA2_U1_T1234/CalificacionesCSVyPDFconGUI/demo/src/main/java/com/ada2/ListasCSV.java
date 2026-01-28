package com.ada2;

import java.io.*;
import java.util.*;

public class ListasCSV { // Encontrar documentacion y aplicarlo en el codigo - 3hrs
    // atributos
    private BufferedReader lector; // lee el archivo
    private String linea; // lee cada linea del archivo
    private String alumno[] = null; // almacena cada linea leida
    Scanner entrada = new Scanner(System.in);
    private ArrayList<String> listaCalificaciones = new ArrayList<>();

    public void leerYEscribirArchivo(String nombreArchivo, String archivoSalida) {

        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            PrintWriter escritor = new PrintWriter(new FileWriter(archivoSalida));

            while ((linea = lector.readLine()) != null) { // si la linea esta vacia no inicia
                alumno = linea.split(",");// toma la linea y divide las partes con una ,

                for (int i = 0; i < alumno.length; i++) {
                    alumno[i] = alumno[i].trim(); // Quita espacios al inicio y final
                }

                System.out.println("Ingrese la calificacion para " + alumno[3] + ": ");
                String calificacion = entrada.next();

                try {
                    if (Integer.parseInt(calificacion) < 0 || Integer.parseInt(calificacion) > 100) {
                        escritor.println(
                                alumno[0] + "," + alumno[1] + "," + alumno[2] + "," + alumno[3] + "," + " S/C");
                        listaCalificaciones
                                .add(alumno[0] + "," + alumno[1] + "," + alumno[2] + "," + alumno[3] + "," + " S/C");
                        do {
                            System.out.println("Ingrese calificacion para " + alumno[3] + ": ");
                            calificacion = entrada.next();
                        } while (Integer.parseInt(calificacion) > 100 || Integer.parseInt(calificacion) < 1);
                        escritor.println(
                                alumno[0] + "," + alumno[1] + "," + alumno[2] + "," + alumno[3] + ", " + calificacion);
                        listaCalificaciones
                                .add(alumno[0] + "," + alumno[1] + "," + alumno[2] + "," + alumno[3] + ", "
                                        + calificacion);
                        System.out.println("Calificacion guardada para " + alumno[3]);
                    } else {
                        escritor.println(
                                alumno[0] + "," + alumno[1] + "," + alumno[2] + "," + alumno[3] + ", " + calificacion);
                        listaCalificaciones
                                .add(alumno[0] + "," + alumno[1] + "," + alumno[2] + "," + alumno[3] + ", "
                                        + calificacion);
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

    public ArrayList<String> obtenerLista() {
        return listaCalificaciones;
    }

    public boolean login() { // autenticacion de usuario con 3 intentos - 2hrs
        String admin = "maestro";
        String password = "1234";

        System.out.println("Ingrese usuario:");
        String usuario = entrada.next();
        System.out.println("Ingrese contrasena:");
        String pswrd = entrada.next();

        if (admin.equals(usuario) && password.equals(pswrd)) {
            return true;
        } else {
            int i = 0;
            do {
                System.out.println("Datos de usuario incorrectos. Intente de nuevo.");
                System.out.println("Ingrese usuario:");
                usuario = entrada.next();
                System.out.println("Ingrese contrasena:");
                pswrd = entrada.next();

                if (admin.equals(usuario) && password.equals(pswrd)) {
                    return true;
                }

                i++;
            } while (i != 3);
            return false;
        }
    }
}