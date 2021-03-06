package com.khanchych.sandbox.osgi.osgi1;

public interface DictionaryService
{
    /**
     * Check for the existence of a word.
     * @param word the word to be checked.
     * @return true if the word is in the dictionary,
     *         false otherwise.
     **/
    public boolean checkWord(String word);
}