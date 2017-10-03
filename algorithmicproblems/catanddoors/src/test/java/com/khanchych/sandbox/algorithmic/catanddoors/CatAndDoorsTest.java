package com.khanchych.sandbox.algorithmic.catanddoors;

import org.junit.*;

import static org.junit.Assert.*;

public class CatAndDoorsTest {
    private CatAndDoors game;

    @Before
    public void setUp() throws Exception {
        game = new CatAndDoors(7);
    }

    @Test
    public void catChangesPositionAfterEachCheck() throws Exception {
        int prevCatPosition = game.getCatPosition();

        game.check(game.getCatPosition() + 1);
        assertNotEquals(prevCatPosition, game.getCatPosition());
    }

    @Test
    public void checkPositionReturnsTrueForCatPosition() throws Exception {
        assertTrue(game.check(game.getCatPosition()));
    }

    @Test
    public void checkPositionReturnsTrueForWrongCatPosition() throws Exception {
        assertFalse(game.check(game.getCatPosition() + 1));
    }

    @Test
    public void initialAttemptCountIsZero() {
        assertEquals(0, game.getAttemptCount());
    }

    @Test
    public void attemptCountIsIncrementedAfterEachRound() throws Exception {
        game.check(game.getCatPosition() + 1);
        assertEquals(1, game.getAttemptCount());
    }

    @Test
    public void initiallyGameIsNotFinished() {
        assertFalse(game.isGameFinished());
    }

    @Test
    public void gameFinishedAfterGuessingCatPosition() throws Exception {
        game.check(game.getCatPosition());
        assertTrue(game.isGameFinished());
    }


}