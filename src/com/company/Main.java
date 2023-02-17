package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Dictionary dict = new Dictionary();

        // Words and meanings stored in the dictionary already
        dict.add("Jouissance","Enjoyment");
        dict.add("Verse","Particular realm or environment");
        dict.add("Boar","An uncastrated domestic male pig");
        dict.add("Blue","Blue color or pigment");
        dict.add("Apple","The round fruit of a tree of the rose family");
        dict.add("Bee","A honeybee");
        dict.add("Sea Horse","A mythical creature with a horse's head and fish's tail");
        dict.add("Sunflower","A tall North American plant of the daisy family");

        // Menu
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 6) {
            System.out.println("1. Add new word");
            System.out.println("2. Delete word");
            System.out.println("3. Get meaning");
            System.out.println("4. Dictionary list");
            System.out.println("5. Spell check a text file.");
            System.out.println("6. Exit");

            System.out.println("Enter option:");
            choice = scanner.nextInt();
            // Cases depending on users option input
            switch (choice) {
                // Add the word
                case 1:
                    System.out.println("\nYou chose option 1");
                    System.out.println("Enter the word you want to add:");
                    // Input only accepts letters and spaces
                    String newWord = input.nextLine();
                    while (!newWord.matches("[a-zA-Z ]+")) {
                        System.out.println("Invalid input. Please enter only letters and spaces.");
                        newWord = input.nextLine();
                    }

                    System.out.println("Enter the meaning of the word:");
                    // Input accepts letters and spaces
                    String meaning = input.nextLine();
                    while (!meaning.matches("[a-zA-Z ]+")) {
                        System.out.println("Invalid input. Please enter only letters and spaces.");
                        meaning = input.nextLine();
                    }
                        // Adds the words to the dictionary
                    if (dict.add(newWord, meaning)) {
                        System.out.println("The word has been added to the dictionary.");
                    }
                    // Outputs if the words exists in the dictionary or the dictionary is full
                    else {
                        System.out.println("The word already exists in the dictionary or the dictionary is full.");
                    }
                    break;
                // Deletes a word if found
                case 2:
                    System.out.println("You chose option 2");
                    // Input only accepts letters and spaces
                    System.out.println("Enter the word you want to delete:");
                    String deleteWord = input.nextLine();
                    while (!deleteWord.matches("[a-zA-Z ]+")){
                        System.out.println("Invalid input. Please enter only letters and spaces.");
                        deleteWord = input.nextLine();
                    }
                    if (dict.delete(deleteWord)) {
                        System.out.println("The word has been deleted from the dictionary.");
                    } else {
                        System.out.println("The word was not found in the dictionary.");
                    }
                    break;
                // Gets the meaning of a word
                case 3:
                    System.out.println("You chose option 3");
                    System.out.println("Enter the word you want to get the meaning of:");
                    String word = input.nextLine();
                    while (!word.matches("[a-zA-Z ]+")){
                        System.out.println("Invalid input. Please enter only letters and spaces.");
                        word = input.nextLine();
                    }
                    dict.getMeaning(word);
                    break;
                // Prints all the words in the dictionary
                case 4:
                    System.out.println("You chose option 4");
                    System.out.println("The words in the dictionary are:");
                    System.out.println(dict.printWordList());
                    break;
                case 5:
                    System.out.println("You chose option 5");
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }
        scanner.close();
    }
}
