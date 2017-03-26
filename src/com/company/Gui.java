package com.company;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by v on 4/4/16.
 */
public class Gui extends JFrame {

    int totalHeight;
    ArrayList<ArrayList<String>> maze;
    int totalWidth;
    int startMinotaurRow;
    int startMinotaurColumn;
    JFrame mazeFrame;
    Minotaur minotaur;
    Game game;
    Draw draw;

    public Gui(Game game, Minotaur minotaur, ArrayList<ArrayList<String>> maze, int totalHeight, int totalWidth, int startMinotaurRow, int startMinotaurColumn, Setup setup)
    {
        this.minotaur=minotaur;
        this.game = game;
        this.maze=maze;
        this.totalHeight = totalHeight;
        this.totalWidth = totalWidth;
        this.startMinotaurRow = startMinotaurRow;
        this.startMinotaurColumn = startMinotaurColumn;

        mazeFrame = new JFrame("BacktrackerLabyrinth");

        setLocationRelativeTo(null);



    }

    public void startguiAfterDrawIsAdded(Draw draw) {

        // add the drawing to the mazeFrame.
        this.draw = draw;
        mazeFrame.add(this.draw);

        //mazeFrame.add(keyboardExample);
        mazeFrame.setVisible(true);
        mazeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //center mazeFrame
        setLocationRelativeTo(null);
        System.out.println(totalHeight+ "and GUI log" +totalWidth);
        mazeFrame.setSize(totalWidth*20, totalHeight*20);
        setLocationRelativeTo(null);

        JOptionPane.showMessageDialog(null, "this is not a game!" +
                ", This is Permaculture, its about survival financialy " +
                "if you you cant pay yur bills you have to go home and live with your parrents! , " +
                "you can get money by selling things");
    }

    public void createFrame()
    {

    }

    public void makeWinnerFrame()
    {
        // make a dialog. for rebuilding the maze
        // inspired by : http://stackoverflow.com/questions/8396870/joptionpane-yes-or-no-window
        //date 8/6/2016
        // null means nothing i think. but it works, it can replace any data type.. maybe?

        int reply = JOptionPane.showConfirmDialog(null, "You won. make new labyrinth?","Question", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            //JOptionPane.showMessageDialog(null,"Yes, rebuild");
            //mazeFrame.dispatchEvent(new WindowEvent(mazeFrame, WindowEvent.WINDOW_CLOSING));
            mazeFrame.setVisible(false); //you can't see me!
            mazeFrame.dispose(); //Destroy the JFrame object

            System.out.println("make a new one");
            //game.test();





        }
        else {
            JOptionPane.showMessageDialog(null, "GOODBYE");
            System.exit(0);
        }
    }

    public void passInstance(Game game) {
        this.game = game;
    }

    public void passInstance(Draw draw) {
        this.draw = draw;
    }
}
