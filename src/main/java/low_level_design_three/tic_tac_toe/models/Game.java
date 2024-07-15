package low_level_design_three.tic_tac_toe.models;

import low_level_design_three.tic_tac_toe.strategies.winning.WinningStrategy;

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
    private List<WinningStrategy> winningStrategies;

    private Game(Builder builder) {
        board = new Board(builder.getDimension());
        players = builder.getPlayer();

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

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    //Should be placed in the Service Layer - would be done later
    public void displayBoard() {
        board.display();
    }

    public static class Builder {
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinStrategies(List<WinningStrategy> winStrategies) {
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
