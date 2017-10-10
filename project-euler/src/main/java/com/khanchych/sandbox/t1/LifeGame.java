package com.khanchych.sandbox.t1;

public class LifeGame {
    private final int size;

    public LifeGame(int size) {
        this.size = size;
    }

    private boolean check(boolean[][] field, int x, int y) {
        int neighbours = 0;

        if (x > 0) {
            if (y > 0 && field[x - 1][y - 1]) neighbours++;
            if (field[x - 1][y]) neighbours++;
            if (y < size - 1 && field[x - 1][y + 1]) neighbours++;
        }

        if (x < size - 1) {
            if (y > 0 && field[x + 1][y - 1]) neighbours++;
            if (field[x + 1][y]) neighbours++;
            if (y < size - 1 && field[x + 1][y + 1]) neighbours++;
        }

        if (y > 0 && field[x][y - 1]) neighbours++;
        if (y < size - 1 && field[x][y + 1]) neighbours++;

        return (neighbours == 2 && field[x][y]) || (neighbours == 3);
    }

    public boolean[][] nextGeneration(boolean[][] field) {
        boolean[][] next = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                next[i][j] = check(field, i, j);
            }
        }

        return next;
    }

    public void print(boolean[][] field) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(field[i][j] ? "*" : ".");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean[][] field = {
                {true, true, true, true, true},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        LifeGame game = new LifeGame(5);

        game.print(field);
        field = game.nextGeneration(field);
        game.print(field);
        field = game.nextGeneration(field);
        game.print(field);
        field = game.nextGeneration(field);
        game.print(field);
        field = game.nextGeneration(field);
        game.print(field);
    }
}
