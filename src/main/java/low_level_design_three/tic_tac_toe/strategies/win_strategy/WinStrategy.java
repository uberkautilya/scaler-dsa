package low_level_design_three.tic_tac_toe.strategies.win_strategy;

import low_level_design_three.tic_tac_toe.model.Game;

public interface WinStrategy {
    public boolean checkWinner(Game game);
}
