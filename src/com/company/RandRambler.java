package com.company;



import javax.swing.*;
import java.util.ArrayList;

public class RandRambler {


    Setup setup;
    ArrayList<ArrayList<String>> maze;
    int width;
    int height;

    int currentColumnPosition;

    int currentRowPosition;

    Minotaur minotaur;
    private Gui gui;
    int score;

    public RandRambler(ArrayList<ArrayList<String>> maze, int height, int width, Minotaur minotaur, Setup setup)
    {
        this.setup = setup;
        this.minotaur = minotaur;
        this.maze=maze;

        this.width = width;
        this.height = height;

        System.out.println("create minotaur");

        // start moving rand rambler
        randomMove();
    }

    public void randomMove() {

        int randomDirection = (int)(Math.random()*5 ) +1;
        System.out.println("direction rambler move numb "+ randomDirection);
        // up
        if(randomDirection == 1)
        {
            randomRanmblerUp();

        }
        // down
        else if (randomDirection== 2)
        {
            randomRanmblerDown();
        }
        // left
        else if (randomDirection== 3)
        {
            randomRanmblerLeft();
        }
        // right
        else if (randomDirection== 4)
        {
            randomRanmblerRight();
        }
        else
        {
            System.out.println(" no direction found for rambler");
        }

    }

    public void insertRambler()
    {
        System.out.println("Minotaur log width"+width+ "height"+height);
        System.out.println();
        int startRamblerRow = (int) (Math.random() * height) + 2; // the higher the number the further down the board you go
        currentRowPosition=startRamblerRow;
        int startMRamblerColumn = (int) (Math.random() * width) + 2;// the higher the number the further right the board you go
        currentColumnPosition=startMRamblerColumn;


        if (maze.get(startRamblerRow).get(startMRamblerColumn).equals(" ")) {
            maze.get(startRamblerRow).set(startMRamblerColumn, "R");
        }
        else
            insertRambler();

    }
    public void randomRanmblerUp()
    {
        if (maze.get(currentRowPosition - 1).get(currentColumnPosition).equals("+")||
                maze.get(currentRowPosition - 1).get(currentColumnPosition).equals("¤"))
        {
            System.out.println("Wall.. cant move through here");
        }
        else if (maze.get(currentRowPosition - 1).get(currentColumnPosition).equals("F"))
        {
            System.out.println("congratilations, you got out");

            gui.makeWinnerFrame();

        }
        else if (maze.get(currentRowPosition-1).get(currentColumnPosition).equals("B"))
        {
            System.out.println("Building.. cant move through here");
        }
        else if (maze.get(currentRowPosition-1).get(currentColumnPosition).equals("P"))
        {
            System.out.println("tree.. cant move through here");
        }
        // if currunt position is a seed keep it a seed and moove up.
        else if (maze.get(currentRowPosition).get(currentColumnPosition).equals("S"))
        {
            maze.get(currentRowPosition).set(currentColumnPosition, "S");
            System.out.println("seed");
            System.out.println("move minotaur up");
            // set the next space to minotaur
            maze.get(currentRowPosition - 1).set(currentColumnPosition, "R");
            // change the position..
            currentRowPosition = currentRowPosition - 1;
        }

        else
        {

            System.out.println("move minotaur up");

            // what is at the current position?
            // if the current positin isent empty then store what is there


            maze.get(currentRowPosition).set(currentColumnPosition, " ");

            // clear path 2. step
            maze.get(currentRowPosition - 1).set(currentColumnPosition, "R");
            //testMode System.out.println("make path up to row , column"+ (currentRowPosition-3)+","+(currentColumnPosition-1) );




            // set new position:
            // we move 2 steps up to our new position.
            currentRowPosition = currentRowPosition - 1;
        }
    }
    public void randomRanmblerDown()
    {
        if (maze.get(currentRowPosition + 1).get(currentColumnPosition).equals("+")||
                maze.get(currentRowPosition + 1).get(currentColumnPosition).equals("¤"))
        {
            System.out.println("Wall.. cant move through here");
        }
        else if (maze.get(currentRowPosition + 1).get(currentColumnPosition).equals("F"))
        {
            System.out.println("congratilations, you got out");
        }

        else if (maze.get(currentRowPosition).get(currentColumnPosition).equals("S"))
        {
            maze.get(currentRowPosition).set(currentColumnPosition, "S");
            System.out.println("seed");
            System.out.println("move minotaur down");
            // set the next space to minotaur
            maze.get(currentRowPosition + 1).set(currentColumnPosition, "R");
            // change the position..
            currentRowPosition = currentRowPosition + 1;
        }

        else
        {
            System.out.println("move minotaur Down");

            maze.get(currentRowPosition).set(currentColumnPosition, " ");

            // clear path 2. step
            maze.get(currentRowPosition + 1).set(currentColumnPosition, "");
            //testMode System.out.println("make path up to row , column"+ (currentRowPosition-3)+","+(currentColumnPosition-1) );




            // set new position:
            // we move 2 steps up to our new position.
            currentRowPosition = currentRowPosition + 1;
        }
    }
    public void randomRanmblerLeft()
    {
        if (maze.get(currentRowPosition ).get(currentColumnPosition- 1).equals("+")||
                maze.get(currentRowPosition).get(currentColumnPosition- 1).equals("¤"))
        {
            System.out.println("Wall.. cant move through here");
        }
        else if (maze.get(currentRowPosition).get(currentColumnPosition- 1).equals("F"))
        {
            System.out.println("congratilations, you got out");

        }
        else if (maze.get(currentRowPosition).get(currentColumnPosition-1).equals("S"))
        {
            System.out.println("the game starts here, find the exit.");
        }
        else if (maze.get(currentRowPosition).get(currentColumnPosition).equals("S"))
        {
            maze.get(currentRowPosition).set(currentColumnPosition, "S");
            System.out.println("seed");
            System.out.println("move minotaur up");
            // set the next space to minotaur
            maze.get(currentRowPosition).set(currentColumnPosition-1, "R");
            // change the position..
            currentColumnPosition = currentColumnPosition-1;
        }
        else
        {
            System.out.println("move minotaur Left");

            maze.get(currentRowPosition).set(currentColumnPosition, " ");

            // clear path 2. step
            maze.get(currentRowPosition).set(currentColumnPosition-1, "R");
            //testMode System.out.println("make path up to row , column"+ (currentRowPosition-3)+","+(currentColumnPosition-1) );




            // set new position:
            // we move 2 steps up to our new position.
            currentColumnPosition = currentColumnPosition-1;
        }
    }

