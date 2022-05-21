package com.example.projectf2f3.entitades;

import java.io.Serializable;

public class GameInfo implements Serializable {

    private Integer Id;
    private String GameName;
    private String Score;

    public GameInfo(Integer id, String gameName, String score) {
        Id = id;
        GameName = gameName;
        Score = score;
    }

    public GameInfo() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getGameName() {
        return GameName;
    }

    public void setGameName(String gameName) {
        GameName = gameName;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }
}

