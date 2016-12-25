package com.suryansh.model;

/*
    CPU's attacks should be with 'O'
    CPU's ships should be with 'C'

    Player's attacks should be with 'X'
    Player's ships should be with 'P'

    Attacked areas are declared with '#'
 */

import java.util.Random;

public class Game {
    public final int MAX_TRIES = this.size;
    private char[][] playerBoard;
    private char[][] cpuBoard;
    private char[][] playerBoard2;
    private int size = 7;
    private int missed;
    /*private int[] intDir1;
    private int[] intDir2;*/
    private Random random = new Random();

    public Game() {
        this.playerBoard = new char[size][size];
        this.cpuBoard = new char[size][size];
        this.playerBoard2 = new char[size][size];
//        this.intDir1 = new int[15];
//        this.intDir2 = new int[15];
        this.missed = 0;
    }

    public int getRemainingTries() {
        return MAX_TRIES - missed;
    }

    public int getSize() {
        return this.size;
    }

    public void setPlayerBoard(char[][] playerBoard) {
        this.playerBoard = playerBoard;
    }

    public void setCpuBoard(char[][] cpuBoard) {
        this.cpuBoard = cpuBoard;
    }

    public void setPlayerBoard2(char[][] playerBoard2) {
        this.playerBoard2 = playerBoard2;
    }

    public char[][] getPlayerBoard() {
        return this.playerBoard;
    }

    public char[][] getPlayerBoard2() {
        return this.playerBoard2;
    }

    public char[][] getCpuBoard() {
        return this.cpuBoard;
    }

    public char[][] generateBoard(char[][] array) {
        for (int i = 0; i < this.size; ++i) {
            for (int j = 0; j < this.size; ++j) {
                array[i][j] = 'n';
            }
        }
        return array;
    }

    public char[][] populatePlayerBoard() {
        int ranIntX;
        int ranIntY;

        int i = 15;

        while (i > 0) {
            ranIntX = random.nextInt(15);
            ranIntY = random.nextInt(15);

            if (this.playerBoard[ranIntX][ranIntY] != 'P') {
                this.playerBoard[ranIntX][ranIntY] = 'P';
                --i;
            }
        }
        return this.playerBoard;
    }

    public char[][] populateCpuBoard() {
        int ranIntX;
        int ranIntY;

        int i = 15;

        while (i > 0) {
            ranIntX = random.nextInt(15);
            ranIntY = random.nextInt(15);

            if (this.cpuBoard[ranIntX][ranIntY] != 'P') {
                this.cpuBoard[ranIntX][ranIntY] = 'P';
                --i;
            }
            i += 0;
        }
        return this.cpuBoard;
    }

    private boolean isCpuHit(int coordX, int coordY) {
        if (this.cpuBoard[coordX][coordY] == 'C') {
            this.playerBoard2[coordX][coordY] = '#';
            return true;
        }
        ++this.missed;
        return false;
    }

    private boolean isPlayerHit(int coordX, int coordY) {
        if (this.playerBoard[coordX][coordY] == 'P') {
            this.playerBoard[coordX][coordY] = '#';
            return true;
        }
        return false;
    }

    private boolean isIncorrect(int coordX, int coordY) {
        char x = (char) coordX;
        char y = (char) coordY;

        if (Character.isLetter(x) || Character.isLetter(y) || coordX > size || coordY > size || coordX < 0 || coordY < 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cpuAttack() {
        int ranIntX = random.nextInt(7);
        int ranIntY = random.nextInt(7);
        boolean isAcceptable = false;

        do {
            if (!isIncorrect(ranIntX, ranIntY) || !isAlreadyAttacked(this.playerBoard, ranIntX, ranIntY)) {
                if (isPlayerHit(ranIntX, ranIntY)) {
                    isAcceptable = true;
                }
            }
        } while (!isAcceptable);

        if (isAcceptable) {
            return true;
        }
        return false;
    }

    public boolean playerAttack(int coordX, int coordY) {
        if (!isIncorrect(coordX, coordY) || !isAlreadyAttacked(this.cpuBoard, coordX, coordY)) {
            if (isCpuHit(coordX, coordY)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAlreadyAttacked(char[][] array, int coordX, int coordY) {
        if (array[coordX][coordY] == '#') {
            return true;
        }
        return false;
    }

    public boolean isWonByPlayer() {
        String cpuBoard = this.cpuBoard.toString();

        if (cpuBoard.indexOf('C') == -1) {
            return true;
        }

        return false;
    }
}
