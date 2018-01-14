package com.khanchych.sandbox.algorithmic.projecteuler;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberSpiralDiagonalsTest {
    private NumberSpiralDiagonals numberSpiralDiagonals;

    @Before
    public void setUp() {
        this.numberSpiralDiagonals = new NumberSpiralDiagonals();
    }

    @Test
    public void calc1() {
        assertEquals(1, numberSpiralDiagonals.calc(1));
    }
    @Test
    public void calc3() {
        assertEquals(25, numberSpiralDiagonals.calc(3));
    }
    @Test
    public void calc5() {
        assertEquals(101, numberSpiralDiagonals.calc(5));
    }
}