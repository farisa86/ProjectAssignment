package Game;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSlider;

import Puzzle.WordPuzzle;
import Puzzle.WordPuzzleGenerator;

/**
 * Created by jc302404 on 20/04/2015.
 */
public class App {
	
	private WordPuzzle puzzle;//defining a puzzle
    private WordPuzzleGenerator generator = new WordPuzzleGenerator(3);
	
    public static void main(String[] args) {
    	App app = new App();//creating an object of App
    	app.run();
    }
    
    public void run(){
        final MainFrame frame = new MainFrame();
        puzzle = generator.createWordPuzzle();
        frame.puzzlePanel.createButtons(3, puzzle);
        
        
        frame.addResizeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JDialog resizeDialog = new JDialog(); //create resize window
                resizeDialog.setLocationRelativeTo(null);
                resizeDialog.setLayout(new FlowLayout()); //set layout of resize window
                final JSlider sliderBar = new JSlider(3, 5); // create slider bar -> 3 is min, 5 is max
                sliderBar.setMinorTickSpacing(1);
                sliderBar.setLabelTable(sliderBar.createStandardLabels(1));
                sliderBar.setPaintTicks(true);
                sliderBar.setPaintLabels(true);
                JButton confirmButton = new JButton("OK"); // create 'ok' button
                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        generator.setSize(sliderBar.getValue());
                        puzzle = generator.createWordPuzzle();
                    	frame.puzzlePanel.createButtons(sliderBar.getValue(), puzzle);
                        resizeDialog.dispose(); //dispose of resize window when user presses 'ok'

                    }
                });
                resizeDialog.add(sliderBar); // add slider bar to resize window
                resizeDialog.add(confirmButton);// add slider bar to resize window
                resizeDialog.pack();
                resizeDialog.setVisible(true);// set resize window visible
            }
        });
        
        frame.addExitListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        frame.addHintListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(frame.puzzlePanel.isWinState()){
            		return;
            	}
            		
            	Random rand = new Random();
            	int column, row;
            	PuzzleButton button; 
            	do{
	            	column = rand.nextInt(frame.puzzlePanel.getCurrentSize());
	            	row = rand.nextInt(frame.puzzlePanel.getCurrentSize());
	            	button = frame.puzzlePanel.buttonGrid[row][column];
	            	
            	} while(button.guessed);
            	
            	button.reveal();
            }
        });
        
        frame.addPlayListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.puzzlePanel.createButtons(frame.puzzlePanel.currentSize, puzzle);
                frame.hintBar.setText(" ");
            }
        });
        
        frame.addHelpListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                String word = puzzle.getWordAtRow(rand.nextInt(frame.puzzlePanel.currentSize));
                frame.hintBar.setText("One of the words is: " + word);
            }
        });
        
        frame.setValidSizeAndSetVisible();
        
    }
    
    

}
