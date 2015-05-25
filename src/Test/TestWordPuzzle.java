package Test;

import Puzzle.WordPuzzle;

/**
 * Created by jc302404 on 25/05/15.
 */
public class TestWordPuzzle {
    public static void main(String[] args) {
        char letterArray3[][] = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};

        WordPuzzle puzzle = new WordPuzzle(3, letterArray3);
        System.out.println("Test1:3x3 puzzle with words abc def ghi");
        System.out.print("Expected: (abc def ghi) (adg beh cfi)\n");
        System.out.print("Actual: ");
        System.out.println(puzzle.toString());

        char letterArray4[][] = {{'a', 'b', 'c', 'd'}, {'e', 'f', 'g', 'h'}, {'i', 'j', 'k', 'l'}, {'m', 'n', 'o', 'p'}};

        puzzle = new WordPuzzle(4, letterArray4);
        System.out.println("Test1:4x4 puzzle with words abcd efgh ijkl, mnop");
        System.out.print("Expected: (abcd efgh ijkl mnop) (aeim bfjn cgko dhlp)\n");
        System.out.print("Actual: ");
        System.out.println(puzzle.toString());

        puzzle = new WordPuzzle(3, null);
        System.out.print("Expected: Word Puzzle Empty!\n");
        System.out.print("Actual: ");
        System.out.println(puzzle.toString());
    }
}
