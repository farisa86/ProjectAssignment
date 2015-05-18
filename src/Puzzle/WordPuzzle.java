package Puzzle;

/**
 * Created by jc302404 on 20/04/2015.
 */
public class WordPuzzle {
    public char[][] puzzleletters;
    WordPuzzleGenerator generator;

    public WordPuzzle(int size) {
        puzzleletters = new char[size][size];
        generator = new WordPuzzleGenerator();
    }

    public char getLetter(int row, int column){
        return puzzleletters[row][column];
    }

    public void createNewWordPuzzle(int size){
        puzzleletters = generator.createWordPuzzle(size);
    }

    public String getWord(int position){
        return String.valueOf(puzzleletters[position]);
    }
}
