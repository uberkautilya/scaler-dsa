package low_level_design_three.tic_tac_toe.models;

import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> grid;

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
}
