package com.alexscott.connectfourapi;

import java.util.List;
import java.util.UUID;

/**
 * Created by alex on 17/12/2016.
 */
public class Game {
    private UUID id;
    private Board board;
    private String player1;
    private String player2;
    private GameState state;

    public Game(String player1, String player2) {
        this.id = UUID.randomUUID();
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.state = GameState.PLAYER1_TURN;
    }

    /***
     * Returns the game board as a List<String>, because that looks best JSONified (array looks bad).
     * @return List<String>
     */
    public List<String> printBoard() {
        return board.printAsList();
    }

    /***
     * Lets a player make a move, assuming its their turn, else throws IllegalAccessException.
     * @param playerNumber int
     * @param column int
     * @throws IllegalAccessException
     * @throws ColumnOutOfBoundsException
     */
    public void move(int playerNumber, int column) throws IllegalAccessException, ColumnOutOfBoundsException {
        if (state == GameState.PLAYER1_WINS || state == GameState.PLAYER1_WINS) {
            throw new IllegalAccessException("The game has been won!");
        }
        if (playerNumber == 1 && state != GameState.PLAYER1_TURN) {
            throw new IllegalAccessException("It is not your turn!");
        } else if (playerNumber == 2 && state != GameState.PLAYER2_TURN) {
            throw new IllegalAccessException("It is not your turn!");
        }
        boolean winner = board.move(column, playerNumber);
        if (winner) {
            if (playerNumber == 1) {
                state = GameState.PLAYER1_WINS;
            } else {
                state = GameState.PLAYER2_WINS;
            }
        } else if (playerNumber == 1) {
            state = GameState.PLAYER2_TURN;
        } else {
            state = GameState.PLAYER1_TURN;
        }
    }

    /***
     * Gets the player number (1 or 2) from the player name, else throws an IllegalArgumentException.
     * @param playerName String
     * @return int
     * @throws IllegalAccessException
     */
    public int getPlayerNumber(String playerName) throws IllegalAccessException {
        if (getPlayer1().equalsIgnoreCase(playerName)) {
            return 1;
        } else if (getPlayer2().equalsIgnoreCase(playerName)) {
            return 2;
        } else {
            throw new IllegalAccessException("Unable to find matching player");
        }
    }

    public UUID getId() {
        return id;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public GameState getState() {
        return state;
    }
}
