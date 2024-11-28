package com.lab5.littunghui_comp228lab5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleSQLManager {
    private final String url;
    private final String user;
    private final String password;

    public OracleSQLManager(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public List<GameRecord> getGameRecords() throws SQLException {
        String query = "SELECT * FROM LIT_TUNG_HUI_game";
        List<GameRecord> gameRecords = new ArrayList<>();

        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                gameRecords.add(new GameRecord(rs.getString("game_id"),rs.getString("game_title") ));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return gameRecords;
    }
}
