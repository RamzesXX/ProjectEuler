package com.khanchych.sandbox.t1;

import java.util.Scanner;

public class Task11_LargestProductInAGrid {

    private final int size = 20;
    private int[][] playField;

    private int[][] readDataFromFile(String filename) {
        int index;
        Scanner scanner = new Scanner(
                this.getClass().getClassLoader().getResourceAsStream(filename));

        index = 0;
        playField = new int[size][size];
        while (scanner.hasNext()) {
            playField[index / size][index % size] = scanner.nextInt();
            index++;
        }

        return playField;
    }

    private int check(int x, int y) {
        int max = 0;

        if (y > 2) {
            max = Math.max(max,playField[x][y] * playField[x][y - 1] * playField[x][y - 2] * playField[x][y - 3]);
        }

        if (y > 2 && x < size - 3) {
            max = Math.max(max,playField[x][y] * playField[x+1][y - 1] * playField[x+2][y - 2] * playField[x+3][y - 3]);
        }

        if (x < size - 3) {
            max = Math.max(max,
                    playField[x][y] * playField[x+1][y] * playField[x+2][y] * playField[x+3][y]);
        }

        if (y < size - 3 && x < size - 3) {
            max = Math.max(max, playField[x][y] * playField[x+1][y + 1] * playField[x+2][y + 2] * playField[x+3][y + 3]);
        }


        if (y < size - 3 ) {
            max = Math.max(max, playField[x][y] * playField[x][y + 1] * playField[x][y + 2] * playField[x][y + 3]);
        }

        if (y < size - 3 && x > 2) {
            max = Math.max(max, playField[x][y] * playField[x-1][y + 1] * playField[x-2][y + 2] * playField[x-3][y + 3]);
        }

        if (x > 2) {
            max = Math.max(max, playField[x][y] * playField[x-1][y] * playField[x-2][y] * playField[x-3][y]);
        }


        if (y > 2 && x >2) {
            max = Math.max(max,playField[x][y] * playField[x-1][y - 1] * playField[x-2][y - 2] * playField[x-3][y - 3]);
        }
        
        return max;
    }

    public int calc(String filename) {
        int max = 0;

        readDataFromFile(filename);
        for (int i = 0; i <size; i++) {
            for (int j = 0; j < size; j++) {
                max = Math.max(max, check(i, j));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Task11_LargestProductInAGrid().calc("p011_numbers.txt"));
    }
}
