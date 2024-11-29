package com.lab5.littunghui_comp228lab5;

import javafx.scene.control.Alert;

public class MyAlert {
    // show alert
    public static void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
