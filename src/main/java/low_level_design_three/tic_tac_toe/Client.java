package low_level_design_three.tic_tac_toe;

import low_level_design_three.tic_tac_toe.controller.GameController;
import low_level_design_three.tic_tac_toe.models.GameState;

public class Client {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.startGame();

        while (controller.checkGameState().equals(GameState.IN_PROGRESS)) {
            controller.display();
            controller.makeMove();
        }
        if (controller.checkGameState().equals(GameState.SUCCESS)) {
            System.out.println(controller.getWinner().getName() + " won.!");
        } else if (controller.checkGameState().equals(GameState.DRAW)) {
            System.out.println("Game is a draw.!");
        }
    }
}

/*
STRUCTURING THE CODE
1. Create your models
2. Create the controller and the client - we don't have an API endpoint

H.W.
1. Implement checkWinner() method
 */
