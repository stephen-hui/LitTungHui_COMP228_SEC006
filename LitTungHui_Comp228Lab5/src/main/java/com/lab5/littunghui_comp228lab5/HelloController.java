package com.lab5.littunghui_comp228lab5;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.github.cdimascio.dotenv.Dotenv;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class HelloController {
    @FXML private Button addPlayerBtn, showProfileBtn;

    @FXML private ComboBox playerComboBox;

//    @FXML private TableView recordTable;

//    @FXML private TableColumn<PlayerGameRecord, String> gameColumn, dateColumn;
//
//    @FXML private TableColumn<PlayerGameRecord, Integer> scoreColumn;

    private final OracleSQLManager dbManager;
    private List<PlayerRecord> playerRecords;

    private static final Dotenv dotenv = Dotenv.configure().directory("src/main/resources").load();
    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");
    private PlayerRecord currentPlayerRecord;

    public HelloController() {
        dbManager = new OracleSQLManager(URL, USER, PASSWORD);
    }

    @FXML
    public void initialize() {
        updatePlayerList();
    }

    @FXML
    public void setPlayer() {
        String nameOfPlayer = (String) playerComboBox.getValue();

        for (PlayerRecord playerRecord : playerRecords) {
            if (playerRecord.getFullName().equals(nameOfPlayer)) {
                System.out.println(playerRecord.getFirst_name() + " " + playerRecord.getLast_name());
                System.out.println("address "+playerRecord.getAddress());
                this.currentPlayerRecord  = playerRecord;
            }
        }

        showProfileBtn.setDisable(false);
    }

    public void toAddUserPage() {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-user-view.fxml"));
            Parent root = fxmlLoader.load();

            AddUserController addUserController = fxmlLoader.getController();
            Stage popupStage = new Stage();
            addUserController.setPopupStage(popupStage);

            popupStage.setHeight(400);
            popupStage.setWidth(600);
            popupStage.setTitle("Add Player");
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait(); // Show the popup and wait for it to be closed before returning

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void toGamePage(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage popupStage = new Stage();

            popupStage.setHeight(400);
            popupStage.setWidth(600);
            popupStage.setTitle("Game List");
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait(); // Show the popup and wait for it to be closed before returning

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void toProfilePage(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
            Parent root = fxmlLoader.load();

            ProfileController profileController = fxmlLoader.getController();
            Stage popupStage = new Stage();
            profileController.setPlayer(currentPlayerRecord);
            profileController.setPopupStage(popupStage);
            profileController.setHelloController(this);

            popupStage.setHeight(400);
            popupStage.setWidth(600);
            popupStage.setTitle("Profile");
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait(); // Show the popup and wait for it to be closed before returning

        }catch (IOException e){
            System.out.println("Herer");
            e.printStackTrace();
        }
    }

    public void updatePlayerList(){
        try{
            playerRecords = dbManager.getPlayerList();
            List<String> playerNames = new ArrayList<>();
            for (PlayerRecord playerRecord : playerRecords) {
                playerNames.add(playerRecord.getFirst_name() + " " + playerRecord.getLast_name());
            }

            playerComboBox.getItems().clear();
            playerComboBox.getItems().addAll(playerNames);
            showProfileBtn.setDisable(true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateRecordTable(){
        try{
            // Set up the table columns


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}