package com.lab5.littunghui_comp228lab5;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.github.cdimascio.dotenv.Dotenv;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HelloController {
    // FXML fields
    @FXML private Button showProfileBtn, addRecordBtn;

    @FXML private ComboBox playerComboBox, gameComboBox;

    @FXML private TableView recordTable;

    @FXML private TextField scoreField;

    @FXML private DatePicker datePicker;

    @FXML private TableColumn<PlayerGameRecord, String> gameColumn, dateColumn;

    @FXML private TableColumn<PlayerGameRecord, Integer> scoreColumn;

    // current player and game records
    private PlayerRecord currentPlayerRecord;
    private GameRecord currentGameRecord;

    // database manager 
    private final OracleSQLManager dbManager;

    // player and game records
    private List<PlayerRecord> playerRecords;
    private List<GameRecord> gameRecords;
    private final ObservableList<PlayerGameRecord> records;

    // database credentials 
    private static final Dotenv dotenv = Dotenv.configure().directory("src/main/resources").load();
    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    public HelloController() {
        // constructor
        dbManager = new OracleSQLManager(URL, USER, PASSWORD);
        // initialize observable list
        records = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        updatePlayerList();
        initTable();
        setGameViewList();
    }

    @FXML
    public void setPlayer() {
        // set current player record
        String nameOfPlayer = (String) playerComboBox.getValue();

        for (PlayerRecord playerRecord : playerRecords) {
            if (playerRecord.getFullName().equals(nameOfPlayer)) {
                this.currentPlayerRecord  = playerRecord;
            }
        }

        // enable buttons
        showProfileBtn.setDisable(false);
        addRecordBtn.setDisable(false);

        // update table
        handleView();
    }

    public void toAddUserPage() {
        try{
            // load add-user-view.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-user-view.fxml"));
            Parent root = fxmlLoader.load();

            // get controller 
            AddUserController addUserController = fxmlLoader.getController();
            Stage popupStage = new Stage();

            // for close popup
            addUserController.setPopupStage(popupStage);

            // for update user combobox in hello-view.fxml
            addUserController.setHelloController(this);

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
            // load game-view.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage popupStage = new Stage();

            // get controller
            GameController gameController = fxmlLoader.getController();

            // for update game combobox in hello-view.fxml
            gameController.setHelloController(this);

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
            // load profile-view.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
            Parent root = fxmlLoader.load();

            // get controller
            ProfileController profileController = fxmlLoader.getController();
            Stage popupStage = new Stage();

            // set player
            profileController.setPlayer(currentPlayerRecord);
            profileController.setPopupStage(popupStage);

            // for update player combobox in hello-view.fxml
            profileController.setHelloController(this);

            popupStage.setHeight(400);
            popupStage.setWidth(600);
            popupStage.setTitle("Profile");
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait(); // Show the popup and wait for it to be closed before returning

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void updatePlayerList(){
        try{
            // get player records
            playerRecords = dbManager.getPlayerList();
            List<String> playerNames = new ArrayList<>();
            for (PlayerRecord playerRecord : playerRecords) {
                playerNames.add(playerRecord.getFirst_name() + " " + playerRecord.getLast_name());
            }

            // update player combobox
            playerComboBox.getItems().clear();
            playerComboBox.getItems().addAll(playerNames);

            // disable buttons since no player is selected
            showProfileBtn.setDisable(true);
            addRecordBtn.setDisable(true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void initTable(){
        try{
            // set up the table columns
            gameColumn.setCellValueFactory(new PropertyValueFactory<>("game"));
            scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

            // set items to the table
            recordTable.setItems(records);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void handleView(){
        // clear the table
        records.clear();
        try{
            // get player game records
            List<PlayerGameRecord> allRecords = dbManager.getPlayerGameRecord(currentPlayerRecord.getPlayer_id());
            // add records to the table
            records.addAll(allRecords);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setGameViewList(){
        try{
            // get game records
            gameRecords = dbManager.getGameRecords();
            List<String> gameNames = new ArrayList<>();
            for (GameRecord gameRecord : gameRecords) {
                gameNames.add(gameRecord.getGame_name());
            }

            // update game combobox
            gameComboBox.getItems().clear();
            gameComboBox.getItems().addAll(gameNames);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addRecord(){
        try{
            // get date and score
            String date = datePicker.getValue().toString();
            int score = Integer.parseInt(scoreField.getText());

            // add record to the database
            dbManager.addPlayerGameRecord(currentGameRecord.getGame_id(), currentPlayerRecord.getPlayer_id(), date, score);

            MyAlert.showAlert("Success", "Record added successfully.", Alert.AlertType.CONFIRMATION);
            clearFields();

            // update table
            handleView();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCurrentNewGame(){
        // get game name
        String nameOfGame = (String) gameComboBox.getValue();
        for (GameRecord gameRecord : gameRecords) {
            if (gameRecord.getGame_name().equals(nameOfGame)) {
                // set current game record with id
                currentGameRecord = gameRecord;
            }
        }
    }

    public void clearFields(){
        datePicker.setValue(null);
        scoreField.clear();
        gameComboBox.setValue(null);
    }
}