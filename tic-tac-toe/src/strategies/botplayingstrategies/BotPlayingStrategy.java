package strategies.botplayingstrategies;

import models.Board;
import models.Move;
import models.Player;

public interface BotPlayingStrategy {
    Move decideMove(Player player, Board board);
}
