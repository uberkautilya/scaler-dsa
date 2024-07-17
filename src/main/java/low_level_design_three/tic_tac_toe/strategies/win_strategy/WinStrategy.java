package low_level_design_three.tic_tac_toe.strategies.win_strategy;

import low_level_design_three.tic_tac_toe.model.Board;
import low_level_design_three.tic_tac_toe.model.Move;

public interface WinStrategy {
    public boolean checkWinner(Board board, Move move);
}
