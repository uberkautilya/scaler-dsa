package low_level_design_three.tic_tac_toe.model;

public class HumanPlayer extends Player{
    public HumanPlayer(int id, String name, PlayerType playerType, Symbol symbol) {
        super(id, name, playerType, symbol);
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("Enter the row and column to mark: ");
        int row = sc.nextInt();
        int col = sc.nextInt();
        return new Move(new Cell(row, col), this);
    }
}
