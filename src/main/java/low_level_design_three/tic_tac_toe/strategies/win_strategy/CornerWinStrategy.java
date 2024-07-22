package low_level_design_three.tic_tac_toe.strategies.win_strategy;

import low_level_design_three.tic_tac_toe.model.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CornerWinStrategy implements WinStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {
        List<List<Cell>> grid = board.getGrid();
        Cell currentCell = move.getCell();
        int row = currentCell.getRow();
        int col = currentCell.getCol();

        if (!(row == 0 && col == 0) &&
                !(row == 0 && col == grid.size() - 1) &&
                !(row == grid.size() - 1 && col == 0) &&
                !(row == grid.size() - 1 && col == grid.size() - 1)) {
            return false;
        }
        Symbol currentSymbol = currentCell.getSymbol();

        Set<Symbol> symbolSet = new HashSet<>();
        addToSymbolIfNotNull(grid, symbolSet, 0, 0);
        addToSymbolIfNotNull(grid, symbolSet, 0, grid.size() - 1);
        addToSymbolIfNotNull(grid, symbolSet, grid.size() - 1, 0);
        addToSymbolIfNotNull(grid, symbolSet, grid.size() - 1, grid.size() - 1);

        return (symbolSet.size() == 1);
    }

    private void addToSymbolIfNotNull(List<List<Cell>> grid, Set<Symbol> set, int row, int col) {
        Symbol symbol = grid.get(row).get(col).getSymbol();
        if (symbol != null) {
            set.add(symbol);
        }
    }
}
