package com.khanchych.sandbox.algorithmic_problems.prometheus;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KotsubaMethodTest {

    private KotsubaMethod kotsubaMethod;

    @Before
    public void setUp() throws Exception {
        kotsubaMethod = new KotsubaMethod("");
    }

    @Test
    public void mul() {
        String first = "11";
        String second = "12";
        String result = "132";

        assertEquals(result, kotsubaMethod.mul(first, second));
    }

    @Test
    public void mul3() {
        String first = "216";
        String second = "133";
        String result = "28728";

        assertEquals(result, kotsubaMethod.mul(first, second));
    }

    @Test
    public void mul_1234_5678() {
        String first = "1234";
        String second = "5678";
        int result = 1;
        kotsubaMethod = new KotsubaMethod("3");
        kotsubaMethod.mul(first, second);
        assertEquals(result, kotsubaMethod.getCount());
    }

    @Test
    public void mulBig() {
        String first = "21625695688898558125310188636840316594920403182768";
        String second = "13306827740879180856696800391510469038934180115260";
        String result = "287769407308846640970310151509826255482575362419155842891311909556878670000425352112987881085839680";

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

    @Test
    public void sub() {
        String first = "15";
        String second = "12";
        String result = "3";

        assertEquals(result, kotsubaMethod.sub(first, second));
    }

    @Test
    public void subWithOverflow() {
        String first = "55";
        String second = "65";
        String result = "-10";

        assertEquals(result, kotsubaMethod.sub(first, second));
    }

    @Test
    public void subDifferentLength() {
        String first = "5555";
        String second = "65";
        String result = "5490";

        assertEquals(result, kotsubaMethod.sub(first, second));
    }
}