package com.suryansh;

import com.suryansh.model.Game;
import com.suryansh.model.Output;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Output output = new Output(game);

        output.declareBoards();

        while (!game.isWonByPlayer() && game.getRemainingTries() > 0) {
            output.displayBoards();
            output.promptForAttack();
        }
    }
}
