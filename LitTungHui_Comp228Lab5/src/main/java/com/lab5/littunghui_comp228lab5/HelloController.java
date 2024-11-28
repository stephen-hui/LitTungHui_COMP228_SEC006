package com.lab5.littunghui_comp228lab5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.DriverManager;
import java.util.List;

import javafx.collections.FXCollections;

public class HelloController {
    @FXML
    private Label welcomeText;

    private final OracleSQLManager dbManager;

    private static final Dotenv dotenv = Dotenv.configure().directory("src/main/resources").load();
    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    public HelloController() {
        dbManager = new OracleSQLManager(URL, USER, PASSWORD);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void initialize() {
        try{
            System.out.println(URL);
            System.out.println(USER);
            System.out.println(PASSWORD);
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Connected to the database!");

            List<GameRecord> gameRecords = dbManager.getGameRecords();
            System.out.println("Length "+ gameRecords.size());
        }
        catch (Exception e){
            System.out.println("ERROR ");
            e.printStackTrace();
        }

    }
}