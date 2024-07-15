package low_level_design_three.tic_tac_toe;

import low_level_design_three.tic_tac_toe.controller.GameController;
import low_level_design_three.tic_tac_toe.models.*;
import low_level_design_three.tic_tac_toe.strategies.winning.RowWinnerStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        /*
        For every order, we don't create a new waiter
        GameController controller = new GameController();
        Instead,
        Game game = controller.startGame(states..);
         */
        GameController controller = new GameController();
        List<Player> playerList = new ArrayList<>();
        playerList.add(new HumanPlayer(1, "Mithun", PlayerType.HUMAN, new Symbol('0')));
        playerList.add(new Bot(1, "Bot101", PlayerType.BOT, new Symbol('B'), BotDifficulty.EASY));

        Game game = controller.startGame(3, playerList, List.of(new RowWinnerStrategy()));

        while (controller.checkGameState(game).equals(GameState.IN_PROGRESS)) {
            controller.display(game);
            controller.makeMove(game);
        }
        if (controller.checkGameState(game).equals(GameState.SUCCESS)) {
            System.out.println(controller.getWinner(game).getName() + " won.!");
        } else if (controller.checkGameState(game).equals(GameState.DRAW)) {
            System.out.println("Game is a draw.!");
        }
    }
}

/*
STRUCTURING THE CODE
1. Create your models
2. Create the controller and the client - we don't have an API endpoint
3. Make sure every model has a constructor
4. Implement the functionalities one by one

H.W.
1. Implement checkWinner() method
2. Clean the validate code + validate the symbol
 */
