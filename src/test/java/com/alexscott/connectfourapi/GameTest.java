package com.alexscott.connectfourapi;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GameTest {
    @Test
    public void player2CantMakeTurnWhenNotHisGo() throws Exception {
        Game game = new Game("alex", "steve");

        try {
            game.move(2, 1);
            fail("Should have thrown an exception");
        } catch (IllegalAccessException ex) {
            assertEquals(ex.getMessage(), "It is not your turn!");
        }
    }

    @Test
    public void player1CantMakeTurnWhenNotHisGo() throws Exception {
        Game game = new Game("alex", "steve");

        game.move(1, 1);

        try {
            game.move(1, 1);
            fail("Should have thrown an exception");
        } catch (IllegalAccessException ex) {
            assertEquals(ex.getMessage(), "It is not your turn!");
        }
    }

    @Test
    public void player1CantMakeTurnWhenGameWon() throws Exception {
        Game game = new Game("alex", "steve");

        game.move(1, 1);
        game.move(2, 2);
        game.move(1, 1);
        game.move(2, 2);
        game.move(1, 1);
        game.move(2, 2);
        game.move(1, 1);

        try {
            game.move(1, 1);
            fail("Should have thrown an exception");
        } catch (IllegalAccessException ex) {
            assertEquals(ex.getMessage(), "The game has been won!");
        }
    }

    @Test
    public void player2CantMakeTurnWhenGameWon() throws Exception {
        Game game = new Game("alex", "steve");

        game.move(1, 1);
        game.move(2, 2);
        game.move(1, 1);
        game.move(2, 2);
        game.move(1, 1);
        game.move(2, 2);
        game.move(1, 1);

        try {
            game.move(2, 2);
            fail("Should have thrown an exception");
        } catch (IllegalAccessException ex) {
            assertEquals(ex.getMessage(), "The game has been won!");
        }
    }
}