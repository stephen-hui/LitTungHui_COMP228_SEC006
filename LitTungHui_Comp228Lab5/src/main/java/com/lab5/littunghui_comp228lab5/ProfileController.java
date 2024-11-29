package com.lab5.littunghui_comp228lab5;

import io.github.cdimascio.dotenv.Dotenv;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProfileController {
    // text fields
    @FXML private TextField fNameField, lNameField, addressField, postalCodeField, phoneField, provinceField;

    // current player id
    private int playerId;

    // database manager
    private final OracleSQLManager dbManager;
    private Stage popupStage;
    private HelloController helloController;

    // database credentials
    private static final Dotenv dotenv = Dotenv.configure().directory("src/main/resources").load();
    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    public ProfileController() {
        // constructor
        dbManager = new OracleSQLManager( URL, USER, PASSWORD);
    }

    // setters
    public void setPopupStage(Stage popupStage) {
        this.popupStage = popupStage;
    }

    public void setHelloController(HelloController helloController) {
        this.helloController = helloController;
    }

    // set player info into the fields
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
            // get text from the fields
            String firstName = fNameField.getText();
            String lastName = lNameField.getText();
            String address = addressField.getText();
            String postalCode = postalCodeField.getText();
            String phone = phoneField.getText();
            String province = provinceField.getText();

            // update profile in the database
            dbManager.updateProfile(playerId, firstName, lastName, address, postalCode, phone, province);

            MyAlert.showAlert("Success", "Record updated successfully.", Alert.AlertType.CONFIRMATION);
            clearFields();

            // update player list
            helloController.updatePlayerList();
            popupStage.close();
        }catch (NumberFormatException e){
            MyAlert.showAlert("Error", "Please enter a valid first name.", Alert.AlertType.ERROR);
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
}
