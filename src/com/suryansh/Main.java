package com.suryansh;

import com.suryansh.model.Game;
import com.suryansh.model.Output;

import java.util.concurrent.TimeUnit;

//FIXME: When any exception other that IllegalArgumentException is encountered, player's turn is skipped.
//FIXME: When a character is entered instead of an integer, an infinite loop is executed.
public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Output output = new Output(game);

        output.declareBoards();

        boolean mustDisplayBoard = true;

        do {

            if(mustDisplayBoard) {
                output.displayBoards();

                System.out.println("It's your turn!");
                System.out.printf(" You have %d tries remaining!%n%n", game.getRemainingTries());
            }

            mustDisplayBoard = true;
            try {
                output.playerAttacks();
                TimeUnit.SECONDS.sleep(2);
                output.cpuAttacks();
                TimeUnit.SECONDS.sleep(2);
                System.out.printf("%n%n");
            } catch (NumberFormatException nfe) {
            	
            	System.out.println("Please enter an Integer!");
                mustDisplayBoard = false;
            	
            } catch (IllegalArgumentException e) {
                System.out.printf("%s%n", e.getMessage());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e1) {
                    System.out.println("Delay interrupted!");
                }
            } catch (ArrayIndexOutOfBoundsException ai) {
                System.out.printf("One or more of the coordinates entered are larger than the board. Enter new coords: %n");
            } catch (InterruptedException ie) {
                System.out.println("Please do not interrupt the delay!");
            }
        } while (!game.isWonByPlayer() || !game.isWonByCpu() || game.getRemainingTries() != 0);

        output.outcome();
    }
}
