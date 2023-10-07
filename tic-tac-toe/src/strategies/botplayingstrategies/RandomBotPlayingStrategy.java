package strategies.botplayingstrategies;

import java.util.List;

import models.Board;
import models.Cell;
import models.CellState;
import models.Move;
import models.Player;

public class RandomBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move decideMove(Player player, Board board) {
        List<List<Cell>> curBoard = board.getBoard();
        for (int i = 0; i < curBoard.size(); i++) {
            for (int j = 0; j < curBoard.size(); j++) {
                if (curBoard.get(i).get(j).getCellState().equals(CellState.EMPTY)) {
                    return new Move(player, new Cell(i, j));
                }
            }
        }
        return null;
    }

}
