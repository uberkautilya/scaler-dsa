package low_level_design_three.tic_tac_toe.strategies.win_strategy;

import low_level_design_three.tic_tac_toe.model.*;

import java.util.List;

public class ColumnWinStrategy implements WinStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {
        List<List<Cell>> grid = board.getGrid();
        Symbol moveSymbol = move.getPlayer().getSymbol();
        int moveCol = move.getCell().getCol();

        long count = grid.stream()
                .map(row -> row.get(moveCol))
                .filter(cell -> moveSymbol.equals(cell.getSymbol()))
                .count();
        return (count == grid.size());
    }
}
