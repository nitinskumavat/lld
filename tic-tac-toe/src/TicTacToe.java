import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controllers.GameController;
import models.Bot;
import models.BotDifficutlyLevel;
import models.Game;
import models.GameStatus;
import models.Player;
import models.PlayerType;

public class TicTacToe {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();
        List<Player> players = new ArrayList<>();
        System.out.println("Enter the board dimension");

        int dimension = sc.nextInt();
        sc.nextLine();

        int toIterate = dimension - 1;

        System.out.println("Will there be bot in the game? (y/n)");
        String isBotString = sc.nextLine();

        if (isBotString.equals("y")) {
            System.out.println("Enter the name of the bot:");
            String name = sc.next();
            System.out.println("Enter the Player Symbol:");
            String symbol = sc.next();
            players.add(new Bot(name, symbol.charAt(0), BotDifficutlyLevel.EASY));
            --toIterate;
        }

        for (int i = 0; i < toIterate; i++) {
            System.out.println("Enter the name of player " + (i + 1) + ":");
            String name = sc.next();
            System.out.println("Enter the Player Symbol " + (i + 1) + ":");
            String symbol = sc.next();
            players.add(new Player(name, symbol.charAt(0), PlayerType.HUMAN));

        }

        Game game = gameController.createGame(dimension, players);
        while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {
            System.out.println("Current board");
            gameController.displayBoard(game);
            gameController.executeNextMove(game);
        }
        gameController.displayBoard(game);
        if (!game.getGameStatus().equals(GameStatus.DRAW)) {
            System.out.println("Winner is " + game.getWinner().getName());
        } else {
            System.out.println("Game is a draw");
        }
        sc.close();
    }
}
