package low_level_design_three.tic_tac_toe.models;

public class Bot extends Player{
    private BotDifficulty botDifficulty;

    public BotDifficulty getBotDifficulty() {
        return botDifficulty;
    }

    public void setBotDifficulty(BotDifficulty botDifficulty) {
        this.botDifficulty = botDifficulty;
    }
}
