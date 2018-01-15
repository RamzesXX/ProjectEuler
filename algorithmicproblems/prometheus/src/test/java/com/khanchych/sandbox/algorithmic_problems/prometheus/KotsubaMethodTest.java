package com.khanchych.sandbox.algorithmic_problems.prometheus;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KotsubaMethodTest {

    private KotsubaMethod kotsubaMethod;

    @Before
    public void setUp() throws Exception {
        kotsubaMethod = new KotsubaMethod();
    }

    @Test
    public void mul() {
        String first = "11";
        String second = "12";
        String result = "132";

        assertEquals(result, kotsubaMethod.mul(first, second));
    }

    @Test
    public void add() {
        String first = "11";
        String second = "12";
        String result = "23";

        assertEquals(result, kotsubaMethod.add(first, second));
    }
    @Test
    public void addWithOverflow() {
        String first = "55";
        String second = "65";
        String result = "120";

        assertEquals(result, kotsubaMethod.add(first, second));
    }
    @Test
    public void addDifferentLength() {
        String first = "5555";
        String second = "65";
        String result = "5620";

        assertEquals(result, kotsubaMethod.add(first, second));
    }
}