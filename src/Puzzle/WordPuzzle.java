package Puzzle;

/**
 * Created by jc302404 on 20/04/2015.
 */
public class WordPuzzle {
    private int size;
    private char[][] puzzleletters;// creating array of puzzle letters

    public WordPuzzle(int size, char[][] puzzleLetters) {
        this.size = size;
        this.puzzleletters = puzzleLetters;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public char getLetter(int row, int column){// returns a letter in the position
        return puzzleletters[row][column];
    }

    public String getWordAtRow(int position){//returns the word from the puzzle
        return String.valueOf(puzzleletters[position]);
    }

    public String getWordAtColumn(int column){
        StringBuilder Word = new StringBuilder();
        for(int rowIndex = 0; rowIndex < puzzleletters.length; rowIndex++){
            Word.append(puzzleletters[rowIndex][column]);
        }
        return Word.toString();




    }

    public String toString() {
        StringBuilder words = new StringBuilder();
        if(puzzleletters == null){
            words.append("Word puzzle empty!");
        }
        else {

            words.append("(");
            for (int WordIndex = 0; WordIndex < puzzleletters.length; WordIndex++) {
                words.append(getWordAtRow(WordIndex));
                words.append(" ");

            }
            words.append(")(");
            for (int WordIndex = 0; WordIndex < puzzleletters.length; WordIndex++) {

                words.append(getWordAtColumn(WordIndex));
                words.append(" ");
            }
            words.append(")");

        }
        return words.toString();
    }
}
