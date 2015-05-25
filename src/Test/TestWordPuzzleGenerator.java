package Test;

import Puzzle.WordPuzzle;
import Puzzle.WordPuzzleGenerator;

/**
 * Created by jc302404 on 25/05/15.
 */
public class TestWordPuzzleGenerator {

    public static void main(String[] args) {
        WordPuzzleGenerator generator = new WordPuzzleGenerator(3);

        System.out.println(generator.toString());
        for(int i = 0; i < 10; i++){
            WordPuzzle puzzle = generator.createWordPuzzle();
            System.out.println(puzzle.toString());
        }
         generator = new WordPuzzleGenerator(4);
        System.out.println(generator.toString());

        for(int i = 0; i < 10; i++){
            WordPuzzle puzzle = generator.createWordPuzzle();
            System.out.println(puzzle.toString());
        }
    }
}
