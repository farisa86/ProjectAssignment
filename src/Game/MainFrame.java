package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by jc302404 on 5/05/15.
 */
public class MainFrame extends JFrame{

    JLabel hintBar;
    public final PuzzlePanel puzzlePanel;
    JMenuItem resize;
    JMenuItem exit;
    final JMenuItem hint;
    JMenuItem play;
    JMenuItem help;
    

    public MainFrame(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        hintBar = new JLabel(" ");
        this.add(hintBar, BorderLayout.SOUTH);
        this.puzzlePanel = new PuzzlePanel(this);
        add(puzzlePanel);

        JMenuBar menuBar = new JMenuBar(); //created menu bar

        JMenu settingsMenu = new JMenu("Settings"); // add settings menu
        menuBar.add(settingsMenu); //added settings menu to

        resize = new JMenuItem("Resize");
        settingsMenu.add(resize);
        
        exit = new JMenuItem("Exit");
        settingsMenu.add(exit);


        JMenu gameMenu = new JMenu("Game"); // add game menu
        menuBar.add(gameMenu); //added game menu to

        hint = new JMenuItem("Hint");
        gameMenu.add(hint);
        
        play = new JMenuItem("Play");
        
        gameMenu.add(play);
        help = new JMenuItem("Help");
       
        gameMenu.add(help);

        setJMenuBar(menuBar); //set menu bar on frame
        
    }
    
    public void addResizeListener(ActionListener listener){
    	resize.addActionListener(listener);
    }
    
    public void addExitListener(ActionListener listener){
    	exit.addActionListener(listener);
    }
    
    public void addHintListener(ActionListener listener){
    	hint.addActionListener(listener);
    }
    public void addPlayListener(ActionListener listener){
    	play.addActionListener(listener);
    }
    
    public void addHelpListener(ActionListener listener){
    	help.addActionListener(listener);
    }
    
    public void setValidSizeAndSetVisible(){
    	pack();
        setVisible(true);
    }
}
