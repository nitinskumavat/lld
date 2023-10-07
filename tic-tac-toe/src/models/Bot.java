package models;

import factories.BotPlayingStrategyFactory;
import strategies.botplayingstrategies.BotPlayingStrategy;

public class Bot extends Player {
    private BotDifficutlyLevel botDifficutlyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, char symbol, BotDifficutlyLevel botDifficutlyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficutlyLevel = botDifficutlyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyFactory(botDifficutlyLevel);
    }

    public BotDifficutlyLevel getBotDifficultyLevel() {
        return this.botDifficutlyLevel;
    }

    public void setBotDifficultyLevel(BotDifficutlyLevel botDifficutlyLevel) {
        this.botDifficutlyLevel = botDifficutlyLevel;
    }

    @Override
    public Move decideMove(Board board) {
        return botPlayingStrategy.decideMove(this, board);
    }
}
