package com.lab5.littunghui_comp228lab5;

import javafx.fxml.FXML;
import io.github.cdimascio.dotenv.Dotenv;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AddUserController {
    @FXML private TextField fNameField, lNameField, addressField, postalCodeField, phoneField, provinceField;

    private final OracleSQLManager dbManager;
    private Stage popupStage;

    private static final Dotenv dotenv = Dotenv.configure().directory("src/main/resources").load();
    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    public AddUserController() {
        dbManager = new OracleSQLManager( URL, USER, PASSWORD);
    }

    public void setPopupStage(Stage popupStage) {
        this.popupStage = popupStage;
    }

    @FXML
    public void handleSubmit() {
        //insertUserRecord
        try{
            String firstName = fNameField.getText();
            String lastName = lNameField.getText();
            String address = addressField.getText();
            String postalCode = postalCodeField.getText();
            String phone = phoneField.getText();
            String province = provinceField.getText();

            dbManager.insertUserRecord(firstName, lastName, address, postalCode, phone, province);

            showAlert("Success", "Record added successfully.", Alert.AlertType.CONFIRMATION);
            clearFields();
            popupStage.close();
        } catch (NumberFormatException e){
            showAlert("Invalid Input", "Fill All Fields Correctly.", Alert.AlertType.ERROR);
        }
    }

    private void clearFields() {
        fNameField.clear();
        lNameField.clear();
        addressField.clear();
        postalCodeField.clear();
        phoneField.clear();
        provinceField.clear();
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
