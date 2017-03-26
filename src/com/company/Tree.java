package com.company;

import java.util.ArrayList;

/**
 * Created by v on 3/14/17.
 */
public class Tree {


    int height;
    int width;
    ArrayList<ArrayList<String>> maze;

    public Tree(Setup setup, Game game) {
        height= game.getHeight();
        width= game.getWidth();
        maze = game.getMaze();
        System.out.println("tree class active!");
        setup.getClass();

    }

    public void growTree()
    {

    }
    public void plantSeed()
    {

    }

    public void addrandomMediumTrees(int numberOfMediumTrees) {
        int i ;

        for (i = 0; i < numberOfMediumTrees; i ++ )
        {
            // add random tree

            int randomRowPositionForPlants = ((int) (Math.random() * height) + 2);
            // the "set( column , "L")
            int RandomColumForPlants = ((int) (Math.random() * width) + 2);

            maze.get(randomRowPositionForPlants).set(RandomColumForPlants, "MT");
        }
    }

    public void addRandomSmallTrees(int num) {
        // Add Small trees
        for (int i = 0 ; i < num; i ++ )
        {
            int randomRowPositionForPlants = ((int) (Math.random() * height) + 2);
            // the "set( column , "L")
            int RandomColumForPlants = ((int) (Math.random() * width) + 2);

            maze.get(randomRowPositionForPlants).set(RandomColumForPlants, "ST");
        }

    }

    public void addRandBigTrees(int num) {
        // Add  bIG TREES
        for (int i = 0 ; i < num; i ++ )
        {
            int randomRowPositionForPlants = ((int) (Math.random() * height) + 2);
            // the "set( column , "L")
            int RandomColumForPlants = ((int) (Math.random() * width) + 2);

            maze.get(randomRowPositionForPlants).set(RandomColumForPlants, "BT");
        }
    }

    public void addRandLevel1Trees(int num) {
        // add mega tree 9 tiles MTC= megaTreeCenter
        for (int i = 0 ; i < num; i ++ )
        {
            int randomRowPositionForMTC = ((int) (Math.random() * height) + 2);
            // the "set( column , "L")
            int RandomColumForMTC = ((int) (Math.random() * width) + 2);

            maze.get(randomRowPositionForMTC).set(RandomColumForMTC, "MTC");

            // add layer 1 // top row
            maze.get(randomRowPositionForMTC-1).set(RandomColumForMTC-1, "MTL1");
            maze.get(randomRowPositionForMTC-1).set(RandomColumForMTC, "MTL1");
            maze.get(randomRowPositionForMTC-1).set(RandomColumForMTC+1, "MTL1");
            // sides
            maze.get(randomRowPositionForMTC).set(RandomColumForMTC-1, "MTL1");
            maze.get(randomRowPositionForMTC).set(RandomColumForMTC+1, "MTL1");
            // add bottom row
            maze.get(randomRowPositionForMTC+1).set(RandomColumForMTC-1, "MTL1");
            maze.get(randomRowPositionForMTC+1).set(RandomColumForMTC, "MTL1");
            maze.get(randomRowPositionForMTC+1).set(RandomColumForMTC+1, "MTL1");


        }
    }

