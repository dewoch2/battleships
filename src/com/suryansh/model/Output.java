package com.suryansh.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Output {
    private Game game;
    private int size;
    private char[][] playerBoard;
    private char[][] playerBoard2;
    private char[][] cpuBoard;
    private Scanner scanner;

    public Output(Game game) {
        this.game = game;
        this.size = game.getSize();
        this.playerBoard = new char[this.size][this.size];
        this.cpuBoard = new char[this.size][this.size];
        this.playerBoard2 = new char[this.size][this.size];
        this.scanner = new Scanner(System.in);
    }

    public void declareBoards() {
        game.setPlayerBoard2(game.generateBoard(game.getPlayerBoard2()));
        game.setPlayerBoard(game.generateBoard(game.getPlayerBoard()));
        game.setCpuBoard(game.generateBoard(game.getCpuBoard()));

        this.playerBoard2 = game.getPlayerBoard2();
        this.cpuBoard = game.populateCpuBoard();
        this.playerBoard = game.populatePlayerBoard();
    }

    private void displayBoard(char[][] array) {
        for (int i = 0; i < this.size; ++i) {
            for (int j = 0; j < this.size; ++j) {
                System.out.printf("%s ", array[i][j]);
            }
            System.out.printf("%n");
        }
    }

    public void displayBoards() {
        displayBoard(this.playerBoard2);
        System.out.printf("%n___________%n");
        displayBoard(this.playerBoard);
    }

    public void playerAttacks() throws NumberFormatException{
        
            System.out.println("--->Enter a row: ");
            String next = scanner.next();
            int row = Integer.parseInt(next);
            
            System.out.println("--->Enter a column: ");
            next = scanner.next();
            int col = Integer.parseInt(next);
            
            if (game.playerAttacks(row, col)) {
                System.out.println("You got a hit!");
            } else {
                System.out.println("Oops. You missed.");
            }
       
    }
    

    public void cpuAttacks() {
        System.out.println("CPU's turn!");
        if (game.cpuAttacks()) {
            System.out.println("CPU got a hit!");
        } else {
            System.out.println("CPU missed");
        }
    }

    public void outcome() {
        if (game.isWonByCpu()) {
            System.out.println("Good try, but CPU won :(");
        } else if (game.getRemainingTries() == 0) {
            System.out.println("Oh no, you ran out of tries!");
        } else {
            System.out.println("You won!");
        }
    }
}
