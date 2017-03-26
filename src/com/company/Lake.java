package com.company;

import java.util.ArrayList;

/**
 * Created by v on 3/15/17.
 */
public class Lake {
    ArrayList<ArrayList<String>> maze;
    int height;
    int width;
    Setup setup;



    public Lake(Setup setup, int height, int width, ArrayList<ArrayList<String>> maze) {
        this.setup = setup;
        this.height = height;
        this.width = width;
        this.maze = maze;
    }

    public void createLake(){

        //makestartposition
        // Add lake


            int RowPositionForLake = 10;// = ((int) (Math.random() * height-10) + 2);
            // the "set( column , "L")
            int ColumForLake = ((int) (Math.random() * width-5) + 2);
        for (int i = 0 ; i < 5; i ++ )

        {



        /*
            maze.get(PositionForLake).set(ColumForLake, "L");
            maze.get(PositionForLake-1).set(ColumForLake-1, "L");
            maze.get(PositionForLake-1).set(ColumForLake, "L");
            maze.get(PositionForLake-1).set(ColumForLake+1, "L");
            maze.get(PositionForLake-2).set(ColumForLake, "L");
*/

            maze.get(RowPositionForLake).set(ColumForLake, "L");

            // add layer 1 // top row
            maze.get(RowPositionForLake - 1).set(ColumForLake - 1, "L");
            maze.get(RowPositionForLake - 1).set(ColumForLake, "L");
            maze.get(RowPositionForLake - 1).set(ColumForLake + 1, "L");
            // sides
            maze.get(RowPositionForLake).set(ColumForLake - 1, "L");
            maze.get(RowPositionForLake).set(ColumForLake + 1, "MTL1");
            // add bottom PositionForLake
            maze.get(RowPositionForLake + 1).set(ColumForLake - 1, "L");
            maze.get(RowPositionForLake + 1).set(ColumForLake, "L");
            maze.get(RowPositionForLake + 1).set(ColumForLake + 1, "L");

            // add 2. layer // top row
            maze.get(RowPositionForLake - 2).set(ColumForLake - 1, "L");
            maze.get(RowPositionForLake - 2).set(ColumForLake, "L");
            maze.get(RowPositionForLake - 2).set(ColumForLake + 1, "L");

            //sides 2 layer left side:
            maze.get(RowPositionForLake - 1).set(ColumForLake - 2, "L");

            maze.get(RowPositionForLake).set(ColumForLake - 2, "L");
            maze.get(RowPositionForLake + 1).set(ColumForLake - 2, "L");


            //sides 2 layer right side:
            maze.get(RowPositionForLake - 1).set(ColumForLake + 2, "L");

            maze.get(RowPositionForLake).set(ColumForLake + 2, "L");
            maze.get(RowPositionForLake + 1).set(ColumForLake + 2, "L");

            // bottom row level 2.
            maze.get(RowPositionForLake + 2).set(ColumForLake - 1, "L");
            maze.get(RowPositionForLake + 2).set(ColumForLake, "L");
            maze.get(RowPositionForLake + 2).set(ColumForLake + 1, "L");
            RowPositionForLake++;
            ColumForLake++;
        }
        for (int i = 0 ; i < 5; i ++ )

        {



        /*
            maze.get(PositionForLake).set(ColumForLake, "L");
            maze.get(PositionForLake-1).set(ColumForLake-1, "L");
            maze.get(PositionForLake-1).set(ColumForLake, "L");
            maze.get(PositionForLake-1).set(ColumForLake+1, "L");
            maze.get(PositionForLake-2).set(ColumForLake, "L");
*/

            maze.get(RowPositionForLake).set(ColumForLake, "L");

            // add layer 1 // top row
            maze.get(RowPositionForLake - 1).set(ColumForLake - 1, "L");
            maze.get(RowPositionForLake - 1).set(ColumForLake, "L");
            maze.get(RowPositionForLake - 1).set(ColumForLake + 1, "L");
            // sides
            maze.get(RowPositionForLake).set(ColumForLake - 1, "L");
            maze.get(RowPositionForLake).set(ColumForLake + 1, "MTL1");
            // add bottom PositionForLake
            maze.get(RowPositionForLake + 1).set(ColumForLake - 1, "L");
            maze.get(RowPositionForLake + 1).set(ColumForLake, "L");
            maze.get(RowPositionForLake + 1).set(ColumForLake + 1, "L");

            // add 2. layer // top row
            maze.get(RowPositionForLake - 2).set(ColumForLake - 1, "L");
            maze.get(RowPositionForLake - 2).set(ColumForLake, "L");
            maze.get(RowPositionForLake - 2).set(ColumForLake + 1, "L");

            //sides 2 layer left side:
            maze.get(RowPositionForLake - 1).set(ColumForLake - 2, "L");

            maze.get(RowPositionForLake).set(ColumForLake - 2, "L");
            maze.get(RowPositionForLake + 1).set(ColumForLake - 2, "L");


            //sides 2 layer right side:
            maze.get(RowPositionForLake - 1).set(ColumForLake + 2, "L");

            maze.get(RowPositionForLake).set(ColumForLake + 2, "L");
            maze.get(RowPositionForLake + 1).set(ColumForLake + 2, "L");

            // bottom row level 2.
            maze.get(RowPositionForLake + 2).set(ColumForLake - 1, "L");
            maze.get(RowPositionForLake + 2).set(ColumForLake, "L");
            maze.get(RowPositionForLake + 2).set(ColumForLake + 1, "L");
            RowPositionForLake++;
            //ColumForLake;
        }
        for (int i = 0 ; i < 5; i ++ )

        {



        /*
            maze.get(PositionForLake).set(ColumForLake, "L");
            maze.get(PositionForLake-1).set(ColumForLake-1, "L");
            maze.get(PositionForLake-1).set(ColumForLake, "L");
            maze.get(PositionForLake-1).set(ColumForLake+1, "L");
            maze.get(PositionForLake-2).set(ColumForLake, "L");
*/

            maze.get(RowPositionForLake).set(ColumForLake, "L");

            // add layer 1 // top row
            maze.get(RowPositionForLake - 1).set(ColumForLake - 1, "L");
            maze.get(RowPositionForLake - 1).set(ColumForLake, "L");
            maze.get(RowPositionForLake - 1).set(ColumForLake + 1, "L");
            // sides
            maze.get(RowPositionForLake).set(ColumForLake - 1, "L");
            maze.get(RowPositionForLake).set(ColumForLake + 1, "MTL1");
            // add bottom PositionForLake
            maze.get(RowPositionForLake + 1).set(ColumForLake - 1, "L");
            maze.get(RowPositionForLake + 1).set(ColumForLake, "L");
            maze.get(RowPositionForLake + 1).set(ColumForLake + 1, "L");

            // add 2. layer // top row
            maze.get(RowPositionForLake - 2).set(ColumForLake - 1, "L");
            maze.get(RowPositionForLake - 2).set(ColumForLake, "L");
            maze.get(RowPositionForLake - 2).set(ColumForLake + 1, "L");

            //sides 2 layer left side:
            maze.get(RowPositionForLake - 1).set(ColumForLake - 2, "L");

            maze.get(RowPositionForLake).set(ColumForLake - 2, "L");
            maze.get(RowPositionForLake + 1).set(ColumForLake - 2, "L");


            //sides 2 layer right side:
            maze.get(RowPositionForLake - 1).set(ColumForLake + 2, "L");

            maze.get(RowPositionForLake).set(ColumForLake + 2, "L");
            maze.get(RowPositionForLake + 1).set(ColumForLake + 2, "L");

            // bottom row level 2.
            maze.get(RowPositionForLake + 2).set(ColumForLake - 1, "L");
            maze.get(RowPositionForLake + 2).set(ColumForLake, "L");
            maze.get(RowPositionForLake + 2).set(ColumForLake + 1, "L");
            RowPositionForLake++;
            ColumForLake++;
        }


        }




    }



