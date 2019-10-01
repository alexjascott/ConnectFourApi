package com.alexscott.connectfourapi;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BoardTest {
    @Test
    public void diagonalWinCondition() throws Exception {
        Board board = new Board();

        board.move(1, 1);
        board.move(2, 2);
        board.move(2, 1);
        board.move(3, 2);
        board.move(3, 1);
        board.move(4, 2);
        board.move(3, 1);
        board.move(4, 2);
        board.move(4, 1);
        board.move(1, 2);
        board.move(4, 1);

        System.out.println(board.print());

        assertEquals(true, board.winCondition());
    }

    @Test
    public void noDiagonalCondition() throws Exception {
        Board board = new Board();

        board.move(1, 1);
        board.move(2, 2);
        board.move(2, 1);
        board.move(3, 2);
        board.move(3, 1);
        board.move(4, 2);
        board.move(3, 1);
        board.move(4, 2);
        board.move(4, 1);
        board.move(4, 2);
        board.move(4, 1);

        System.out.println(board.print());

        assertEquals(false, board.winCondition());
    }

    @Test
    public void verticalWinCondition() throws Exception {
        Board board = new Board();

        board.move(1, 1);
        board.move(2, 2);
        board.move(1, 1);
        board.move(3, 2);
        board.move(1, 1);
        board.move(4, 2);
        board.move(1, 1);

        System.out.println(board.print());

        assertEquals(true, board.winCondition());
    }

    @Test
    public void noVerticalCondition() throws Exception {
        Board board = new Board();

        board.move(1, 1);
        board.move(2, 2);
        board.move(1, 1);
        board.move(3, 2);
        board.move(1, 1);
        board.move(1, 2);
        board.move(1, 1);

        System.out.println(board.print());

        assertEquals(false, board.winCondition());
    }

    @Test
    public void horizontalWinCondition() throws Exception {
        Board board = new Board();

        board.move(1, 1);
        board.move(1, 2);
        board.move(2, 1);
        board.move(2, 2);
        board.move(3, 1);
        board.move(3, 2);
        board.move(0, 1);

        System.out.println(board.print());

        assertEquals(true, board.winCondition());
    }

    @Test
    public void noHorizontalCondition() throws Exception {
        Board board = new Board();

        board.move(1, 1);
        board.move(1, 2);
        board.move(2, 1);
        board.move(2, 2);
        board.move(3, 1);
        board.move(3, 2);
        board.move(2, 1);

        System.out.println(board.print());

        assertEquals(false, board.winCondition());
    }

    @Test
    public void outOfRangeWidthBelow() throws Exception {
        Board board = new Board();

        try {
            board.move(-1, 1);
        } catch (ColumnOutOfBoundsException coobe) {
            assertEquals("Column -1 not in range.", coobe.getMessage());
        }
    }

    @Test
    public void outOfRangeWidthAbove() throws Exception {
        Board board = new Board();

        try {
            board.move(22, 1);
        } catch (ColumnOutOfBoundsException coobe) {
            assertEquals("Column 22 not in range.", coobe.getMessage());
        }
    }

    @Test
    public void outOfRangeHeight() throws Exception {
        Board board = new Board();

        board.move(2, 1);
        board.move(2, 2);
        board.move(2, 1);
        board.move(2, 2);
        board.move(2, 1);
        board.move(2, 2);

        try {
            board.move(2, 1);
        } catch (ColumnOutOfBoundsException coobe) {
            assertEquals("Column 2 is completely full.", coobe.getMessage());
        }
    }
}
