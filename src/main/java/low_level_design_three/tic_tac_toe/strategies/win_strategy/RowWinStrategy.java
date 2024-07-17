package low_level_design_three.tic_tac_toe.strategies.win_strategy;

import low_level_design_three.tic_tac_toe.model.Cell;
import low_level_design_three.tic_tac_toe.model.Game;
import low_level_design_three.tic_tac_toe.model.Symbol;

import java.util.List;

public class RowWinStrategy implements WinStrategy {
    @Override
    public boolean checkWinner(Game game) {
        List<List<Cell>> grid = game.getBoard().getGrid();
        Cell currentCell = game.getMoves().getLast().getCell();
        int currentRow = currentCell.getRow();
        Symbol currentSymbol = currentCell.getSymbol();

        long count = grid.stream()
                .map(row -> row.get(currentRow))
                .filter(cell -> currentSymbol.equals(cell.getSymbol()))
                .count();
        return (count == grid.size());
    }
}
