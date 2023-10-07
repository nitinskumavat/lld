package controllers;

import java.util.List;

import models.Game;
import models.GameStatus;
import models.Player;

public class GameController {
    public Game createGame(int dimension, List<Player> players) {
        try {
            return Game.getBuilder()
                    .setDimension(dimension)
                    .setPlayers(players)
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }

    public void executeNextMove(Game game) {
        game.nextMove();
    }
}
