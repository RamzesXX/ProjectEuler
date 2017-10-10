package com.khanchych.sandbox.t1;

import java.util.Stack;

public class BalancedParantheses {
    private final String OPEN_BRACKETS = "{([";
    private final String CLOSE_BRACKETS = "})]";
    private Stack<Character> stack = new Stack<>();

    public boolean isBalanced(String string) {
        stack.clear();

        for(Character character: string.toCharArray()) {
            if (!add(character)){
                return false;
            }
        }

        return true;
    }

    private boolean add(Character character) {

        if (OPEN_BRACKETS.indexOf(character) != -1) {
            return stack.add(character);
        }
        else if (CLOSE_BRACKETS.indexOf(character) == -1) {
            return true;
        }
        else if (stack.isEmpty()) {
            return false;
        }

        return CLOSE_BRACKETS.indexOf(character) == OPEN_BRACKETS.indexOf(stack.pop());
    }
}
