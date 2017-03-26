package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by v on 4/4/16.
 *
 * inspired by : https://www.youtube.com/watch?v=p9Y-NBg8eto
 */
// extends Jpanel, because we draw on the Jpanel, not on the frame.
public class Draw extends JPanel implements ActionListener,KeyListener
{
    Setup setup;
    Minotaur minotaur;
    int minotaurrow;//x
    int minotaurColumn;// y

    ArrayList<ArrayList<String>> maze;
    // speed of the repaint ms?
    Timer t = new Timer(10,this);
    //velx , stands for velocity in x direction ect.
    int x, y , velx = 0, vely = 0;
    int totalHeight;
    int totalWidth;
    int treesize = 10;

    public Draw(Minotaur minotaur, ArrayList<ArrayList<String>> maze, int totalHeight, int totalWidth, int startMinotaurRow, int startMinotaurColumn, Setup setup)
    {   this.minotaur= minotaur;
        this.minotaurrow=startMinotaurRow;
        this.minotaurColumn=startMinotaurColumn;
        this.totalWidth=totalWidth;
        this.totalHeight=totalHeight;
        this.maze = maze;
        this.setup = setup;
        t.start();
        addKeyListener(this);
        // allows us to use the keyListener.
        setFocusable(true);
        // make other keys act normal. like the tab key.
        setFocusTraversalKeysEnabled(false);
    }



    /*public void drawing()
    {
        // repaint() calls the paintComponent(Graphics g) methode.

        repaint();
    }*/


