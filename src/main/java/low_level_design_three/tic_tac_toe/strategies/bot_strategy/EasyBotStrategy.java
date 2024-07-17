package low_level_design_three.tic_tac_toe.strategies.bot_strategy;

import low_level_design_three.tic_tac_toe.model.*;

import java.util.List;

public class EasyBotStrategy implements BotStrategy {
    private Player bot;

    @Override
    public Move makeMove(Board board) {
        for (List<Cell> row : board.getGrid()) {
            for (Cell cell : row) {
                if (CellState.EMPTY.equals(cell.getCellState())) {
                    return new Move(new Cell(cell.getRow(), cell.getCol()), bot);
                }
            }
        }
        return null;
    }
}
