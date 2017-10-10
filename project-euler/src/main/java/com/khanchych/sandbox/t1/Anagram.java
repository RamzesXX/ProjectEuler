package com.khanchych.sandbox.t1;

import java.util.HashSet;
import java.util.Set;

public class Anagram {
    private final String word;
    private final StringBuilder builder;

    public Anagram(String word) {
        this.word = word;
        this.builder = new StringBuilder(word.length());
    }

    public Set<String> makeAnagrams() {
        Set<String> anagrams = new HashSet<>();

        makeAnagrams(anagrams, word, 0);

        return anagrams;
    }

    private void makeAnagrams(Set<String> anagrams, String subword, int index) {
        anagrams.add(subword);
        if (index < word.length() - 1) {
            makeAnagrams(anagrams, subword, index + 1);
        }

        for (int i = index + 1; i < word.length(); i++) {
            String tmp = makeChild(subword, index, i);
            anagrams.add(tmp);
            makeAnagrams(anagrams, tmp, index + 1);
        }
    }


    private String makeChild(String word, int pos1, int pos2) {
        char tmp;

        builder.setLength(0);
        builder.append(word);
        tmp = builder.charAt(pos1);
        builder.setCharAt(pos1, builder.charAt(pos2));
        builder.setCharAt(pos2, tmp);

        return builder.toString();
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram("123456789");
        System.out.println(anagram.makeAnagrams().size());
    }
}
