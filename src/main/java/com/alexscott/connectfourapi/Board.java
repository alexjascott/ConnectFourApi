package com.alexscott.connectfourapi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 17/12/2016.
 */
public class Board {
    public static int WIDTH = 7;
    public static int HEIGHT = 6;
    int[][] grid;

    public Board() {
        this.grid = new int[WIDTH][HEIGHT];
    }

    /***
     * Makes a player move. Checks for win condition after move.
     * @param column int
     * @param player int
     * @return Boolean
     * @throws ColumnOutOfBoundsException
     */
    public boolean move(int column, int player) throws ColumnOutOfBoundsException {
        if (column < 0 || column > WIDTH) {
            throw new ColumnOutOfBoundsException("Column " + column + " not in range.");
        }
        for (int h = 0; h < HEIGHT; h++) {
            if (grid[column][h] == 0) {
                grid[column][h] = player;
                break;
            }
        }
        return winCondition();
    }

    /***
     * Print as List so that it will look good in the json status response.
     * @return List<String>
     */
    public List<String> printAsList() {
        List<String> output = new ArrayList();
        for (int h = HEIGHT - 1; h >= 0; h--) {
            String row = "";
            for (int w = 0; w < WIDTH; w++) {
                row = row + "[" + grid[w][h] + "]";
            }
            output.add(row);
        }
        return output;
    }

    /***
     * Prints the board in readable way, good if outputting in pure text (console). Not much good
     * when returning JSON.
     * @return String
     */
    public String print() {
        StringBuffer strBuf = new StringBuffer();
        for (int h = HEIGHT - 1; h >= 0; h--) {
            for (int w = 0; w < WIDTH; w++) {
                strBuf.append("[" + grid[w][h] + "]");
            }
            strBuf.append("\n");
        }
        return strBuf.toString();
    }

