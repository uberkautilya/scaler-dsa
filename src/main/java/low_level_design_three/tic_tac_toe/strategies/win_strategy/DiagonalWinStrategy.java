package low_level_design_three.tic_tac_toe.strategies.win_strategy;

import low_level_design_three.tic_tac_toe.model.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiagonalWinStrategy implements WinStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {
        List<List<Cell>> grid = game.getBoard().getGrid();
        Cell currentCell = game.getMoves().getLast().getCell();
        int currentRow = currentCell.getRow();
        int currentCol = currentCell.getCol();

        if (!isCellOnDiagonal(grid, currentCell)) {
            return false;
        }
        Set<Symbol> mainDiaSymbols = new HashSet<>();
        Set<Symbol> nextDiaSymbols = new HashSet<>();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size(); j++) {
                if (i == j) {
                    addToSymbolIfNotNull(grid, mainDiaSymbols, currentRow, currentCol);
                }
                if (i + j == grid.size() - 1) {
                    addToSymbolIfNotNull(grid, nextDiaSymbols, currentRow, currentCol);
                }
            }
        }
        return (mainDiaSymbols.size() == 1 || nextDiaSymbols.size() == 1);
    }

    private boolean isCellOnDiagonal(List<List<Cell>> grid, Cell currentCell) {
        int currentRow = currentCell.getRow();
        int currentCol = currentCell.getCol();
        return (currentRow == currentCol) || (currentRow + currentCol == grid.size() - 1);
    }

    private void addToSymbolIfNotNull(List<List<Cell>> grid, Set<Symbol> set, int row, int col) {
        Symbol symbol = grid.get(row).get(col).getSymbol();
        if (symbol != null) {
            set.add(symbol);
        }
    }
}
