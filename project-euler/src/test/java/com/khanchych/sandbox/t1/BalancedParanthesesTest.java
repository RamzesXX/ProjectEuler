package com.khanchych.sandbox.t1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedParanthesesTest {
    private BalancedParantheses checker;
    @Before
    public void setUp() {
        checker = new BalancedParantheses();
    }

    @Test
    public void isBalanced() throws Exception {
        assertTrue(checker.isBalanced("[({})]"));
        assertTrue(checker.isBalanced("{}([])"));
        assertTrue(checker.isBalanced("{()}[jhhjgjgjhgjkg[{}]]"));
        assertFalse(checker.isBalanced("{{)()}}"));
        assertFalse(checker.isBalanced("({)} is not balanced because ) is not balanced between {}"));
    }

}