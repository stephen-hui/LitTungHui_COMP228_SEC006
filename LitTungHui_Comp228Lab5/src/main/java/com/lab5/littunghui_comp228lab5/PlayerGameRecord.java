package com.lab5.littunghui_comp228lab5;

import java.util.Date;

public class PlayerGameRecord {
    private String game;
    private int score;
    private String date;

    public PlayerGameRecord(String game, int score, String date) {
        this.game = game;
        this.score = score;
        this.date = date;
    }

    public String getGame() {
        return game;
    }

    public int getScore() {
        return score;
    }

    public String getDate() {
        return date;
    }
}
