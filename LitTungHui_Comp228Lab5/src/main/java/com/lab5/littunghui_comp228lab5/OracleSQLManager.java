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
                gameRecords.add(new GameRecord(rs.getInt("game_id"),rs.getString("game_title") ));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return gameRecords;
    }

    public void insertGameRecord(String name) throws SQLException {
        try {
            String selectQuery = "SELECT MAX(game_id) FROM LIT_TUNG_HUI_GAME";
            String insertQuery = "INSERT INTO LIT_TUNG_HUI_GAME (game_id, game_title) VALUES (?,?)";

            try (Connection conn = connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectQuery)) {

                int newGameId = 1;
                // Default to 1 if table is empty
                if (rs.next()) {
                    newGameId = rs.getInt(1) + 1;
                    // Increment the max player_id by 1
                }

                try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                    pstmt.setInt(1, newGameId);
                    pstmt.setString(2, name);

                    pstmt.executeUpdate();

                    System.out.println("Record added successfully.");
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PlayerRecord> getPlayerList() throws SQLException {
        String query = "SELECT * FROM LIT_TUNG_HUI_player";
        List<PlayerRecord> records = new ArrayList<>();

        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                records.add(new PlayerRecord(rs.getInt("player_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("address"), rs.getString("postal_code"), rs.getString("province"), rs.getString("phone_number")));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    public void insertUserRecord(String firstName, String lastName, String address, String postalCode, String province, String phone) {
        try {
            String selectQuery = "SELECT MAX(player_id) FROM LIT_TUNG_HUI_Player";
            String insertQuery = "INSERT INTO LIT_TUNG_HUI_Player (player_id, first_name, last_name, address, postal_code, province, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (Connection conn = connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectQuery)) {

                int newPlayerId = 1;
                // Default to 1 if table is empty
                if (rs.next()) {
                    newPlayerId = rs.getInt(1) + 1;
                    // Increment the max player_id by 1
                }

                try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                    pstmt.setInt(1, newPlayerId);
                    pstmt.setString(2, firstName);
                    pstmt.setString(3, lastName);
                    pstmt.setString(4, address);
                    pstmt.setString(5, postalCode);
                    pstmt.setString(6, province);
                    pstmt.setString(7, phone);

                    pstmt.executeUpdate();

                    System.out.println("Record added successfully.");
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProfile(int player_id, String firstName, String lastName, String address, String postalCode, String province, String phone) {
        String updateQuery = "UPDATE LIT_TUNG_HUI_Player SET first_name = ?, last_name = ?, address = ?, postal_code = ?, province = ?, phone_number = ? WHERE player_id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, address);
            pstmt.setString(4, postalCode);
            pstmt.setString(5, province);
            pstmt.setString(6, phone);
            pstmt.setInt(7, player_id);

            pstmt.executeUpdate();
            System.out.println("Record updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
