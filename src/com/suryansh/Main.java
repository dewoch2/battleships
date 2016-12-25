package com.suryansh;

import com.suryansh.model.Game;
import com.suryansh.model.Output;

//FIXME: When any exception other that IllegalArgumentException is encountered, player's turn is skipped.
//FIXME: When a character is entered instead of an integer, an infinite loop is executed.
public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Output output = new Output(game);

        output.declareBoards();

        do {
            output.displayBoards();

            System.out.println("It's your turn!");
            try {
                output.playerAttack();
                output.cpuAttack();
                System.out.printf("%n%n");
            } catch (IllegalArgumentException e) {
                System.out.printf("%s%n", e.getMessage());
            } catch (ArrayIndexOutOfBoundsException ai) {
                System.out.printf("One or more of the coordinates entered are larger than the board. Enter new coords. %n");
            }
        } while (!game.isWonByPlayer() || !game.isWonByCpu() || game.getRemainingTries() != 0);
    }
}
