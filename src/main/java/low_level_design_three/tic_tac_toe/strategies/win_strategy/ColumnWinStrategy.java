package low_level_design_three.tic_tac_toe.strategies.win_strategy;

import low_level_design_three.tic_tac_toe.model.Cell;
import low_level_design_three.tic_tac_toe.model.Game;
import low_level_design_three.tic_tac_toe.model.Symbol;

import java.util.List;

public class ColumnWinStrategy implements WinStrategy {
    @Override
    public boolean checkWinner(Game game) {
        List<List<Cell>> grid = game.getBoard().getGrid();
        Cell currentCell = game.getMoves().getLast().getCell();
        int currentCol = currentCell.getCol();
        Symbol currentSymbol = currentCell.getSymbol();

        long count = grid.stream()
                .map(row -> row.get(currentCol))
                .filter(cell -> currentSymbol.equals(cell.getSymbol()))
                .count();
        return (count == grid.size());
    }
}
