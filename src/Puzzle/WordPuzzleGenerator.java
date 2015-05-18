package Puzzle;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by jc302404 on 20/04/2015.
 */
public class WordPuzzleGenerator {

    public ArrayList<String> words;

    public WordPuzzleGenerator() {
        words = new ArrayList<String>();

        try {
            Scanner wordscanner = new Scanner(new File("wordList.txt"));

            while (wordscanner.hasNext()) {
            	String word = wordscanner.nextLine(); //load in words
                words.add(word);

            }
        } catch (Exception e) {

            System.out.println("file is not found");
        }

    }

    public char[][] createWordPuzzle(int size) {
        char[][] result = new char[size][size];

        String[] testWords = new String[size];

        Random randomGenerator = new Random();

        do {

            for (int i = 0; i < testWords.length; i++) {
                do {

                    testWords[i] = words.get(randomGenerator.nextInt(words.size())); //run through words randomly
                } while (testWords[i].length() != size); //make sure they're the right size
            }

        } while (!checkValidWords(testWords)); // check if the words are valid

        for (int wordIndex = 0;
             wordIndex < testWords.length;
             wordIndex++){
            result[wordIndex] = testWords[wordIndex].toCharArray(); //return the puzzle
        }

        return result;
    }


    public boolean checkValidWords(String[] testwords) { //checking if the word is valid
        StringBuilder stringBuilder; //use string builder for constructing the word
        for (int row =0; row < testwords.length;row ++){ // run through the horizontal words
            stringBuilder = new StringBuilder(); //clear string builder each word
            for (int column = 0; column<testwords.length; column++){ //grab first letter in column
                stringBuilder.append(testwords[column].charAt(row));  // append letter
            }
            if (!words.contains(stringBuilder.toString())){ //word isn't in word list
                return false;
            }
        }

        return true;
    }
}

