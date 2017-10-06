package com.khanchych.sandbox.algorithmic.catanddoors;

import java.util.Random;

public class CatAndDoors {
    private final int doors;
    private final Random random;
    private int catPosition;
    private int attemptCount;
    private boolean gameFinished;

    public CatAndDoors(int doors) {
        this.doors = doors;
        this.random = new Random();
        init();
    }

    public void init() {
        this.catPosition = random.nextInt(doors) + 1;
        this.attemptCount = 0;
        this.gameFinished = false;
    }

    public int getDoors() {
        return doors;
    }

    protected int getCatPosition() {
        return catPosition;
    }

    protected int moveCat() {
        if (catPosition == 1) {
            catPosition++;
        } else if (catPosition == doors) {
            catPosition--;
        } else {
            catPosition += random.nextInt(2) * 2 - 1;
        }

        return catPosition;
    }

    public boolean check(int consideredCatPosition) throws Exception {
        if (gameFinished) {
            throw new Exception("The game was already finished");
        }
        attemptCount++;
        if (consideredCatPosition == catPosition) {
            gameFinished = true;
            return true;
        }

        moveCat();

        return false;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }
}
