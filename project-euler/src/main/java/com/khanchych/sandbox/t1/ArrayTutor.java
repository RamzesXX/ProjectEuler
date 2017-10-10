package com.khanchych.sandbox.t1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ArrayTutor {
    Function<String, String> fn = new Function<String, String>() {
        @Override
        public String apply(String s) {
            return s+"0";
        }
    };

    public static void main(String args[]) {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
        Collections.shuffle(list);
        Collections.sort(list, Comparator.reverseOrder());

        System.out.println(list.toString());
    }
}