    // allows us to draw graphics on the screen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        //print the maze:
        // loop through all the posible items,
        for (int j = 0; j <totalHeight ; j++)
        {

            for (int i = 0; i <totalWidth ; i++)
            {
                if(maze.get(j).get(i).equals(" "))
                {
                    g.setColor(Color.orange);
                    g.fillRect(i * 20, j * 20, 20, 20);
                }
                else if(maze.get(j).get(i).equals("+"))
                {
                    g.setColor(Color.GRAY);
                    g.fillRect(i * 20, j * 20, 20, 20);
                }
                else if (maze.get(j).get(i).equals("M"))
                {
                    g.setColor(Color.RED);
                    g.fillOval(i * 20, j * 20, 20, 20);
                }

                else if (maze.get(j).get(i).equals("R"))
                {
                    g.setColor(Color.BLUE);
                    g.fillOval(i * 20, j * 20, 20, 20);
                }
                else if (maze.get(j).get(i).equals("L"))
                {
                    g.setColor(Color.BLUE);
                    g.fillRect(i * 20, j * 20, 20, 20);
                }
                // s is for solve
                else if (maze.get(j).get(i).equals("D"))
                {
                    g.setColor(Color.magenta);
                    g.fillRect(i * 20, j * 20, 20, 20);
                }
                // Building
                else if (maze.get(j).get(i).equals("B"))
                {
                    g.setColor(Color.RED);

                    g.fillRect(i * 20, j * 20,20, 20);
                }
                //gamebarder
                else if (maze.get(j).get(i).equals("¤"))
                {
                    g.setColor(Color.black);
                    g.fillRect(i * 20, j * 20, 20, 20);
                }
                else if (maze.get(j).get(i).equals("@"))
                {
                    g.setColor(Color.BLUE);
                    g.fillRect(i * 20, j * 20, 20, 20);
                }
                else if (maze.get(j).get(i).equals("I"))
                {
                    g.setColor(Color.MAGENTA);
                    g.fillRect(i * 20, j * 20, 20, 20);
                }
                else if (maze.get(j).get(i).equals("F"))
                {
                    g.setColor(Color.RED);
                    g.fillRect(i * 20, j * 20, 20, 20);
                }
                //plants
                else if (maze.get(j).get(i).equals("P"))
                {
                    g.setColor(Color.green);
                    g.fillOval(i * 20, j * 20, 20, 20);
                }
                //hiltop
                else if (maze.get(j).get(i).equals("H"))
                {
                    g.setColor(Color.black);
                    g.fillOval(i * 20, j * 20, 20, 20);
                }
                //small treess
                else if (maze.get(j).get(i).equals("ST"))
                {
                    g.setColor(Color.green);
                    g.fillOval(i * 20, j * 20, treesize, treesize);
                }

                else if (maze.get(j).get(i).equals("MT"))
                {
                    g.setColor(Color.green);
                    g.fillOval(i * 20, j * 20, 15, 15);
                }
                // bigtrees
                else if (maze.get(j).get(i).equals("BT"))
                {
                    g.setColor(Color.green);
                    g.fillOval(i * 20, j * 20, 20, 20);
                }
                // Seed
                else if (maze.get(j).get(i).equals("S"))
                {
                    g.setColor(Color.black);
                    g.fillOval(i * 20, j * 20, 5, 5);
                }
                // MegaTreeCenter
                else if (maze.get(j).get(i).equals("MTC"))
                {
                    g.setColor(Color.green );
                    g.fillOval(i * 20, j * 20, 20, 20);
                }
                else if (maze.get(j).get(i).equals("MTC1"))
                {
                    g.setColor(Color.green );
                    g.fillOval(i * 20, j * 20, 20, 20);
                }
                else if (maze.get(j).get(i).equals("MTL1"))
                {
                    g.setColor(Color.green );
                    g.fillOval(i * 20, j * 20, 20, 20);
                }
                else if (maze.get(j).get(i).equals("MTL2"))
                {
                    g.setColor(Color.green );
                    g.fillOval(i * 20, j * 20, 20, 20);
                }


            }
        }



    }

    public void actionPerformed(ActionEvent e)
    {
        //System.out.println("repaint");
        // paint again
        repaint();

        // change koordinates.
        minotaurrow+= velx;
        minotaurColumn+= vely;

    }
    // move the minotaur.
    public void up()
    {

        vely= -1;
        velx= 0;
        System.out.println("up");
        repaint();
    }

    public void down()
    {
        vely= 1;
        velx= 0;
        System.out.println("down");
        repaint();
    }

    public void left()
    {
        vely= 0;
        velx= -1;
        System.out.println("left");
        repaint();
    }

    public void right()
    {
        vely= 0;
        velx= 1;
        System.out.println("right");
        repaint();

    }


        // inspired by : https://www.youtube.com/watch?v=p9Y-NBg8eto

    @Override
    public void keyPressed(KeyEvent e)
    {

        int code = e.getKeyCode();
        // year
        if(code == KeyEvent.VK_Y)
        {

            passYear();
        }
        // Seed/ plant tree
        if(code == KeyEvent.VK_S)
        {

            minotaur.plantTree();

        }
        if(code == KeyEvent.VK_UP)
        {
            up();
            minotaur.minotaurUp();

        }
        if(code == KeyEvent.VK_DOWN)
        {
            minotaur.minotaurDown();
            down();
        }
        if(code == KeyEvent.VK_LEFT)
        {
            left();
            minotaur.minotaurLeft();
        }
        if(code == KeyEvent.VK_RIGHT)
        {
            right();
            minotaur.minotaurRight();

        }
    }

    public void passYear()
    {

        // change ST -> MT  , small trees to medium trees
        // change MT -> BT  , medium tress to big trees
        System.out.println("year passes");
        // change ST -> MT  , small trees to medium trees
        // loop through all Maze array and change "ST" to "MT"

        for (int j = 0; j <totalHeight ; j++)
        {

            for (int i = 0; i <totalWidth ; i++)
            {
                if (maze.get(j).get(i).equals("ST"))
                {
                    maze.get(j).set(i,"MT");
                }
                else if (maze.get(j).get(i).equals("MT"))
                {
                    maze.get(j).set(i,"BT");

                }
                else if (maze.get(j).get(i).equals("S"))
                {
                    maze.get(j).set(i,"ST");

                }
                else if (maze.get(j).get(i).equals("BT"))
                {
                    setup.tree.addFirstLayer(j,i);

                    //tree.growTreeToLevel1(j,i);
                }
                else if (maze.get(j).get(i).equals("MTC1"))
                {
                    // add second layer
                    setup.tree.addSecondLayer(j,i);

                }


            }
        }

    }

    // the two methodes below needs to be included because we implemented Keylistener.
    // but can stay empty, since we dont use them.
    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
