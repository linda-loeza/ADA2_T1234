package com.ada2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.ArrayList;
import java.io.*;

public class CalificacionesController {

    @FXML
    private Label nombreAlumnoLabel;

    @FXML
    private TextField calificacionField;

    @FXML
    private Label mensajeLabel;

    private ArrayList<String[]> alumnos = new ArrayList<>();
    private ArrayList<String> calificaciones = new ArrayList<>();
    private int indiceActual = 0;

    @FXML
    public void initialize() {
        cargarAlumnos();
        if (alumnos.size() > 0) {
            mostrarAlumnoActual();
        }
    }

    private void cargarAlumnos() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("alumnos.csv"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                // Limpiar espacios
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = datos[i].trim();
                }
                alumnos.add(datos);
            }
            reader.close();
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo leer el archivo alumnos.csv", AlertType.ERROR);
        }
    }

    private void mostrarAlumnoActual() {
        if (indiceActual < alumnos.size()) {
            String[] alumno = alumnos.get(indiceActual);
            nombreAlumnoLabel.setText("Alumno: " + alumno[1] + " " + alumno[2] + " " + alumno[3]);
        }
    }

    @FXML
    private void handleGuardarCalificacion() {
        String calificacionTexto = calificacionField.getText();

        try {
            int calificacion = Integer.parseInt(calificacionTexto);

            if (calificacion < 0 || calificacion > 100) {
                mensajeLabel.setText("La calificación debe estar entre 0 y 100");
                mensajeLabel.setStyle("-fx-text-fill: red;");
                return;
            }

            String[] alumno = alumnos.get(indiceActual);
            String registro = alumno[0] + " - " + alumno[1] + " " + alumno[2] + " " + alumno[3] + " " + calificacion;
            calificaciones.add(registro);

            mensajeLabel.setText("Calificación guardada para " + alumno[3]);
            mensajeLabel.setStyle("-fx-text-fill: green;");

            calificacionField.clear();
            indiceActual++;

            if (indiceActual < alumnos.size()) {
                mostrarAlumnoActual();
            } else {
                nombreAlumnoLabel.setText("¡Todas las calificaciones ingresadas!");
                calificacionField.setDisable(true);
            }

        } catch (NumberFormatException e) {
            mensajeLabel.setText("Ingrese un número válido");
            mensajeLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void handleGenerarPDF() {
        if (calificaciones.isEmpty()) {
            mostrarAlerta("Error", "No hay calificaciones para generar el PDF", AlertType.ERROR);
            return;
        }

        GenerarPDF generador = new GenerarPDF();
        generador.crearDocumento("lista.pdf", calificaciones);

        mostrarAlerta("Éxito", "PDF generado exitosamente en lista.pdf", AlertType.INFORMATION);
    }

    private void mostrarAlerta(String titulo, String mensaje, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}