    public void addRandLevel2Trees(int num) {
        for (int i = 0 ; i < num; i ++ )
        {
            int RowPositionForMTC = ((int) (Math.random() * height) + 2);
            // the "set( column , "L")
            int ColumPositionForMTC = ((int) (Math.random() * width) + 2);

            maze.get(RowPositionForMTC).set(ColumPositionForMTC, "MTC");

            // add layer 1 // top row
            maze.get(RowPositionForMTC-1).set(ColumPositionForMTC-1, "MTL1");
            maze.get(RowPositionForMTC-1).set(ColumPositionForMTC, "MTL1");
            maze.get(RowPositionForMTC-1).set(ColumPositionForMTC+1, "MTL1");
            // sides
            maze.get(RowPositionForMTC).set(ColumPositionForMTC-1, "MTL1");
            maze.get(RowPositionForMTC).set(ColumPositionForMTC+1, "MTL1");
            // add bottom row
            maze.get(RowPositionForMTC+1).set(ColumPositionForMTC-1, "MTL1");
            maze.get(RowPositionForMTC+1).set(ColumPositionForMTC, "MTL1");
            maze.get(RowPositionForMTC+1).set(ColumPositionForMTC+1, "MTL1");

            // add 2. layer // top row
            maze.get(RowPositionForMTC-2).set(ColumPositionForMTC-1, "MTL2");
            maze.get(RowPositionForMTC-2).set(ColumPositionForMTC, "MTL2");
            maze.get(RowPositionForMTC-2).set(ColumPositionForMTC+1, "MTL2");

            //sides 2 layer left side:
            maze.get(RowPositionForMTC-1).set(ColumPositionForMTC-2, "MTL2");

            maze.get(RowPositionForMTC).set(ColumPositionForMTC-2, "MTL2");
            maze.get(RowPositionForMTC+1).set(ColumPositionForMTC-2, "MTL2");


            //sides 2 layer right side:
            maze.get(RowPositionForMTC-1).set(ColumPositionForMTC+2, "MTL2");

            maze.get(RowPositionForMTC).set(ColumPositionForMTC+2, "MTL2");
            maze.get(RowPositionForMTC+1).set(ColumPositionForMTC+2, "MTL2");

            // bottom row level 2.
            maze.get(RowPositionForMTC+2).set(ColumPositionForMTC-1, "MTL2");
            maze.get(RowPositionForMTC+2).set(ColumPositionForMTC, "MTL2");
            maze.get(RowPositionForMTC+2).set(ColumPositionForMTC+1, "MTL2");
        }


    }

    public void addSecondLayer(int j, int i) {

        maze.get(j).set(i,"MTC2");
        // add 2. layer // top row
        maze.get(j-2).set(i-1, "MTL2");
        maze.get(j-2).set(i, "MTL2");
        maze.get(j-2).set(i+1, "MTL2");

        //sides 2 layer left side:
        maze.get(j-1).set(i-2, "MTL2");

        maze.get(j).set(i-2, "MTL2");
        maze.get(j+1).set(i-2, "MTL2");


        //sides 2 layer right side:
        maze.get(j-1).set(i+2, "MTL2");

        maze.get(j).set(i+2, "MTL2");
        maze.get(j+1).set(i+2, "MTL2");

        // bottom row level 2.
        maze.get(j+2).set(i-1, "MTL2");
        maze.get(j+2).set(i, "MTL2");
        maze.get(j+2).set(i+1, "MTL2");

    }

    public void addFirstLayer(int j, int i) {
        maze.get(j).set(i,"MTC1");
        // add layer 1 // top row
        if ( maze.get(j-1).get(i-1).equals("B") )
        {
        maze.get(j-1).set(i-1, "B");

        }
        else {
            maze.get(j-1).set(i-1, "MTL1");

        }
        if ( maze.get(j-1).get(i).equals("B") )
        {
            maze.get(j-1).set(i, "B");

        }
        else {
            maze.get(j-1).set(i, "MTL1");

        }
        if ( maze.get(j-1).get(i+1).equals("B") )
        {
            maze.get(j-1).set(i+1, "B");

        }
        else{
            maze.get(j-1).set(i+1, "MTL1");
        }

        maze.get(j-1).set(i+1, "MTL1");
        // sides
        maze.get(j).set(i-1, "MTL1");
        maze.get(j).set(i+1, "MTL1");
        // add bottom row
        maze.get(j+1).set(i-1, "MTL1");
        maze.get(j+1).set(i, "MTL1");
        maze.get(j+1).set(i+1, "MTL1");
    }
}
