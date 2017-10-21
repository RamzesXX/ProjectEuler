package com.khanchych.sandbox.gradle_t1;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageServiceTest {

    @Test
    public void getMsgTest() {
        assertEquals("Hello from Service!", new MessageService().getMsg());
    }
}