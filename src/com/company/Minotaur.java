package com.company;



import java.util.ArrayList;

public class Minotaur {


    ArrayList<ArrayList<String>> maze;
    int width;
    int height;

    int currentColumnPosition;

    int currentRowPosition;

    private Gui gui;

    public Minotaur(ArrayList<ArrayList<String>> maze, int startMinotaurRow, int startMinotaurColumn, int height, int width)
    {

        this.maze=maze;
        this.currentRowPosition =startMinotaurRow;
        this.currentColumnPosition =startMinotaurColumn;
        this.width = width;
        this.height = height;

        System.out.println("create minotaur");
    }

    public void insertMinotaur()
    {
        System.out.println("Minotaur log width"+width+ "height"+height);
        System.out.println();
        int startMinotaurRow = (int) (Math.random() * height) + 2; // the higher the number the further down the board you go
        currentRowPosition=startMinotaurRow;
        int startMinotaurColumn = (int) (Math.random() * width) + 2;// the higher the number the further right the board you go
        currentColumnPosition=startMinotaurColumn;


        if (maze.get(startMinotaurRow).get(startMinotaurColumn).equals(" ")) {
            maze.get(startMinotaurRow).set(startMinotaurColumn, "M");
        }
        else
            insertMinotaur();

    }
    public void minotaurUp()
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
            maze.get(currentRowPosition - 1).set(currentColumnPosition, "M");
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
        maze.get(currentRowPosition - 1).set(currentColumnPosition, "M");
        //testMode System.out.println("make path up to row , column"+ (currentRowPosition-3)+","+(currentColumnPosition-1) );




        // set new position:
        // we move 2 steps up to our new position.
        currentRowPosition = currentRowPosition - 1;
        }
    }
    public void minotaurDown()
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
            maze.get(currentRowPosition + 1).set(currentColumnPosition, "M");
            // change the position..
            currentRowPosition = currentRowPosition + 1;
        }

        else
        {
        System.out.println("move minotaur Down");

        maze.get(currentRowPosition).set(currentColumnPosition, " ");

        // clear path 2. step
        maze.get(currentRowPosition + 1).set(currentColumnPosition, "M");
        //testMode System.out.println("make path up to row , column"+ (currentRowPosition-3)+","+(currentColumnPosition-1) );




        // set new position:
        // we move 2 steps up to our new position.
        currentRowPosition = currentRowPosition + 1;
        }
    }
    public void minotaurLeft()
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
            maze.get(currentRowPosition).set(currentColumnPosition-1, "M");
            // change the position..
            currentColumnPosition = currentColumnPosition-1;
        }
        else
        {
        System.out.println("move minotaur Left");

        maze.get(currentRowPosition).set(currentColumnPosition, " ");

        // clear path 2. step
        maze.get(currentRowPosition).set(currentColumnPosition-1, "M");
        //testMode System.out.println("make path up to row , column"+ (currentRowPosition-3)+","+(currentColumnPosition-1) );




        // set new position:
        // we move 2 steps up to our new position.
        currentColumnPosition = currentColumnPosition-1;
        }
    }

    public void minotaurRight()
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
            maze.get(currentRowPosition).set(currentColumnPosition+1, "M");
            // change the position..
            currentColumnPosition = currentColumnPosition+1;
        }
        else
        {
        System.out.println("move minotaur Left");

        maze.get(currentRowPosition).set(currentColumnPosition, " ");

        // clear path 2. step
        maze.get(currentRowPosition).set(currentColumnPosition+1, "M");
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
}
