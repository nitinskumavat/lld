package strategies.gamewinningstrategies;

import models.Board;
import models.Cell;
import models.Player;

public interface GameWinningStrategies {

    public boolean checkWinner(Board board, Player lastMovePlayer, Cell moveCell);
}
