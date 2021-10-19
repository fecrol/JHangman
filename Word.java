package com.hangman;

public class Word {

    private String word;
    private char[] lettersInWord;

    public Word(String word) {
        this.word = word;
    }

    public void splitWordToLetters() {
        /*
        Splits the word into letters for comparison against letter clicked on keyboard
         */

        this.lettersInWord = this.word.toCharArray();
    }

    public char[] getLettersInWord() {
        return this.lettersInWord;
    }

    public String getWord() {
        return this.word;
    }
}
