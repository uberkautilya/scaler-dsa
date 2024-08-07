package low_level_design_three.tic_tac_toe.strategies.win_strategy;

import low_level_design_three.tic_tac_toe.model.*;

import java.util.List;

public class RowWinStrategy implements WinStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {
        List<List<Cell>> grid = board.getGrid();
        Cell currentCell = move.getCell();
        int currentRow = currentCell.getRow();
        Symbol currentSymbol = currentCell.getSymbol();

        long count = grid.stream()
                .map(row -> row.get(currentRow))
                .filter(cell -> currentSymbol.equals(cell.getSymbol()))
                .count();
        return (count == grid.size());
    }
}