    /**
     * Brute-force algorithm. A more elegant solution would be to check the last dropped token,
     * and check winning condition based off that location. But I don't have the time to code a
     * better solution!
     * @return boolean true = win, false = carry on
     */
    boolean winCondition() {
        if (grid[0][0] == 2 && grid[1][0] == 2 && grid[2][0] == 2 && grid[3][0] == 2) {
            return true;
        }
        if (grid[0][0] == 1 && grid[1][0] == 1 && grid[2][0] == 1 && grid[3][0] == 1) {
            return true;
        }
        if (grid[1][0] == 2 && grid[2][0] == 2 && grid[3][0] == 2 && grid[4][0] == 2) {
            return true;
        }
        if (grid[1][0] == 1 && grid[2][0] == 1 && grid[3][0] == 1 && grid[4][0] == 1) {
            return true;
        }
        if (grid[2][0] == 2 && grid[3][0] == 2 && grid[4][0] == 2 && grid[5][0] == 2) {
            return true;
        }
        if (grid[2][0] == 1 && grid[3][0] == 1 && grid[4][0] == 1 && grid[5][0] == 1) {
            return true;
        }
        if (grid[3][0] == 2 && grid[4][0] == 2 && grid[5][0] == 2 && grid[6][0] == 2) {
            return true;
        }
        if (grid[3][0] == 1 && grid[4][0] == 1 && grid[5][0] == 1 && grid[6][0] == 1) {
            return true;
        }
        if (grid[0][1] == 2 && grid[1][1] == 2 && grid[2][1] == 2 && grid[3][1] == 2) {
            return true;
        }
        if (grid[0][1] == 1 && grid[1][1] == 1 && grid[2][1] == 1 && grid[3][1] == 1) {
            return true;
        }
        if (grid[1][1] == 2 && grid[2][1] == 2 && grid[3][1] == 2 && grid[4][1] == 2) {
            return true;
        }
        if (grid[1][1] == 1 && grid[2][1] == 1 && grid[3][1] == 1 && grid[4][1] == 1) {
            return true;
        }
        if (grid[2][1] == 2 && grid[3][1] == 2 && grid[4][1] == 2 && grid[5][1] == 2) {
            return true;
        }
        if (grid[2][1] == 1 && grid[3][1] == 1 && grid[4][1] == 1 && grid[5][1] == 1) {
            return true;
        }
        if (grid[3][1] == 2 && grid[4][1] == 2 && grid[5][1] == 2 && grid[6][1] == 2) {
            return true;
        }
        if (grid[3][1] == 1 && grid[4][1] == 1 && grid[5][1] == 1 && grid[6][1] == 1) {
            return true;
        }
        if (grid[0][2] == 2 && grid[1][2] == 2 && grid[2][2] == 2 && grid[3][2] == 2) {
            return true;
        }
        if (grid[0][2] == 1 && grid[1][2] == 1 && grid[2][2] == 1 && grid[3][2] == 1) {
            return true;
        }
        if (grid[1][2] == 2 && grid[2][2] == 2 && grid[3][2] == 2 && grid[4][2] == 2) {
            return true;
        }
        if (grid[1][2] == 1 && grid[2][2] == 1 && grid[3][2] == 1 && grid[4][2] == 1) {
            return true;
        }
        if (grid[2][2] == 2 && grid[3][2] == 2 && grid[4][2] == 2 && grid[5][2] == 2) {
            return true;
        }
        if (grid[2][2] == 1 && grid[3][2] == 1 && grid[4][2] == 1 && grid[5][2] == 1) {
            return true;
        }
        if (grid[3][2] == 2 && grid[4][2] == 2 && grid[5][2] == 2 && grid[6][2] == 2) {
            return true;
        }
        if (grid[3][2] == 1 && grid[4][2] == 1 && grid[5][2] == 1 && grid[6][2] == 1) {
            return true;
        }
        if (grid[0][3] == 2 && grid[1][3] == 2 && grid[2][3] == 2 && grid[3][3] == 2) {
            return true;
        }
        if (grid[0][3] == 1 && grid[1][3] == 1 && grid[2][3] == 1 && grid[3][3] == 1) {
            return true;
        }
        if (grid[1][3] == 2 && grid[2][3] == 2 && grid[3][3] == 2 && grid[4][3] == 2) {
            return true;
        }
        if (grid[1][3] == 1 && grid[2][3] == 1 && grid[3][3] == 1 && grid[4][3] == 1) {
            return true;
        }
        if (grid[2][3] == 2 && grid[3][3] == 2 && grid[4][3] == 2 && grid[5][3] == 2) {
            return true;
        }
        if (grid[2][3] == 1 && grid[3][3] == 1 && grid[4][3] == 1 && grid[5][3] == 1) {
            return true;
        }
        if (grid[3][3] == 2 && grid[4][3] == 2 && grid[5][3] == 2 && grid[6][3] == 2) {
            return true;
        }
        if (grid[3][3] == 1 && grid[4][3] == 1 && grid[5][3] == 1 && grid[6][3] == 1) {
            return true;
        }
        if (grid[0][4] == 2 && grid[1][4] == 2 && grid[2][4] == 2 && grid[3][4] == 2) {
            return true;
        }
        if (grid[0][4] == 1 && grid[1][4] == 1 && grid[2][4] == 1 && grid[3][4] == 1) {
            return true;
        }
        if (grid[1][4] == 2 && grid[2][4] == 2 && grid[3][4] == 2 && grid[4][4] == 2) {
            return true;
        }
        if (grid[1][4] == 1 && grid[2][4] == 1 && grid[3][4] == 1 && grid[4][4] == 1) {
            return true;
        }
        if (grid[2][4] == 2 && grid[3][4] == 2 && grid[4][4] == 2 && grid[5][4] == 2) {
            return true;
        }
        if (grid[2][4] == 1 && grid[3][4] == 1 && grid[4][4] == 1 && grid[5][4] == 1) {
            return true;
        }
        if (grid[3][4] == 2 && grid[4][4] == 2 && grid[5][4] == 2 && grid[6][4] == 2) {
            return true;
        }
        if (grid[3][4] == 1 && grid[4][4] == 1 && grid[5][4] == 1 && grid[6][4] == 1) {
            return true;
        }
        if (grid[0][5] == 2 && grid[1][5] == 2 && grid[2][5] == 2 && grid[3][5] == 2) {
            return true;
        }
        if (grid[0][5] == 1 && grid[1][5] == 1 && grid[2][5] == 1 && grid[3][5] == 1) {
            return true;
        }
        if (grid[1][5] == 2 && grid[2][5] == 2 && grid[3][5] == 2 && grid[4][5] == 2) {
            return true;
        }
        if (grid[1][5] == 1 && grid[2][5] == 1 && grid[3][5] == 1 && grid[4][5] == 1) {
            return true;
        }
        if (grid[2][5] == 2 && grid[3][5] == 2 && grid[4][5] == 2 && grid[5][5] == 2) {
            return true;
        }
        if (grid[2][5] == 1 && grid[3][5] == 1 && grid[4][5] == 1 && grid[5][5] == 1) {
            return true;
        }
        if (grid[3][5] == 2 && grid[4][5] == 2 && grid[5][5] == 2 && grid[6][5] == 2) {
            return true;
        }
        if (grid[3][5] == 1 && grid[4][5] == 1 && grid[5][5] == 1 && grid[6][5] == 1) {
            return true;
        }
        if (grid[0][0] == 2 && grid[0][1] == 2 && grid[0][2] == 2 && grid[0][3] == 2) {
            return true;
        }
        if (grid[0][0] == 1 && grid[0][1] == 1 && grid[0][2] == 1 && grid[0][3] == 1) {
            return true;
        }
        if (grid[0][1] == 2 && grid[0][2] == 2 && grid[0][3] == 2 && grid[0][4] == 2) {
            return true;
        }
        if (grid[0][1] == 1 && grid[0][2] == 1 && grid[0][3] == 1 && grid[0][4] == 1) {
            return true;
        }
        if (grid[0][2] == 2 && grid[0][3] == 2 && grid[0][4] == 2 && grid[0][5] == 2) {
            return true;
        }
        if (grid[0][2] == 1 && grid[0][3] == 1 && grid[0][4] == 1 && grid[0][5] == 1) {
            return true;
        }
        if (grid[1][0] == 2 && grid[1][1] == 2 && grid[1][2] == 2 && grid[1][3] == 2) {
            return true;
        }
        if (grid[1][0] == 1 && grid[1][1] == 1 && grid[1][2] == 1 && grid[1][3] == 1) {
            return true;
        }
        if (grid[1][1] == 2 && grid[1][2] == 2 && grid[1][3] == 2 && grid[1][4] == 2) {
            return true;
        }
        if (grid[1][1] == 1 && grid[1][2] == 1 && grid[1][3] == 1 && grid[1][4] == 1) {
            return true;
        }
        if (grid[1][2] == 2 && grid[1][3] == 2 && grid[1][4] == 2 && grid[1][5] == 2) {
            return true;
        }
        if (grid[1][2] == 1 && grid[1][3] == 1 && grid[1][4] == 1 && grid[1][5] == 1) {
            return true;
        }
        if (grid[2][0] == 2 && grid[2][1] == 2 && grid[2][2] == 2 && grid[2][3] == 2) {
            return true;
        }
        if (grid[2][0] == 1 && grid[2][1] == 1 && grid[2][2] == 1 && grid[2][3] == 1) {
            return true;
        }
        if (grid[2][1] == 2 && grid[2][2] == 2 && grid[2][3] == 2 && grid[2][4] == 2) {
            return true;
        }
        if (grid[2][1] == 1 && grid[2][2] == 1 && grid[2][3] == 1 && grid[2][4] == 1) {
            return true;
        }
        if (grid[2][2] == 2 && grid[2][3] == 2 && grid[2][4] == 2 && grid[2][5] == 2) {
            return true;
        }
        if (grid[2][2] == 1 && grid[2][3] == 1 && grid[2][4] == 1 && grid[2][5] == 1) {
            return true;
        }
        if (grid[3][0] == 2 && grid[3][1] == 2 && grid[3][2] == 2 && grid[3][3] == 2) {
            return true;
        }
        if (grid[3][0] == 1 && grid[3][1] == 1 && grid[3][2] == 1 && grid[3][3] == 1) {
            return true;
        }
        if (grid[3][1] == 2 && grid[3][2] == 2 && grid[3][3] == 2 && grid[3][4] == 2) {
            return true;
        }
        if (grid[3][1] == 1 && grid[3][2] == 1 && grid[3][3] == 1 && grid[3][4] == 1) {
            return true;
        }
        if (grid[3][2] == 2 && grid[3][3] == 2 && grid[3][4] == 2 && grid[3][5] == 2) {
            return true;
        }
        if (grid[3][2] == 1 && grid[3][3] == 1 && grid[3][4] == 1 && grid[3][5] == 1) {
            return true;
        }
        if (grid[4][0] == 2 && grid[4][1] == 2 && grid[4][2] == 2 && grid[4][3] == 2) {
            return true;
        }
        if (grid[4][0] == 1 && grid[4][1] == 1 && grid[4][2] == 1 && grid[4][3] == 1) {
            return true;
        }
        if (grid[4][1] == 2 && grid[4][2] == 2 && grid[4][3] == 2 && grid[4][4] == 2) {
            return true;
        }
        if (grid[4][1] == 1 && grid[4][2] == 1 && grid[4][3] == 1 && grid[4][4] == 1) {
            return true;
        }
        if (grid[4][2] == 2 && grid[4][3] == 2 && grid[4][4] == 2 && grid[4][5] == 2) {
            return true;
        }
        if (grid[4][2] == 1 && grid[4][3] == 1 && grid[4][4] == 1 && grid[4][5] == 1) {
            return true;
        }
        if (grid[5][0] == 2 && grid[5][1] == 2 && grid[5][2] == 2 && grid[5][3] == 2) {
            return true;
        }
        if (grid[5][0] == 1 && grid[5][1] == 1 && grid[5][2] == 1 && grid[5][3] == 1) {
            return true;
        }
        if (grid[5][1] == 2 && grid[5][2] == 2 && grid[5][3] == 2 && grid[5][4] == 2) {
            return true;
        }
        if (grid[5][1] == 1 && grid[5][2] == 1 && grid[5][3] == 1 && grid[5][4] == 1) {
            return true;
        }
        if (grid[5][2] == 2 && grid[5][3] == 2 && grid[5][4] == 2 && grid[5][5] == 2) {
            return true;
        }
        if (grid[5][2] == 1 && grid[5][3] == 1 && grid[5][4] == 1 && grid[5][5] == 1) {
            return true;
        }
        if (grid[6][0] == 2 && grid[6][1] == 2 && grid[6][2] == 2 && grid[6][3] == 2) {
            return true;
        }
        if (grid[6][0] == 1 && grid[6][1] == 1 && grid[6][2] == 1 && grid[6][3] == 1) {
            return true;
        }
        if (grid[6][1] == 2 && grid[6][2] == 2 && grid[6][3] == 2 && grid[6][4] == 2) {
            return true;
        }
        if (grid[6][1] == 1 && grid[6][2] == 1 && grid[6][3] == 1 && grid[6][4] == 1) {
            return true;
        }
        if (grid[6][2] == 2 && grid[6][3] == 2 && grid[6][4] == 2 && grid[6][5] == 2) {
            return true;
        }
        if (grid[6][2] == 1 && grid[6][3] == 1 && grid[6][4] == 1 && grid[6][5] == 1) {
            return true;
        }
        if (grid[0][3] == 2 && grid[1][2] == 2 && grid[2][1] == 2 && grid[3][0] == 2) {
            return true;
        }
        if (grid[0][3] == 1 && grid[1][2] == 1 && grid[2][1] == 1 && grid[3][0] == 1) {
            return true;
        }
        if (grid[3][3] == 2 && grid[2][2] == 2 && grid[1][1] == 2 && grid[0][0] == 2) {
            return true;
        }
        if (grid[3][3] == 1 && grid[2][2] == 1 && grid[1][1] == 1 && grid[0][0] == 1) {
            return true;
        }
        if (grid[0][4] == 2 && grid[1][3] == 2 && grid[2][2] == 2 && grid[3][1] == 2) {
            return true;
        }
        if (grid[0][4] == 1 && grid[1][3] == 1 && grid[2][2] == 1 && grid[3][1] == 1) {
            return true;
        }
        if (grid[3][4] == 2 && grid[2][3] == 2 && grid[1][2] == 2 && grid[0][1] == 2) {
            return true;
        }
        if (grid[3][4] == 1 && grid[2][3] == 1 && grid[1][2] == 1 && grid[0][1] == 1) {
            return true;
        }
        if (grid[0][5] == 2 && grid[1][4] == 2 && grid[2][3] == 2 && grid[3][2] == 2) {
            return true;
        }
        if (grid[0][5] == 1 && grid[1][4] == 1 && grid[2][3] == 1 && grid[3][2] == 1) {
            return true;
        }
        if (grid[3][5] == 2 && grid[2][4] == 2 && grid[1][3] == 2 && grid[0][2] == 2) {
            return true;
        }
        if (grid[3][5] == 1 && grid[2][4] == 1 && grid[1][3] == 1 && grid[0][2] == 1) {
            return true;
        }
        if (grid[1][3] == 2 && grid[2][2] == 2 && grid[3][1] == 2 && grid[4][0] == 2) {
            return true;
        }
        if (grid[1][3] == 1 && grid[2][2] == 1 && grid[3][1] == 1 && grid[4][0] == 1) {
            return true;
        }
        if (grid[4][3] == 2 && grid[3][2] == 2 && grid[2][1] == 2 && grid[1][0] == 2) {
            return true;
        }
        if (grid[4][3] == 1 && grid[3][2] == 1 && grid[2][1] == 1 && grid[1][0] == 1) {
            return true;
        }
        if (grid[1][4] == 2 && grid[2][3] == 2 && grid[3][2] == 2 && grid[4][1] == 2) {
            return true;
        }
        if (grid[1][4] == 1 && grid[2][3] == 1 && grid[3][2] == 1 && grid[4][1] == 1) {
            return true;
        }
        if (grid[4][4] == 2 && grid[3][3] == 2 && grid[2][2] == 2 && grid[1][1] == 2) {
            return true;
        }
        if (grid[4][4] == 1 && grid[3][3] == 1 && grid[2][2] == 1 && grid[1][1] == 1) {
            return true;
        }
        if (grid[1][5] == 2 && grid[2][4] == 2 && grid[3][3] == 2 && grid[4][2] == 2) {
            return true;
        }
        if (grid[1][5] == 1 && grid[2][4] == 1 && grid[3][3] == 1 && grid[4][2] == 1) {
            return true;
        }
        if (grid[4][5] == 2 && grid[3][4] == 2 && grid[2][3] == 2 && grid[1][2] == 2) {
            return true;
        }
        if (grid[4][5] == 1 && grid[3][4] == 1 && grid[2][3] == 1 && grid[1][2] == 1) {
            return true;
        }
        if (grid[2][3] == 2 && grid[3][2] == 2 && grid[4][1] == 2 && grid[5][0] == 2) {
            return true;
        }
        if (grid[2][3] == 1 && grid[3][2] == 1 && grid[4][1] == 1 && grid[5][0] == 1) {
            return true;
        }
        if (grid[5][3] == 2 && grid[4][2] == 2 && grid[3][1] == 2 && grid[2][0] == 2) {
            return true;
        }
        if (grid[5][3] == 1 && grid[4][2] == 1 && grid[3][1] == 1 && grid[2][0] == 1) {
            return true;
        }
        if (grid[2][4] == 2 && grid[3][3] == 2 && grid[4][2] == 2 && grid[5][1] == 2) {
            return true;
        }
        if (grid[2][4] == 1 && grid[3][3] == 1 && grid[4][2] == 1 && grid[5][1] == 1) {
            return true;
        }
        if (grid[5][4] == 2 && grid[4][3] == 2 && grid[3][2] == 2 && grid[2][1] == 2) {
            return true;
        }
        if (grid[5][4] == 1 && grid[4][3] == 1 && grid[3][2] == 1 && grid[2][1] == 1) {
            return true;
        }
        if (grid[2][5] == 2 && grid[3][4] == 2 && grid[4][3] == 2 && grid[5][2] == 2) {
            return true;
        }
        if (grid[2][5] == 1 && grid[3][4] == 1 && grid[4][3] == 1 && grid[5][2] == 1) {
            return true;
        }
        if (grid[5][5] == 2 && grid[4][4] == 2 && grid[3][3] == 2 && grid[2][2] == 2) {
            return true;
        }
        if (grid[5][5] == 1 && grid[4][4] == 1 && grid[3][3] == 1 && grid[2][2] == 1) {
            return true;
        }
        if (grid[3][3] == 2 && grid[4][2] == 2 && grid[5][1] == 2 && grid[6][0] == 2) {
            return true;
        }
        if (grid[3][3] == 1 && grid[4][2] == 1 && grid[5][1] == 1 && grid[6][0] == 1) {
            return true;
        }
        if (grid[6][3] == 2 && grid[5][2] == 2 && grid[4][1] == 2 && grid[3][0] == 2) {
            return true;
        }
        if (grid[6][3] == 1 && grid[5][2] == 1 && grid[4][1] == 1 && grid[3][0] == 1) {
            return true;
        }
        if (grid[3][4] == 2 && grid[4][3] == 2 && grid[5][2] == 2 && grid[6][1] == 2) {
            return true;
        }
        if (grid[3][4] == 1 && grid[4][3] == 1 && grid[5][2] == 1 && grid[6][1] == 1) {
            return true;
        }
        if (grid[6][4] == 2 && grid[5][3] == 2 && grid[4][2] == 2 && grid[3][1] == 2) {
            return true;
        }
        if (grid[6][4] == 1 && grid[5][3] == 1 && grid[4][2] == 1 && grid[3][1] == 1) {
            return true;
        }
        if (grid[3][5] == 2 && grid[4][4] == 2 && grid[5][3] == 2 && grid[6][2] == 2) {
            return true;
        }
        if (grid[3][5] == 1 && grid[4][4] == 1 && grid[5][3] == 1 && grid[6][2] == 1) {
            return true;
        }
        if (grid[6][5] == 2 && grid[5][4] == 2 && grid[4][3] == 2 && grid[3][2] == 2) {
            return true;
        }
        if (grid[6][5] == 1 && grid[5][4] == 1 && grid[4][3] == 1 && grid[3][2] == 1) {
            return true;
        }
        return false;
    }
}
