package com.lab5.littunghui_comp228lab5;

import io.github.cdimascio.dotenv.Dotenv;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    @FXML
    TextField newGameField;

    @FXML
    Button addGameBtn;

    @FXML
    ListView<String> gameListView;

    private final OracleSQLManager dbManager;
    private static final Dotenv dotenv = Dotenv.configure().directory("src/main/resources").load();
    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    public GameController() {
        dbManager = new OracleSQLManager( URL, USER, PASSWORD);
    }

    @FXML
    public void initialize() {
        this.updateListView();
    }

    @FXML
    public void addNewGame() {
        try{
            String name = newGameField.getText();

            dbManager.insertGameRecord(name);

            showAlert("Success", "Record added successfully.", Alert.AlertType.CONFIRMATION);

            this.updateListView();
            this.clearFields();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateListView() {
        try {
            List<GameRecord> gameRecords = dbManager.getGameRecords();
            List<String> gameNames = new ArrayList<>();

            for (GameRecord gameRecord : gameRecords) {
                gameNames.add(gameRecord.getGame_name());
            }

            if (gameNames.size() == 0) {
                gameNames.add("Empty");
            }

            gameListView.getItems().clear();
            gameListView.getItems().addAll(gameNames);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        newGameField.clear();
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