    public void randomRanmblerRight()
    {
        if (maze.get(currentRowPosition).get(currentColumnPosition+1).equals("+")||
                maze.get(currentRowPosition).get(currentColumnPosition+1).equals("¤"))
        {
            System.out.println("Wall.. cant move through here");
        }
        else if (maze.get(currentRowPosition).get(currentColumnPosition+1).equals("F"))
        {
            System.out.println("congratilations, you got out");
            gui.makeWinnerFrame();
        }
        else if (maze.get(currentRowPosition).get(currentColumnPosition+1).equals("S"))
        {
            System.out.println("the game starts here, find the exit.");
        }
        else if (maze.get(currentRowPosition).get(currentColumnPosition).equals("S"))
        {
            maze.get(currentRowPosition).set(currentColumnPosition, "S");
            System.out.println("seed");
            System.out.println("move minotaur right");
            // set the next space to minotaur
            maze.get(currentRowPosition).set(currentColumnPosition+1, "R");
            // change the position..
            currentColumnPosition = currentColumnPosition+1;
        }
        else
        {
            System.out.println("move minotaur Left");

            maze.get(currentRowPosition).set(currentColumnPosition, " ");

            // clear path 2. step
            maze.get(currentRowPosition).set(currentColumnPosition+1, "R");
            //testMode System.out.println("make path up to row , column"+ (currentRowPosition-3)+","+(currentColumnPosition-1) );




            // set new position:
            // we move 2 steps up to our new position.
            currentColumnPosition = currentColumnPosition+1;

        }
    }


    public void passInstance(Gui gui)
    {
        this.gui=gui;
    }

    public void plantTree() {
        maze.get(currentRowPosition).set(currentColumnPosition, "S");

    }

    public void start() {
        boolean rabitRunning = true;

        do
        {
            //random move and wait 2 sec.
            randomMove();
            // sllep one sec.

            try {
                Thread.sleep(1000);
                System.out.println("moving? but sleep ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // current position = rambler position. end game.

            if ((currentColumnPosition == minotaur.currentColumnPosition) && (currentRowPosition == minotaur.currentRowPosition))
            {
                System.out.println("you caught the rabit");
                rabitRunning = false;

                // set score
                score = score + 100;
                System.out.println("current score = " + score);
                JOptionPane.showMessageDialog(null,"current score = " + score );
                // start an other random rambler
                insertRambler();
                start();


            }
            else
                System.out.println("the rabit is still running catch it");
        }
        while(rabitRunning == true);

    }



}
