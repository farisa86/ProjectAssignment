package Puzzle;

import java.io.File;
import java.util.*;

/**
 * Created by jc302404 on 20/04/2015.
 */
public class WordPuzzleGenerator {

    private ArrayList<String> words;//defines an array
    private HashSet<String> hashWords;//defines an array
    private int size = 3;

    public WordPuzzleGenerator(int size) {
        setSize(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;

        updateWords();
    }

    private void updateWords() {
        words = new ArrayList<String>();//creates an array of strings
        hashWords = new HashSet<String>();

        try {
            Scanner wordscanner = new Scanner(new File("wordList.txt"));//reads the wordlist text file

            while (wordscanner.hasNext()) {
                String word = wordscanner.nextLine(); //load in words
                words.add(word);
                hashWords.add(word);

            }
        } catch (Exception e) {

            System.out.println("file is not found");//if the file is not found
        }
    }

    public WordPuzzle createWordPuzzle() {
        char[][] result = new char[size][size];// craeting an empty word puzzle

        String[] testWords = new String[size];// creating storage for possible words

        Random randomGenerator = new Random();// creating an object random

        do {

            for (int i = 0; i < testWords.length; i++) {//grabs enough words for the puzzle
                do {

                    testWords[i] = words.get(randomGenerator.nextInt(words.size())); //run through words randomly
                } while (testWords[i].length() != size); //make sure they're the right size
            }

        } while (!checkValidWords(testWords)); // check if the words are valid

        for (int wordIndex = 0;
             wordIndex < testWords.length;//loops through the words
             wordIndex++) {
            result[wordIndex] = testWords[wordIndex].toCharArray(); //turns string into char array
        }

        return new WordPuzzle(size, result);
    }


    public boolean checkValidWords(String[] testwords) { //checking if the word is valid
        StringBuilder stringBuilder; //use string builder for constructing the word
        for (int row = 0; row < testwords.length; row++) { // run through the horizontal words
            stringBuilder = new StringBuilder(); //clear string builder each word
            for (int column = 0; column < testwords.length; column++) { //grab first letter in column
                stringBuilder.append(testwords[column].charAt(row));  // append letter
            }
            if (!hashWords.contains(stringBuilder.toString())) { //word isn't in word list
                return false;
            }
        }

        return true;
    }

    public String toString() {
        return "Generator stats : word-puzzles generated from " + getNumberOfWords(size) + " words of length " + size ;
    }

    public int getNumberOfWords(int size) {
        int numberOfWords = 0;
        for (String word : words) {
            if (word.length() == size) {
                numberOfWords++;
            }

        }
            return numberOfWords;

    }

}

