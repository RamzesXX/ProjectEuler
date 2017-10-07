package com.khanchych.sandbox.algorithmic.projecteuler;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberSpiralDiagonalsTest {
    private NumberSpiralDiagonals numberSpiralDiagonals;

    @Before
    public void setUp() throws Exception {
        this.numberSpiralDiagonals = new NumberSpiralDiagonals();
    }

    @Test
    public void calc1() throws Exception {
        assertEquals(1, numberSpiralDiagonals.calc(1));
    }
    @Test
    public void calc3() throws Exception {
        assertEquals(25, numberSpiralDiagonals.calc(3));
    }
    @Test
    public void calc5() throws Exception {
        assertEquals(101, numberSpiralDiagonals.calc(5));
    }
}