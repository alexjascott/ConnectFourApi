package com.alexscott.connectfourapi;

import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by alex on 17/12/2016.
 */
@RestController
public class GameController {
    private static HashMap<UUID, Game> gameMap = new HashMap();

    /***
     * Creates a new game, returns game status.
     * @param request NewGameRequest JSON
     * @return GameStatus
     */
    @RequestMapping(value="/newgame", method= RequestMethod.POST)
    public GameStatus createNewGame(@Valid @RequestBody NewGameRequest request) {
        Game game = new Game(request.getPlayer1(), request.getPlayer2());
        System.out.println("Created a new game with id: " + game.getId());
        gameMap.put(game.getId(), game);
        return buildGameStatus(game);
    }

    /***
     * Returns the game status.
     * @param uuid UUID
     * @return GameStatus
     * @throws IllegalAccessException
     */
    @RequestMapping(value="/status", method= RequestMethod.GET)
    public GameStatus createNewGame(@Valid @RequestParam UUID uuid) throws IllegalAccessException {
        Game game = gameMap.get(uuid);
        if (game == null) {
            throw new IllegalAccessException("A game with id of "  + uuid + " could not be found.");
        } else {
            return buildGameStatus(game);
        }
    }

    /***
     * Lets a player make a move.
     * @param uuid UUID
     * @param playername String
     * @param column int
     * @return GameStatus
     * @throws IllegalAccessException
     * @throws ColumnOutOfBoundsException
     */
    @RequestMapping(value="/move", method= RequestMethod.POST)
    public GameStatus move(@Valid @RequestParam UUID uuid,
                                  @Valid @RequestParam String playername,
                                  @Valid @RequestParam int column)
                                  throws IllegalAccessException, ColumnOutOfBoundsException {
        Game game = gameMap.get(uuid);
        if (game == null) {
            throw new IllegalAccessException("A game with id of "  + uuid + " could not be found.");
        } else {
            int playerNumber = game.getPlayerNumber(playername);
            game.move(playerNumber, column);
            return buildGameStatus(game);
        }
    }

    /***
     * Builds the game status response POJO to be transformed into response JSON.
     * @param game Game
     * @return GameStatus
     */
    private GameStatus buildGameStatus(Game game) {
        GameStatus status = new GameStatus();

        status.setUuid(game.getId());
        status.setPlayer1(game.getPlayer1());
        status.setPlayer2(game.getPlayer2());
        status.setState(game.getState());
        status.setBoard(game.printBoard());

        return status;
    }
}