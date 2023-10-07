package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import exceptions.InvalidGameParameterException;
import strategies.gamewinningstrategies.OrderOneWinningStrategy;

public class Game {
    private Board board;
    private int dimension;
    private List<Player> players;
    private GameStatus gameStatus;
    private List<Move> moves;
    private int nextPlayerIndex;
    private Player winner;
    private OrderOneWinningStrategy orderOneWinningStrategy;

    public Player getWinner() {
        return this.winner;
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setWinner(Player player) {
        this.winner = player;
    }

    public void displayBoard() {
        this.board.display();
    }

    public List<Move> getMoves() {
        return moves;
    }

    private Game() {
    }

    public void nextMove() {
        Player curentTurnPlayer = players.get(this.nextPlayerIndex);
        System.out.println("It is " + curentTurnPlayer.getName() + "'s turn.");
        Move move = curentTurnPlayer.decideMove(this.board);
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        this.board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        this.board.getBoard().get(row).get(col).setPlayer(curentTurnPlayer);

        Move finalMove = new Move(
                curentTurnPlayer,
                this.board.getBoard().get(row).get(col));
        this.moves.add(finalMove);
        if (this.orderOneWinningStrategy.checkWinner(this.board, curentTurnPlayer, finalMove.getCell())) {
            this.gameStatus = GameStatus.WON;
            this.winner = curentTurnPlayer;
        }
        if (this.moves.size() == this.dimension * this.dimension) {
            this.gameStatus = GameStatus.DRAW;
        }
        nextPlayerIndex = (nextPlayerIndex + 1) % this.players.size();

    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int dimension;
        private List<Player> players;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private void validate() throws InvalidGameParameterException {
            if (this.dimension < 3) {
                throw new InvalidGameParameterException("Dimension should be greater than 2");
            }
            if (this.players.size() < this.dimension - 1) {
                throw new InvalidGameParameterException("Number of players should be equal to dimension-1");
            }
            HashSet<Character> symbols = new HashSet<>();
            for (Player player : this.players) {
                if (symbols.contains(player.getSymbol())) {
                    throw new InvalidGameParameterException("Each player should have a unique symbol");
                }
                symbols.add(player.getSymbol());
            }
        }

        public Game build() throws InvalidGameParameterException {
            try {
                validate();
            } catch (Exception e) {
                throw new InvalidGameParameterException(e.getMessage());
            }
            Game game = new Game();
            game.players = this.players;
            game.dimension = this.dimension;
            game.moves = new ArrayList<>();
            game.gameStatus = GameStatus.IN_PROGRESS;
            game.board = new Board(dimension);
            game.nextPlayerIndex = 0;
            game.orderOneWinningStrategy = new OrderOneWinningStrategy(dimension);
            return game;

        }

    }

}
