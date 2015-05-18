package Game;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jc302404 on 5/05/15.
 */
public class PuzzleButton extends JTextField implements DocumentListener{

    boolean guessed;
    char letter;
    PuzzlePanel panel;

    public PuzzleButton(char letter, PuzzlePanel panel){
    	super();
        guessed = false;
        this.letter = letter;
        this.panel = panel;
		setHorizontalAlignment(JTextField.CENTER);
        getDocument().addDocumentListener(this);
    }

	@Override
	public void insertUpdate(DocumentEvent e) {
		if(guessed){
			panel.hintBar.setText(" ");
			if(getText() != null){
				if(this.getText().charAt(0) == letter){
					setHasBeenGuessed();
				}
			}
				
	        panel.hintBar.setText(" ");
	
	
		}
		
	}
	
	public void reveal(){
		this.setText(Character.toString(letter));
		setHasBeenGuessed();
	}
	
	public void setHasBeenGuessed(){
		System.out.println("guessed");
		guessed = true;
		setFocusable(false);
        if(panel.isWinState()){
            panel.hintBar.setText("You Won");

        }
	}
	
	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
