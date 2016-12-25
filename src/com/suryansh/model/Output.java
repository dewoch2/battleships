package com.suryansh.model;

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

    public void promptForAttack() {
        System.out.println("It's your turn!");
        System.out.println("--->Enter a row: ");
        int row = scanner.nextInt();
        System.out.println("--->Enter a column: ");
        int col = scanner.nextInt();
        if (game.playerAttack(row, col)) {
            System.out.println("You got a hit!");
        } else {
            System.out.println("Oops, you missed.");
        }

        System.out.println("CPU's turn");
        if (game.cpuAttack()) {
            System.out.println("CPU got a hit!");
        } else {
            System.out.println("CPU Missed");
        }
    }
}
