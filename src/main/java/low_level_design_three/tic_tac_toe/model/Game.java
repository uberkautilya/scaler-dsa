package low_level_design_three.tic_tac_toe.model;

import low_level_design_three.tic_tac_toe.strategies.win_strategy.WinStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private Board board;
    private List<Player> players;
    private Player winner;
    private int nextPlayerIndex;
    private List<Move> moves;
    private GameState gameState;
    private List<WinStrategy> winStrategies;

    private Game(Builder builder) {
        board = new Board(builder.dimension);
        players = builder.players;
        winStrategies = builder.winStrategies;
        winner = null;
        nextPlayerIndex = 0;
        moves = new ArrayList<>();
        gameState = GameState.IN_PROGRESS;
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<WinStrategy> getWinStrategies() {
        return winStrategies;
    }

    public void setWinStrategies(List<WinStrategy> winStrategies) {
        this.winStrategies = winStrategies;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    //Should be placed in the Service Layer - would be done later
    public void displayBoard() {
        board.display();
    }

    public void makeMove() {
        // get current player
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println("It's " + currentPlayer.getName() + "'s turn. Make a move.!");

        Move currentMove = currentPlayer.makeMove(board);
        if (!isValidMove(currentMove)) {
            System.out.println("Invalid move. Try again.!");
        }
        int row = currentMove.getCell().getRow();
        int col = currentMove.getCell().getCol();

        Cell currentCell = board.getGrid().get(row).get(col);
        currentCell.setCellState(CellState.FILLED);
        currentCell.setSymbol(currentPlayer.getSymbol());

        currentMove.setCell(currentCell);
        currentMove.setPlayer(currentPlayer);
        moves.add(currentMove);

        nextPlayerIndex++;
        nextPlayerIndex %= players.size();
        if (checkWinner(currentMove)) {
            setWinner(currentPlayer);
            setGameState(GameState.SUCCESS);
        }
    }

    private boolean checkWinner(Move currentMove) {
        return false;
    }

    private boolean isValidMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row < 0 || row > board.getDimension() - 1 ||
                col < 0 || col > board.getDimension() - 1) {
            return false;
        }
        Cell cell = board.getGrid().get(row).get(col);
        return cell.getCellState().equals(CellState.EMPTY);
    }

    public void undo() {
        if (!moves.isEmpty()) {
            Cell cell = moves.getLast().getCell();
            cell.setCellState(CellState.EMPTY);
            cell.setSymbol(null);
            nextPlayerIndex = (nextPlayerIndex + players.size()) % players.size();
            moves.removeLast();
            setGameState(GameState.IN_PROGRESS);
            setWinner(null);
            //If the strategy was implemented with a HashMap, we would need to undo the modifications as well - could have handleUndo(Board board, Move move);
        }
    }

    public static class Builder {
        private int dimension;
        private List<Player> players;
        private List<WinStrategy> winStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinStrategies(List<WinStrategy> winStrategies) {
            this.winStrategies = winStrategies;
            return this;
        }

        public void validate() {
            /*
            Validate:
            1. check player count = dimension -1
            2. Only one bot
            3. Every player has a separate symbol
             */
            if (players.size() != dimension - 1) {
                throw new RuntimeException("Invalid player count");
            }
            int botCount = 0;
            for (Player player : players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
            }
            if (botCount > 1) {
                throw new RuntimeException("More than one bot not allowed");
            }
            Set<Character> symbolSet = new HashSet<>();
            for (Player player : players) {
                char sym = player.getSymbol().getSym();
                if (symbolSet.contains(sym)) {
                    throw new RuntimeException("Duplicate symbols in players");
                }
                symbolSet.add(sym);
            }
        }

        public Game build() {
            validate();
            return new Game(this);
        }
    }
}
