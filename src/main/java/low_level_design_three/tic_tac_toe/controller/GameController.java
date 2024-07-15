package low_level_design_three.tic_tac_toe.controller;

import low_level_design_three.tic_tac_toe.models.Game;
import low_level_design_three.tic_tac_toe.models.GameState;
import low_level_design_three.tic_tac_toe.models.Player;

public class GameController {
    //private Game game; -> This would make the controller tied to a single Game object

    public Game startGame() {
        return new Game();
    }

    public GameState checkGameState(Game game) {
        return null;
    }

    public void display(Game game) {

    }

    public void makeMove(Game game) {

    }

    public Player getWinner(Game game) {
        return null;
    }

    public void undo(Game game) {

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