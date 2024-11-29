package com.lab5.littunghui_comp228lab5;

import javafx.fxml.FXML;
import io.github.cdimascio.dotenv.Dotenv;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AddUserController {
    // components
    @FXML private TextField fNameField, lNameField, addressField, postalCodeField, phoneField, provinceField;

    private final OracleSQLManager dbManager;
    private Stage popupStage;
    private HelloController helloController;

    // database credentials
    private static final Dotenv dotenv = Dotenv.configure().directory("src/main/resources").load();
    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    // constructor
    public AddUserController() {
        dbManager = new OracleSQLManager( URL, USER, PASSWORD);
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

            MyAlert.showAlert("Success", "Record added successfully.", Alert.AlertType.CONFIRMATION);
            clearFields();
            popupStage.close();
            
            // update player list in hello-view.fxml
            helloController.updatePlayerList();

        } catch (NumberFormatException e){
            MyAlert.showAlert("Invalid Input", "Fill All Fields Correctly.", Alert.AlertType.ERROR);
        }   
    }

    // setters
    public void setHelloController(HelloController helloController) {
        this.helloController = helloController;
    }

    public void setPopupStage(Stage popupStage) {
        this.popupStage = popupStage;
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
