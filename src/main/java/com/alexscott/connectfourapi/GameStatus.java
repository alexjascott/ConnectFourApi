package com.alexscott.connectfourapi;

import java.util.List;
import java.util.UUID;

/**
 * Created by alex on 17/12/2016.
 * Pojo to be turned into JSON as a status response.
 */
public class GameStatus {
    private UUID uuid;
    private GameState state;
    private String player1;
    private String player2;
    private List<String> board;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public List<String> getBoard() {
        return board;
    }

    public void setBoard(List<String> board) {
        this.board = board;
    }
}
