package com.company;

import java.util.ArrayList;

/**
 * Created by v on 4/8/16.
 */
public class Setup {

    Tree tree;
    Gui gui;
    Draw draw;
    Game game;
    ArrayList<ArrayList<String>> maze;

    int width;
    int height;
    int totalHeight;
    int totalWidth;


    public Setup()
    {

        // build up game:
        game = new Game(this);
        
        game.generateBoard();
        width = game.getWidth();
        height =game.getHeight();
        maze = game.getMaze();
        totalHeight= height+4;
        totalWidth = width +4;

        int startMinotaurRow =  game.getStartMinotaurRow();
        int startMinotaurColumn = game.getStartMinotaurColumn();


        Minotaur minotaur = new Minotaur(maze,startMinotaurRow,startMinotaurColumn,height,width);
        RandRambler randRambler = new RandRambler(maze,height,width,minotaur,this);
        //RandRambler randRambler2 = new RandRambler(maze,height,width,minotaur);



        // add random maze.

        //Maze maze = new Maze();

        tree = new Tree(this,game);



        System.out.println(" lav guien");
        minotaur.insertMinotaur();
        randRambler.insertRambler();
        //randRambler2.insertRambler();


        gui= new Gui(game,minotaur,maze,totalHeight,totalWidth,startMinotaurRow,startMinotaurColumn,this);
        draw = new Draw(minotaur,maze,totalHeight,totalWidth,startMinotaurRow,startMinotaurColumn,this);
        gui.startguiAfterDrawIsAdded(draw);


        //game.passInstanceOfRecursiveBacktracker(game);

        game.printMaze();
        Lake lake = new Lake(this,height,width,maze);
        //game.calculateMoney();
        game.addTreeObjectAndpaseInstances(tree,lake);
        game.makeLandscape();
        randRambler.start();

    }



}
