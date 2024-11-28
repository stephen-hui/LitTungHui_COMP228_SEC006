package com.lab5.littunghui_comp228lab5;

public class GameRecord {
    private String game_id;
    private String game_name;

    public GameRecord(String game_id, String game_name) {
        this.game_id = game_id;
        this.game_name = game_name;
    }

    public String getGame_id() {
        return game_id;
    }

    public String getGame_name() {
        return game_name;
    }
}
