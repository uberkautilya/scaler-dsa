package low_level_design_three.tic_tac_toe.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> grid;

    public Board(int dimension) {
        this.dimension = dimension;
        this.grid = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < dimension; j++) {
                grid.get(i).add(new Cell(i, j));
            }
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }

    public void display() {
        for (List<Cell> row : grid) {
            for (Cell cell : row) {
                //Display behavior is part of the cell. Any behavior attached to a cell should be controlled within the class ideally.
                cell.display();
            }
            System.out.println();
        }
    }

    public boolean isFilled() {
        return grid.stream()
                .flatMap(Collection::stream)
                .noneMatch(c -> CellState.EMPTY.equals(c.getCellState()));
    }
}
