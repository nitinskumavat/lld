package factories;

import models.BotDifficutlyLevel;
import strategies.botplayingstrategies.BotPlayingStrategy;
import strategies.botplayingstrategies.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyFactory(BotDifficutlyLevel botDifficutlyLevel) {
        return new RandomBotPlayingStrategy();
    }
}
