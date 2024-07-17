package low_level_design_three.tic_tac_toe.model;

public class BotPlayer extends Player{
    private BotDifficulty botDifficulty;

    public BotPlayer(int id, String name, PlayerType playerType, Symbol symbol, BotDifficulty botDifficulty) {
        super(id, name, playerType, symbol);
        this.botDifficulty = botDifficulty;
    }

    public BotDifficulty getBotDifficulty() {
        return botDifficulty;
    }

    public void setBotDifficulty(BotDifficulty botDifficulty) {
        this.botDifficulty = botDifficulty;
    }
}
