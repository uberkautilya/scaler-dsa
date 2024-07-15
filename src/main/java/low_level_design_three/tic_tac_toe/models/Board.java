package low_level_design_three.tic_tac_toe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> grid;

    public Board(int size) {
        this.size = size;
        this.grid = new ArrayList<>();
        for (int i = 0; i)
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
}
