package com.ada2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.io.IOException;

public class PrimaryController {

    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label mensajeLabel;

    private int intentos = 0;
    private final String USUARIO_CORRECTO = "maestro";
    private final String PASSWORD_CORRECTA = "1234";

    @FXML
    private void handleLogin() throws IOException {
        String usuario = usuarioField.getText();
        String password = passwordField.getText();

        if (USUARIO_CORRECTO.equals(usuario) && PASSWORD_CORRECTA.equals(password)) {
            mensajeLabel.setText("Login exitoso!");
            // Cambiar a la ventana de calificaciones
            App.setRoot("calificaciones");
        } else {
            intentos++;
            if (intentos >= 3) {
                mensajeLabel.setText("Muchos intentos fallidos");
                usuarioField.setDisable(true);
                passwordField.setDisable(true);
            } else {
                mensajeLabel.setText("Datos incorrectos. Intento " + intentos + " de 3");
            }
        }
    }

}
