package com.company;

public class Dictionary {
    private WordInfo[] words = new WordInfo[1500];
    private int size = 0;

    public boolean add(String word, String meaning) {
        // Check if the word already exists in the dictionary
        // Calls the exists function
        if (exists(word)) {
            return false;
        }

        // Check if the array is already full
        if (size == words.length) {
            return false;
        }
        if (!word.matches("[a-zA-Z ]+") || !meaning.matches("[a-zA-Z ]+")) {
            return false;
        }


        // Add the new word to the dictionary
        WordInfo newWord = new WordInfo(word, meaning);
        words[size] = newWord;
        size++;
        return true;
        }
    public boolean exists(String word) {
        // Check if the word exists in the dictionary
        for (int i = 0; i < size; i++) {
            if (words[i].getWord().equals(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    public boolean delete(String word) {
        // Find the word in the dictionary
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (words[i].getWord().equals(word.toLowerCase())) {
                index = i;
                break;
            }
        }

        // If the word was not found, return false
        if (index == -1) {
            return false;
        }

        // Shift all elements after the deleted word back by one index
        for (int i = index; i < size - 1; i++) {
            words[i] = words[i+1];
        }
        words[size-1] = null;
        size--;
        return true;
    }
    public void getMeaning(String word) {
        // Find the meaning of the word
        String meaning = null;
        for (int i = 0; i < size; i++) {
            if (words[i].getWord().equalsIgnoreCase(word)) {
                meaning = words[i].getMeaning();
                break;
            }
        }

        // If the word isn't found, show an appropriate message
        if (meaning == null) {
            System.out.println("Sorry, the word " + word + " is not in the dictionary.");
        }
        // If the word is found, shows the word and meaning
        else {
            System.out.println("The meaning of " + word + " is: " + meaning);
        }
    }
    public int getCount() {
        // Return the number of words currently in the dictionary
        return size;
    }
    public String printWordList() {
        // Sort the words array in ascending order by word
        for (int i = 1; i < size; i++) {
            WordInfo temp = words[i];
            int j = i - 1;
            while (j >= 0 && words[j].getWord().compareToIgnoreCase(temp.getWord()) > 0) {
                words[j + 1] = words[j];
                j--;
            }
            words[j + 1] = temp;
        }

        // Concatenate all the words into a single string
        String result = "";
        for (int i = 0; i < size; i++) {
            result += words[i].getWord() + "\n";
        }
        return result;
    }

    public void printDictionary() {
        // Sort the words array in ascending order by word
        for (int i = 1; i < size; i++) {
            WordInfo temp = words[i];
            int j = i - 1;
            while (j >= 0 && words[j].getWord().compareToIgnoreCase(temp.getWord()) > 0) {
                words[j + 1] = words[j];
                j--;
            }
            words[j + 1] = temp;
        }

        // Print the word and meaning for each WordInfo word
        for (int i = 0; i < size; i++) {
            System.out.println(words[i].getWord() + ": " + words[i].getMeaning());
        }
    }

}

