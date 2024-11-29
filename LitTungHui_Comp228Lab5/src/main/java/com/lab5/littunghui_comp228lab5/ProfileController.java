package com.lab5.littunghui_comp228lab5;

import io.github.cdimascio.dotenv.Dotenv;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProfileController {
    @FXML private TextField fNameField, lNameField, addressField, postalCodeField, phoneField, provinceField;

    private int playerId;

    private final OracleSQLManager dbManager;
    private Stage popupStage;
    private HelloController helloController;

    private static final Dotenv dotenv = Dotenv.configure().directory("src/main/resources").load();
    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    public ProfileController() {
        dbManager = new OracleSQLManager( URL, USER, PASSWORD);
    }

    public void setPopupStage(Stage popupStage) {
        this.popupStage = popupStage;
    }

    public void setHelloController(HelloController helloController) {
        this.helloController = helloController;
    }

    public void setPlayer(PlayerRecord playerRecord){
        this.playerId = playerRecord.getPlayer_id();
        fNameField.setText(playerRecord.getFirst_name());
        lNameField.setText(playerRecord.getLast_name());
        addressField.setText(playerRecord.getAddress());
        postalCodeField.setText(playerRecord.getPostal_code());
        phoneField.setText(playerRecord.getPhone_number());
        provinceField.setText(playerRecord.getProvince());
    }

    public void handleSubmit(){
        try{
            String firstName = fNameField.getText();
            String lastName = lNameField.getText();
            String address = addressField.getText();
            String postalCode = postalCodeField.getText();
            String phone = phoneField.getText();
            String province = provinceField.getText();

            dbManager.updateProfile(playerId, firstName, lastName, address, postalCode, phone, province);

            showAlert("Success", "Record updated successfully.", Alert.AlertType.CONFIRMATION);
            clearFields();
            helloController.updatePlayerList();
            popupStage.close();
        }catch (NumberFormatException e){
            showAlert("Error", "Please enter a valid first name.", Alert.AlertType.ERROR);
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
