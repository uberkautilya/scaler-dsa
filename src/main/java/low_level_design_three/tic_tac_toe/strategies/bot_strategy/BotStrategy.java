package low_level_design_three.tic_tac_toe.strategies.bot_strategy;

import low_level_design_three.tic_tac_toe.model.Board;
import low_level_design_three.tic_tac_toe.model.Move;

public interface BotStrategy {
    public Move makeMove(Board board);
}
