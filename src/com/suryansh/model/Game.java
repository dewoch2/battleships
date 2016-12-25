package com.suryansh.model;

public class Game {
    private char[][] playerBoard;
    private char[][] cpuBoard;
    private int size = 7;
    private int[][] intDir;

    public Game() {
        this.playerBoard = new char[size][size];
        this.cpuBoard = new char[size][size];
        this.intDir = new int[20][20];
    }

    public char[][] generateBoard(char[][] array) {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                array[i][j] = 'n';
            }
        }
    }

    private boolean checkEntries(int coordX, int coordY) {
        if ()
    }
    public boolean attack(int coordX, int coordY) {

    }
}
