package Game;

import Puzzle.WordPuzzle;

import javax.swing.*;

import java.awt.*;

/**
 * Created by jc302404 on 5/05/15.
 */
public class PuzzlePanel extends JPanel{

    PuzzleButton[][] buttonGrid;
    JLabel hintBar;
    int currentSize;

    public PuzzlePanel(MainFrame frame){
        super();
        hintBar = frame.hintBar;
        this.setPreferredSize(new Dimension(300, 300));
 
    }
    
    public void createButtons(int size, WordPuzzle puzzle) {
    	int currentSize = getCurrentSize();
    	
        for (int row = 0; row < currentSize; row++) {
            for (int column = 0; column < currentSize; column++) {
               remove(buttonGrid[row][column]); //remove buttons that are already there
            }
        }

        buttonGrid = new PuzzleButton[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                buttonGrid[row][column] = new PuzzleButton(puzzle.getLetter(row, column), this); //create new buttons
                add(buttonGrid[row][column]);//add buttons to panel
            }
        }
        setLayout(new GridLayout(size, size));
        setCurrentSize(size);
        validate();
        repaint();
    }
    
    public void setCurrentSize(int size){
    	currentSize = size;
    }

    public int getCurrentSize(){
    	return currentSize;
    }
    
    public boolean isWinState(){
        boolean result = true;
        for(PuzzleButton[] buttonRow : buttonGrid) {
            for(PuzzleButton button : buttonRow) {
                if(!button.guessed) return false;
            }
        }
        return result;
    }
    
    

}
