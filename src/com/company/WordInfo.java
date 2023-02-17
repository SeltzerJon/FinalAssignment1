package com.company;

public class WordInfo {
    private String word;
    private String meaning;

    public WordInfo(String word, String meaning) {
        this.word = word.toLowerCase(); // store the word in lowercase
        this.meaning = meaning;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public String toString() {
        return "WordInfo{" +
                "word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }
}
