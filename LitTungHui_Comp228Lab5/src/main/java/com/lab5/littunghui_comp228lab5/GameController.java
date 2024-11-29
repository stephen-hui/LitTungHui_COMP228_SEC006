package com.lab5.littunghui_comp228lab5;

import io.github.cdimascio.dotenv.Dotenv;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    // FXML fields
    @FXML
    TextField newGameField;

    @FXML
    Button addGameBtn;

    @FXML
    ListView<String> gameListView;

    private final OracleSQLManager dbManager;
    private HelloController helloController;

    // database credentials
    private static final Dotenv dotenv = Dotenv.configure().directory("src/main/resources").load();
    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    public GameController() {
        // constructor
        dbManager = new OracleSQLManager( URL, USER, PASSWORD);
    }

    @FXML
    public void initialize() {
        // update game list view
        this.updateListView();
    }

    @FXML
    public void addNewGame() {
        try{
            String name = newGameField.getText();

            // insert game record
            dbManager.insertGameRecord(name);

            MyAlert.showAlert("Success", "Record added successfully.", Alert.AlertType.CONFIRMATION);
            
            // update game list view
            this.updateListView();
            this.clearFields();

            // update game list in hello-view.fxml
            helloController.setGameViewList();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // setters
    public void setHelloController(HelloController helloController) {
        this.helloController = helloController;
    }

    public void updateListView() {
        // update game list view
        try {
            List<GameRecord> gameRecords = dbManager.getGameRecords();
            List<String> gameNames = new ArrayList<>();

            // add game names to the list
            for (GameRecord gameRecord : gameRecords) {
                gameNames.add(gameRecord.getGame_name());
            }

            // if no game records, add "Empty" to the list
            if (gameNames.size() == 0) {
                gameNames.add("Empty");
            }

            // clear and add game names to the list
            gameListView.getItems().clear();
            gameListView.getItems().addAll(gameNames);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        newGameField.clear();
    }

}
