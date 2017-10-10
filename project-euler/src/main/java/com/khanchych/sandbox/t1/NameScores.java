package com.khanchych.sandbox.t1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NameScores {
    public static int textScore(String text) {
        int score = 0;

        for (char a : text.toLowerCase().toCharArray()) {
            score += (a - 'a' + 1);
        }
        return score;
    }

    public static String[] readFile(String fileName) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(NameScores.class.getClassLoader().getResourceAsStream(fileName)));

        return reader.lines()
                .flatMap(line -> Arrays.stream(line.split(",")))
                .sorted()
                .map(element->element.trim())
                .map(element->element.substring(1,element.length()-1))
                .collect(Collectors.toList()).toArray(new String[0]);
    }

    public static void main(String[] args) {
        Long accumulator = 0l;
        String[] names = readFile("p022_names.txt");
        for (int i = 0; i < names.length; i++) {
            accumulator += (i+1) * textScore(names[i]);
        }
        System.out.println(accumulator);
    }
}
