package low_level_design_three.tic_tac_toe.controller;

import low_level_design_three.tic_tac_toe.model.Game;
import low_level_design_three.tic_tac_toe.model.GameState;
import low_level_design_three.tic_tac_toe.model.Player;
import low_level_design_three.tic_tac_toe.strategies.win_strategy.WinStrategy;

import java.util.List;

public class GameController {
    //private Game game; -> This would make the controller tied to a single Game object

    public Game startGame(int dimension,
                          List<Player> players,
                          List<WinStrategy> winStrategies) {
        /*
        Validate Before starting a game:
        1. Check the player count. It needs to be equal to dimension-1.
        2. You can have only one Bot in the game - just an example
        3. Every player should have a separate symbol
         */
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinStrategies(winStrategies)
                .build();
    }

    public GameState getGameState(Game game) {
        return game.getGameState();
    }

    public void display(Game game) {
        game.displayBoard();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void undo(Game game) {
        game.undo();
    }
}

/*
Client Requirements:
1. Start the Game - create game object, attribute setting, getting input from client
while gameState == IN_PROGRESS
2. Display the empty board
3. Make a move: take input, make move, check for winner, update the game state if applicable
4. Check gameState
    if SUCCESS -> Get winner and display
    if DRAW -> declare game draw
 */