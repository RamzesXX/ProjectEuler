package com.khanchych.sandbox.t1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Decryption {
    static char[] god = {'g', 'o', 'd'};

    public static Integer[] readFile(String fileName) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(NameScores.class.getClassLoader().getResourceAsStream(fileName)));

        return reader
                .lines()
                .flatMap(line -> Arrays.stream(line.split(",")))
                .map(Integer::valueOf)
//                .map(e -> e ^ 'g')
                .toArray(Integer[]::new);
    }

    public static Character[] uncrypt(Integer[] crypted) {
        Character[] uncrypted = new Character[crypted.length];

        for (int i = 0; i < crypted.length; i++) {
            uncrypted[i] = (char) (crypted[i] ^ god[i%3]);
        }

        return uncrypted;
    }

    public static  Map<Integer, Map<Integer, Integer>> stat(Integer[] crText) {
        Map<Integer, Map<Integer, Integer>> stat = new HashMap<>();
        stat.put(0, new HashMap<>());
        stat.put(1, new HashMap<>());
        stat.put(2, new HashMap<>());

        for (int i = 0; i < crText.length; i++) {
            Map<Integer, Integer> map = stat.get(i % 3);
            if (map.get(crText[i]) == null) {
                map.put(crText[i], 0);
            }
            map.put(crText[i], map.get(crText[i]) + 1);
        }

        return stat;
    }

    public static void main(String[] args) {
        Integer[] cryptedText = readFile("p059_cipher.txt");
        long sum= 0;

        System.out.println(Arrays.stream(uncrypt(cryptedText)).mapToInt(value -> (int)value).sum());
    }
}
