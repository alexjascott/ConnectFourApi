package com.alexscott.connectfourapi;

import javax.validation.constraints.NotNull;

/**
 * Created by alex on 17/12/2016.
 */
public class NewGameRequest {
    @NotNull
    private String player1;
    @NotNull
    private String player2;

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
}
