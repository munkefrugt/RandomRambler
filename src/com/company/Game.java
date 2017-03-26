package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Martin Moltke Wozniak on 3/4/16.
 */
public class Game
{

    Setup setup;
    Scanner input = new Scanner(System.in);
    int totalWidth;
    int totalHeight;
    int width =63;
    int height = 33;
    int currentRowPosition;
    int currentColumnPosition;


    int randomDirection;
    // this array changes if therehas been made a try to go down a certain path. 0->1
    // the index 0 = up, 1= down,2=left, 3=right.
    // this will start backtraking is they are all one
    int failedPathDirections[] = {0,0,0,0,};


    // count each piece of path that have been created, added or subtracted. when path count is 0 and theres no where to
    // go the loop breaks.
    int pathCount;

    // if there has been made a try to backtrack and it failed change the index from  0->1
    // the index 0 = up, 1= down,2=left, 3=right.
    // this will start make the last 0 into a blank space. (" ")
    // when they are all 1. go out off the algorithm and start the rest of the program.
    int failedBackTrackingDirections[] ={0,0,0,0};

    int previousRowPosition;
    int previousColumnPosition;


    // have to have a start value that is not 0,1,2 0r 3. otherwise a direction will be blocked.
    int blockedDirection=-1;


    // if it reaches a deadend make this true
    //boolean hasReachedDeadEnd;
    int BackTrackTestCount;

    ArrayList<ArrayList<String>> maze = new ArrayList<ArrayList<String>>();
    int startMinotaurRow;
    int startMinotaurColumn;
    private int startRow;
    private int startColumn;
    public Game game;
    int randomRowForEntrance;
    int randomRowForExit;
    Tree tree;
    Lake lake;


    public Game(Setup setup)
    {
        this.setup=setup;
        
        //this.game = game;
        System.out.println("Welcome to my a 'mazing' backtracking maze algorithm. \n" );

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public ArrayList<ArrayList<String>> getMaze() {
        return maze;
    }

    public int getStartMinotaurRow() {
        return startMinotaurRow;
    }

    public int getStartMinotaurColumn() {
        return startMinotaurColumn;
    }

    private void setSizeOfMaze()
    {

        // set size
        System.out.println("enter width and Height, only UNEVEN NUMBERS");
        //width = input.nextInt();
        width= 63;
        // even

        // note about % (modulus) , ex: 4 % 2 = 0 , so it's the value of the remainder, other ex: 5 % 2 = 1 , its like saying
        // 5 divided by 2 (which is 4 with a remainder of 1)

        if (width % 2 == 0)
        {
            System.out.println("cant be an even number");

            setSizeOfMaze();
        }

        else
        {
            System.out.println("odd number");
        }
        System.out.println("your  width is: " + width);

        System.out.println("enter height only ODD EVEN NUMBERS, ex 1,3,5 ec");
        //height = input.nextInt();
        height=33;
        System.out.println("your  height is: " + height);

        totalWidth=width+4;
        totalHeight=height+4;

    }



    // makes a maze.
    // sort of the main funcion that calls the other functions.
    public void generateBoard()
    {
        System.out.println("generate maze");
        setSizeOfMaze();

        System.out.println(width);
        System.out.println(height);

        System.out.println("fill maze");
        fillMaze(); // fill up the maze and prints maze , maze get full of blank space " " empty".



        System.out.println("make rand start pos");
        //makeStartPositionForPathbuilding();
        System.out.println("Print start position");
        //printMaze();
        //System.out.println("find RandDirection  :" + randomDirection);


        //ChoosePathAndBuild();// chose a path randomly and try to make a path.
        printMaze();
        //makeEntranceInBorder();
        //makeExitInBorder();
        //insertMinotaur();


        System.out.println("END*******************************************************************************");

        printMaze();
        //Minotaur minotaur = new Minotaur(maze,startMinotaurRow,startMinotaurColumn);
        //Gui gui= new Gui(game,minotaur,maze,totalHeight,totalWidth,startMinotaurRow,startMinotaurColumn);
        //minotaur.passInstance(gui);
        //gui.passInstance(game);
        //gui.createFrame();


        // solve the maze:

        //SolveMaze solveMaze = new SolveMaze(maze,randomRowForEntrance);

    }

    public void makeLandscape() {

        for (int i = 0 ; i < 2; i ++ )
        {
        // Insert random building:
        int randomRowPositionForBuilding = ((int) (Math.random() * height) + 2);
        // the "set( column , "B")
        int RandomColumForHouse = ((int) (Math.random() * width) + 2);

        maze.get(randomRowPositionForBuilding).set(RandomColumForHouse, "B");
        maze.get(randomRowPositionForBuilding).set(RandomColumForHouse+1, "B");
        maze.get(randomRowPositionForBuilding-1).set(RandomColumForHouse+1, "B");
        maze.get(randomRowPositionForBuilding-2).set(RandomColumForHouse+1, "B");

        }

        //
        for (int i = 0 ; i < 300; i ++ )
        {
            int randomRowPositionForWall = ((int) (Math.random() * height) + 2);
            // the "set( column , "L")
            int RandomColumForHiltops = ((int) (Math.random() * width) + 2);

            maze.get(randomRowPositionForWall).set(RandomColumForHiltops, "+");
        }




        tree.addrandomMediumTrees(1);
        tree.addRandomSmallTrees(1);
        tree.addRandBigTrees(1);
        tree.addRandLevel1Trees(1);
        tree.addRandLevel2Trees(1);

        //lake.createLake();


    }

    private void makeEntranceInBorder() {

        // make entrance
        randomRowForEntrance = ((int) (Math.random() * height) + 2);
        System.out.println("randomRowForEntrance "+ randomRowForEntrance);

        // if the number is uneven
        if (randomRowForEntrance % 2 == 1)
        {
            System.out.println("number for intrance is even, try new number");
            makeEntranceInBorder();

        }
        else
        {   // if the number is even, we need a even number to get a good starting point
            if (maze.get(randomRowForEntrance).get(2).equals(" "))
            {

                System.out.println("number is "+randomRowForEntrance );
                maze.get(randomRowForEntrance).set(0, "@");
                maze.get(randomRowForEntrance).set(1, "S");
                maze.get(randomRowForEntrance).set(2, " ");
            }

            else
            {
                System.out.println("try to make intrance again");
                makeEntranceInBorder();
            }
        }

    }

    private void makeExitInBorder()
    {

        // we need a random even number to make a good exit that fits with the solving algorithm.
        randomRowForExit =((int) (Math.random()* height)+2);


        // we need an  even
        // if the number is uneven make a new number.
        // if the row is even find try again,till we get an uneven.
        if (randomRowForExit % 2 == 1 )
        {
            System.out.println("number for EXIT is even, try new number");
            makeExitInBorder();

        }
        // now we have the uneven number now we can check if there is a wall that is hindering the exit.
        else {


            if (maze.get(randomRowForExit).get(totalWidth - 3).equals("+")) {
                System.out.println("try to make an other exit ");
                makeExitInBorder();
            } else {
                System.out.println("randomRowForExit: "+ randomRowForExit);
                maze.get(randomRowForExit).set(totalWidth - 1, "@");
                maze.get(randomRowForExit).set(totalWidth - 2, "F");
                maze.get(randomRowForExit).set(totalWidth - 3, " ");
                System.out.println("make exit");
            }
        }
    }




    // this is the recursive method
    private void ChoosePathAndBuild()
    {

        if(failedPathDirections[0]==1 &&
            failedPathDirections[1]==1 &&
            failedPathDirections[2]==1 &&
            failedPathDirections[3]==1 &&
                pathCount==1)
        {
            System.out.println("******************************************************done");

            maze.get(currentRowPosition).set(currentColumnPosition," ");
        }
        else {
            System.out.println("pathCount: ------> :" + pathCount);

            System.out.println("currentColumnPosition : " + currentColumnPosition);
            System.out.println("currentRowPosition : " + currentRowPosition);


            printMaze();
            //try {
            //    Thread.sleep(1);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}

            randomDirection = (int) (Math.random() * 4);

            System.out.println("randomDirection:  " + randomDirection);


            // TEST START
                /*
                System.out.println("previus rand direction " + randomDirection );
                System.out.println("enter randomDirection");
                randomDirection = input.nextInt();

                System.out.println("you entered New random direction : " + randomDirection);
                */
            // TEST END


            //Try to build path  UP, if succes take 2 steps up
            if (randomDirection == 0) {
                //testMode System.out.println("up");


                // NO SUCCES.
                // Its already blank, or there is a path, or a border, Don't make path!
                if (maze.get(currentRowPosition - 2).get(currentColumnPosition).equals("0") ||
                        maze.get(currentRowPosition - 2).get(currentColumnPosition).equals("¤") ||
                        maze.get(currentRowPosition - 2).get(currentColumnPosition).equals(" ") ||

                        (
                                maze.get(currentRowPosition - 1).get(currentColumnPosition).equals(" ")
                                        &&
                                        maze.get(currentRowPosition - 2).get(currentColumnPosition).equals(" ")
                        )
                        ) {
                    // try an other direction
                    //testMode    System.out.println("cant take this way up!");

                    //if all directions have been tried. start BACK TRACKING!
                    if (failedPathDirections[0] == 1 && failedPathDirections[1] == 1 && failedPathDirections[2] == 1 &&
                            failedPathDirections[3] == 1) {
                        // if pathcount equals 1;
                        // then break recursion loop
                        if (pathCount == 1) {
                            // end recursion
                            System.out.println("end recursion-break loop- in pathbuild mode " +
                                    "************************************" +
                                    "**********************************************************");


                        } else if (pathCount != 1) {
                            //testMode System.out.println("all directions have failed. start backtracking!");

                            //printMaze();

                            //reset failedPathDirections array,
                            // because it has to be reset for next time we need try to build a path.
                            resetFailedPathDirectionsArray();
                            // activate backtracking
                            System.out.println("pathcount != 1 and backtrack");
                            backtracking();
                        } else
                            System.out.println("Error recursion");

                    } else {
                        //testMode System.out.println("try an other direction");

                        // tell the "failedPathDirections" array that the path couldent be made.
                        failedPathDirections[0] = 1;


                        ChoosePathAndBuild();
                    }

                }


                // SUCCES! Take to steps UP. Make a path!

                // if the next position in the ext 2 step above is equal to a wall piece. then make a path.
                else// if (maze.get(currentRowPosition -1).get(currentColumnPosition).equals("+")
                //    && maze.get(currentRowPosition -2).get(currentColumnPosition).equals("+") )
                {
                    // make path
                    // -2 is because we go up so we have to use an "earlier"creaated aray
                    // clear path 1. step
                    maze.get(currentRowPosition - 1).set(currentColumnPosition, "0");

                    // clear path 2. step
                    maze.get(currentRowPosition - 2).set(currentColumnPosition, "0");
                    //testMode System.out.println("make path up to row , column"+ (currentRowPosition-3)+","+(currentColumnPosition-1) );

                    // save the position we just came from. will be used in back tracking:
                    // Set  previous position to current:
                    previousRowPosition = currentRowPosition;
                    previousColumnPosition = currentColumnPosition;


                    // set new position:
                    // we move 2 steps up to our new position.
                    currentRowPosition = currentRowPosition - 2;
                    //testMode System.out.println("currentColumnPosition "+currentColumnPosition + " should be as original");
                    // Column position is not changed!
                    //test
                    //randomDirection=3;  //left
                    pathCount++;
                    System.out.println("pathCount : " + pathCount);
                    //reset array "failedPathDirections" array set all to 0
                    resetFailedPathDirectionsArray();
                    ChoosePathAndBuild();
                }


            }

            // DOWN
            //Try to build path to the DOWN
            else if (randomDirection == 1) {
                //testMode System.out.println("down");

                // NO SUCCES.Its already blank, Don't make path!
                if (maze.get(currentRowPosition + 2).get(currentColumnPosition).equals("0") ||
                        maze.get(currentRowPosition + 2).get(currentColumnPosition).equals("¤") ||
                        maze.get(currentRowPosition + 2).get(currentColumnPosition).equals(" ") ||
                        (
                                maze.get(currentRowPosition + 1).get(currentColumnPosition).equals(" ")
                                        &&
                                        maze.get(currentRowPosition + 2).get(currentColumnPosition).equals(" ")
                        )
                        ) {
                    // try an other direction
                    //testMode System.out.println("cant take this way down!");
                    //if all directions have been tried. start BACK TRACKING!
                    if (failedPathDirections[0] == 1 && failedPathDirections[1] == 1 && failedPathDirections[2] == 1 && failedPathDirections[3] == 1) {
                        //testMode System.out.println("all directions have failed. start backtracking!");
                        //printMaze();
                        //reset failedPathDirections array,
                        // because it has to be reset for next time we need try to build a path.
                        resetFailedPathDirectionsArray();
                        // activate backtracking
                        backtracking();

                    } else {
                        //testMode System.out.println("try an other direction");
                        // tell the "failedPathDirections" array that the path couldent be made.
                        failedPathDirections[1] = 1;

                        ChoosePathAndBuild();
                    }

                }

                // SUCCES! Take to steps DOWN. Make a path!
                // if there is already a wall.
                else // if (maze.get(currentRowPosition +1).get(currentColumnPosition).equals("+")
                //   && maze.get(currentRowPosition +2).get(currentColumnPosition).equals("+") )

                {
                    // make path
                    // +,1+2 is because we go up so we have to use an "earlier"creaated row
                    // clear path 1. step
                    maze.get(currentRowPosition + 1).set(currentColumnPosition, "0");

                    // clear path 2. step
                    maze.get(currentRowPosition + 2).set(currentColumnPosition, "0");
                    // +3 and +1 is just to get the names right.
                    //testMode System.out.println("make path DOWN to : roww,column("+ (currentRowPosition+3)+","+(currentColumnPosition+1)+")" );

                    // save the position we just came from. will be used in back tracking:
                    // Set  previous position to current:
                    previousRowPosition = currentRowPosition;
                    previousColumnPosition = currentColumnPosition;


                    // set new position:
                    // we move 2 steps up to our new position.
                    // Notice only currentColumnPosition is changed
                    currentRowPosition = currentRowPosition + 2;
                    //testMode System.out.println("currentColumnPosition :"+currentColumnPosition +"currentRowPosition :" + currentRowPosition);
                    // Row position should not be changed!
                    pathCount++;
                    System.out.println("pathCount : " + pathCount);
                    resetFailedPathDirectionsArray();
                    ChoosePathAndBuild();
                }
            }

            // LEFT:
            //Try to build path to the LEFT
            else if (randomDirection == 2) {
                //testMode System.out.println("left");

                // NO SUCCES.Its already 2 blank or theres the board ends or there is a path already,
                // then Don't make path! just backtrack
                if (
                        maze.get(currentRowPosition).get(currentColumnPosition - 2).equals("0") ||
                                maze.get(currentRowPosition).get(currentColumnPosition - 2).equals("¤") ||

                                maze.get(currentRowPosition).get(currentColumnPosition - 2).equals(" ") ||


                                // and if there are already 2 blanck pieces.
                                (
                                        maze.get(currentRowPosition).get(currentColumnPosition - 1).equals(" ") &&
                                                maze.get(currentRowPosition).get(currentColumnPosition - 2).equals(" ")

                                )
                        )


                {
                    // try an other direction
                    //testMode                         System.out.println("cant take this way LEFT!");
                    //if all directions have been tried. start BACK TRACKING!
                    if (failedPathDirections[0] == 1 && failedPathDirections[1] == 1 && failedPathDirections[2] == 1 && failedPathDirections[3] == 1) {
                        //testMode System.out.println("all directions have failed. start backtracking!");

                        //printMaze();
                        //reset failedPathDirections array,
                        // because it has to be reset for next time we need try to build a path.
                        resetFailedPathDirectionsArray();
                        // activate backtracking

                        backtracking();

                    } else {
                        //testMode                  System.out.println("try an other direction");
                        // tell the "failedPathDirections" array that the path couldent be made.
                        failedPathDirections[2] = 1;
                        ChoosePathAndBuild();
                    }

                }

                // SUCCES Make a path! LEFT
                else //if (maze.get(currentRowPosition).get(currentColumnPosition-1).equals("+")&&
                //   maze.get(currentRowPosition).get(currentColumnPosition-2).equals("+"))
                {
                    // make path
                    // -2 is because we go up so we have to use an "earlier"creaated aray
                    // clear path 1. step
                    maze.get(currentRowPosition).set(currentColumnPosition - 1, "0");

                    // clear path 2. step
                    maze.get(currentRowPosition).set(currentColumnPosition - 2, "0");
                    //testMode System.out.println("make path LEFT to : ("+ (currentRowPosition-2)+","+(currentColumnPosition-1)+")" );

                    // save the position we just came from. will be used in back tracking: or is it?????????
                    // Set  previous position to current:
                    previousRowPosition = currentRowPosition;
                    previousColumnPosition = currentColumnPosition;


                    // set new position:
                    // we move 2 steps up to our new position.
                    // row position should not be changed! only currentColumnPosition
                    currentColumnPosition = currentColumnPosition - 2;
                    //testMode System.out.println("currentColumnPosition :"+currentColumnPosition +"currentRowPosition :" +currentRowPosition);

                    pathCount++;
                    System.out.println("pathCount : " + pathCount);
                    resetFailedPathDirectionsArray();
                    ChoosePathAndBuild();
                }
            }


            // RIGHT

            else if (randomDirection == 3) {
                //testMode System.out.println("right");

                // NO SUCCES.Its already 2 blank or theres the board ends or there is a path already,
                // then Don't make path! just backtrack
                if (
                        maze.get(currentRowPosition).get(currentColumnPosition + 2).equals("0") ||
                                maze.get(currentRowPosition).get(currentColumnPosition + 2).equals("¤") ||
                                maze.get(currentRowPosition).get(currentColumnPosition + 2).equals(" ") ||
                                // and if there are already 2 blanck pieces.
                                (
                                        maze.get(currentRowPosition).get(currentColumnPosition + 1).equals(" ") &&
                                                maze.get(currentRowPosition).get(currentColumnPosition + 2).equals(" ")

                                )
                        ) {
                    // try an other direction
                    //testMode System.out.println("cant take this way right!");
                    //if all directions have been tried. start BACK TRACKING!
                    if (failedPathDirections[0] == 1 && failedPathDirections[1] == 1 && failedPathDirections[2] == 1 && failedPathDirections[3] == 1) {
                        //testMode System.out.println("all directions have failed. start backtracking!");

                        //printMaze();
                        //reset failedPathDirections array,
                        // because it has to be reset for next time we need try to build a path.
                        resetFailedPathDirectionsArray();
                        // activate backtracking
                        backtracking();

                    } else {

                        // tell the "failedPathDirections" array that the path couldent be made.
                        failedPathDirections[3] = 1;
                        ChoosePathAndBuild();
                    }

                }

                // SUCCES Make a path! Right
                else //if (maze.get(currentRowPosition).get(currentColumnPosition+1).equals("+")&&
                //   maze.get(currentRowPosition).get(currentColumnPosition+2).equals("+"))
                {
                    // make path
                    // +2 is because we go 2 to the right so we have to use an the same row
                    // clear path 1. step
                    maze.get(currentRowPosition).set(currentColumnPosition + 1, "0");

                    // clear path 2. step
                    maze.get(currentRowPosition).set(currentColumnPosition + 2, "0");
                    //testMode              System.out.println("make path RIGHT to : ("+ (currentRowPosition+2)+","+(currentColumnPosition+1)+")" );

                    // save the position we just came from. will be used in back tracking:
                    // Set  previous position to current:
                    previousRowPosition = currentRowPosition;
                    previousColumnPosition = currentColumnPosition;


                    // set new position:
                    // we move 2 steps up to our new position.
                    // Column position should not be changed!
                    currentColumnPosition = currentColumnPosition + 2;
                    //testMode                         System.out.println("currentColumnPosition :"+currentColumnPosition +"currentRowPosition :" +currentRowPosition);

                    pathCount++;
                    System.out.println("pathCount : " + pathCount);
                    resetFailedPathDirectionsArray();
                    ChoosePathAndBuild();
                }

            } else {
                System.out.println("error in ChoosePathAndBuild()!");
                ChoosePathAndBuild();
            }

            /*
            //}
            printMaze();
            // TESTING
            System.out.println("sleep ! (end of choose path methode)");
            // sleeptest
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("0,1 sec.");
            */


        }
    }

    private void backtracking()
    {
        System.out.println("pathCount: ------> :"+ pathCount);

        // follow the path back again.
        // for each time there is a path its marked with "p"
        // what happens in sudo code:

            //1. see if there are a path of 2 steps where there is marked with p
                //if yes
                    //change this path to "d" for done.
                    // and now go and check again if you can make a new path in wall.->
                    // ChoosePathAndBuild();


        System.out.println("currentColumnPosition : " + currentColumnPosition);
        System.out.println("currentRowPosition : " + currentRowPosition);

        System.out.println("Backtracking");
        //try {
        //    Thread.sleep(1);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}


        //testMode  System.out.println("***********BT**********************************************************************************************************");
        //testMode System.out.println("Blocked bactracking; blockedDirection = " + blockedDirection);
        //while(10>BackTrackTestCount)
        //{
            int randomBackTrackDirection = (int) (Math.random()*4);

        // add value into an array that checks if the value have been used.
        // when the value have been used, change the last zero("0") into (" ")
        // and proceed by adding intrance and exit, and minotaur.


        System.out.println("random backtrack direction : " + randomBackTrackDirection);


            //testMode System.out.println("randomBackTrackDirection :  "+randomBackTrackDirection);
            // SART TEST INPUT
            /*
            System.out.println("currentColumnPosition :" + currentColumnPosition + "currentRowPosition :" + currentRowPosition);


            System.out.println("enter BackTrack Direction");
            int backTrackDirection = input.nextInt();

            System.out.println("BackTrack Direction : " + backTrackDirection);
            */
            // TEST END


            //Is there any "p"  road i can walk on?

            // walk the old path and try each new old step to make a path.

            // for breaking out of the recursion loop
            // if there is only on path left.

            /*if (pathCount==1)
            {
                // end recursive loop.
                System.out.println("End recursion..");
            }*/

            // BACKTRACK UP  (0) // to go up to the next array -1,-2 are needed.
            //try Up 2 blank road steps.
            //if there are 2 "p" road steps up and we dident just come from that direction
            // then change the position to that new location.
                //(-1), is for seeing the position 1 step above, and (-2) is to see 2 steps above.
            if (maze.get(currentRowPosition - 1).get(currentColumnPosition).equals("0") &&
                    maze.get(currentRowPosition - 2).get(currentColumnPosition).equals("0")
                    && randomBackTrackDirection == 0
                    )
            {
                // if the direction 0 is blocked try an other backtrack direction
                /*if(blockedDirection==0)
                {
                    //testMode
                    System.out.println("cant backtrack UP just came from there");
                    // when all 4 idex's are changed to 1, we stop backtracking.
                    failedBackTrackingDirections[0]=1;
                    backtracking();
                }

                // if the road is not blocked, blockedDirection is not 0;
                else if(blockedDirection!=0)
                {*/
                    //testMode
                    System.out.println("BACKTRACK UP");
                    // block this direction you just came from


                    // Change the path "p" to blank " "

                    maze.get(currentRowPosition).set(currentColumnPosition," ");
                    // clear path 1. step
                    maze.get(currentRowPosition - 1).set(currentColumnPosition," ");
                    // clear path 2. step
                    //maze.get(currentRowPosition - 2).set(currentColumnPosition," ");

                    printMaze();

                    // change position up the  old road!

                    // set new position:
                    // we move 2 steps up to our new position.
                    // Notice only currentColumnPosition is changed
                    currentRowPosition = currentRowPosition - 2;
                    // and now try to make a path.
                    //testMode System.out.println("Backtracking .. UP THE OLD PATH");
                    //testMode System.out.println("currentColumnPosition :" + currentColumnPosition + " currentRowPosition :" + currentRowPosition);
                    BackTrackTestCount++;
                    //maze.get(currentRowPosition).set(currentColumnPosition, "X");


                    // block direction, 0 so we cant go down.
                    blockedDirection = 1;

                    //printMaze();



                    //resetfailedBackTrackingDirections();

                    // now we made a backtracking move so we subtract the move, will be used to break the loop.
                    pathCount--;
                    System.out.println("pathCount ---------->: "+pathCount);
                    ChoosePathAndBuild();
                /*}
                else
                 System.out.println("FAIL BACKTRACK");
                */

            }
            // blockedDirection !=1  means the path is not blocked.



            //BACKTRACK DOWN


            else if (maze.get(currentRowPosition + 1).get(currentColumnPosition).equals("0") &&
                    maze.get(currentRowPosition + 2).get(currentColumnPosition).equals("0")
                    && randomBackTrackDirection == 1
                    )
            {
                /*if(blockedDirection == 1)
                {
                    //testMode
                    System.out.println("cant backtrack DOWN just came from there");
                    // when all 4 idex's are changed to 1, we stop backtracking.
                    System.out.println("index 1 = 1");
                    failedBackTrackingDirections[1]=1;
                    backtracking();
                }
                // if the road is not blocked, smame as blockedDirection is not 1;
                else if(blockedDirection!=1)
                {*/
                    System.out.println("backtrack down");


                    System.out.println("currentColumnPosition : " + currentColumnPosition);
                    System.out.println("currentRowPosition : " + currentRowPosition);


                    maze.get(currentRowPosition).set(currentColumnPosition," ");
                    maze.get(currentRowPosition + 1).set(currentColumnPosition," ");
                    //maze.get(currentRowPosition + 2).set(currentColumnPosition," ");
                    printMaze();
                    // change position down the  old road!
                    // set new position:
                    // we move 2 steps up to our new position.
                    // Notice only currentColumnPosition is changed
                    currentRowPosition = currentRowPosition + 2;
                    // and now try to make a path.

                    //testMode System.out.println("Backtracking .. DOWN THE OLD PATH");
                    //testMode System.out.println("currentColumnPosition :" + currentColumnPosition + " currentRowPosition :" + currentRowPosition);
                    //maze.get(currentRowPosition).set(currentColumnPosition, "y");
                    //printMaze();
                    //System.out.println("you just took one step down, now block down going direction");

                    // block direction , 0 for Up.
                    // this might seem a bit bit tricky remember we have to be able to block the opposite direction of where we came

                    blockedDirection =0;
                    //testMode System.out.println("we just backtracked one step down now we cant go up.");
                    BackTrackTestCount++;
                    resetfailedBackTrackingDirections();
                    // now we made a backtracking move so we subtract the move, will be used to break the loop.
                    pathCount--;
                    System.out.println("pathCount : "+pathCount);

                    ChoosePathAndBuild();
                /*}
                else
                    System.out.println("FAIL BACKTRACK");
                */
            }

            //BACKTRACK LEFT (the minus sign is for going to the left)
            else if (maze.get(currentRowPosition).get(currentColumnPosition - 1).equals("0") &&
                    maze.get(currentRowPosition).get(currentColumnPosition - 2).equals("0")
                    && randomBackTrackDirection == 2
                    )
            {
                /*if(blockedDirection ==2)
                {
                    //testMode
                    System.out.println("cant backtrack LEFT just came from there");
                    // when all 4 idex's are changed to 1, we stop backtracking.
                    failedBackTrackingDirections[2]=1;
                    backtracking();
                }

                // if the road is not blocked, smame as blockedDirection is not 1;
                else if(blockedDirection!=2)
                {*/
                    System.out.println("backtrack left");
                    // change p to " "


                    maze.get(currentRowPosition).set(currentColumnPosition," ");
                    maze.get(currentRowPosition).set(currentColumnPosition - 1," ");
                    //maze.get(currentRowPosition).set(currentColumnPosition - 2," ");
                    printMaze();


                    // change position down the  old road!
                    // set new position:
                    // we move 2 steps up to our new position.
                    // Notice only currentColumnPosition is changed
                    currentColumnPosition = currentColumnPosition - 2;
                    // and now try to make a path.

                    //testMode System.out.println("Backtracking ..LEFT on THE OLD PATH");
                    //testMode System.out.println("currentColumnPosition :" + currentColumnPosition + " currentRowPosition :" + currentRowPosition);

                    //maze.get(currentRowPosition).set(currentColumnPosition, "z");
                    //printMaze();

                    // block direction, 3 so we cant go left we just came from left
                    blockedDirection = 3;

                    // now we made a backtracking move so we subtract the move, will be used to break the loop.

                    pathCount--;
                    System.out.println("pathCount : "+pathCount);
                    ChoosePathAndBuild();
                /*}
                else
                    System.out.println("FAIL BACKTRACK");
                */

            }


            //BACKTRACK RIGHT
            else if (maze.get(currentRowPosition).get(currentColumnPosition + 1).equals("0") &&
                    maze.get(currentRowPosition).get(currentColumnPosition + 2).equals("0")
                    && randomBackTrackDirection == 3)
            {

                /*if(blockedDirection ==3)
                {
                    //testMode
                    System.out.println("cant backtrack right its blank , - failedBackTrackingDirections[0]=1");
                    // when all 4 idex's are changed to 1, we stop backtracking.
                    failedBackTrackingDirections[0]=1;

                    backtracking();
                }
                // if the road is not blocked, smame as blockedDirection is not 1;
                else if(blockedDirection!=3)
                {*/
                    System.out.println("backtrack right");

                    maze.get(currentRowPosition).set(currentColumnPosition," ");
                    maze.get(currentRowPosition).set(currentColumnPosition + 1," ");
                    //maze.get(currentRowPosition).set(currentColumnPosition + 2," ");
                    printMaze();
                    // change position down the  old road!
                    // set new position:
                    // we move 2 steps up to our new position.
                    // Notice only currentColumnPosition is changed
                    currentColumnPosition = currentColumnPosition + 2;
                    // and now try to make a path.

                    //testMode System.out.println("Backtracking ..RIGHT on THE OLD PATH");
                    //testMode System.out.println("currentColumnPosition :" + currentColumnPosition + " currentRowPosition :" + currentRowPosition);
                    //maze.get(currentRowPosition).set(currentColumnPosition, "A");
                    //printMaze();

                    // block direction, 2 so we cant go right we just came from right
                    blockedDirection = 2;
                    // now we made a backtracking move so we subtract the move, will be used to break the loop.

                    pathCount--;
                    System.out.println("pathCount : "+pathCount);
                    ChoosePathAndBuild();
                /*}
                else
                    System.out.println("FAIL BACKTRACK");
                */
            }
            else
            {
                //testMode
                System.out.println("BACK TRACKING trying to find New direction randomly. ");
                System.out.println("failedBackTrackingDirections  :"+failedBackTrackingDirections[0]+failedBackTrackingDirections[1]+
                        failedBackTrackingDirections[2]+failedPathDirections[3]);
                backtracking();
            }
        //}


        //System.out.println("no more tries");
        //maze.get(currentRowPosition).set(currentColumnPosition, "A");
        //printMaze();





    }

    private void resetfailedBackTrackingDirections()
    {
        // reset all 4 places in the array so we can do a new backtracing
        for (int i = 0; i <4 ; i++)
        {
            failedBackTrackingDirections[i]=0;
        }
    }

    private void resetFailedPathDirectionsArray()

    {
        // reset all 4 places in the array so we can try to make an other path.
        for (int i = 0; i <4 ; i++)
        {
        failedPathDirections[i]=0;
        }
    }

    private void rebuild()
    {

            System.out.println("rebuild a new one? y? n? ");



            System.out.println("enter answer");
            String answer = input.nextLine();
            System.out.println("your  answer is: " + answer);

            try
            {
                if(answer.equals("y"))
                {
                    generateBoard();
                    rebuild();
                }
                else if(answer.equals("n"))
                {
                    System.out.println(" now exit");
                }
                else
                {
                    System.out.println("try again, only  small letters!");
                    rebuild();
                    System.out.println("no rebuild generation happened");
                }

            }
            catch (IndexOutOfBoundsException e)
            {
                System.err.println("IndexOutOfBoundsException: " + e.getMessage());
                rebuild();
            }
    }

    private void makeStartPositionForPathbuilding()
    {

        // if startRow=2 and startColumn=2 its like 1,1 like a coordinate system that starts in the left corner.
        // makes a number 0-height or width (it also makes 0)
        startRow = 2;// (int)(Math.random() *height )+2; // the higher the number the further down the board you go
        // startColumn has to be an even number to make nice mazes. otherwise the maze will have green eges..
        startColumn =2;//(int)(Math.random() *width )+2;// the higher the number the further right the board you go
        System.out.println("startColumn ->"+startColumn);
        // vil være første koordinatet:
        // startRow=2;
        //startColumn=2;

        maze.get(startRow).set(startColumn,"0");
        //maze.get(startRow).set(startColumn+1,"0");

        // husk
        System.out.println("start position: ("+(startRow-1)+","+(startColumn-1)+")");
        currentRowPosition=startRow;
        currentColumnPosition=startColumn;
        System.out.println("currentRowPosition  "+currentRowPosition);
        System.out.println("currentColumnPosition  "+currentColumnPosition);
        pathCount++;


    }

    public void printMaze()
    {


        for (int j = 0; j <totalHeight ; j++)
        {
            System.out.print(j+"\t");
            for (int i = 0; i <totalWidth ; i++)
            {

                System.out.print(maze.get(j).get(i));

            }
            System.out.println();
        }
        System.out.println();

    }


    public void fillMaze()
    {

        ArrayList<String> border = new ArrayList<String>();
        for (int j = 0; j <totalWidth ; j++)
        {
            border.add("¤");

        }
        // add the boarder 2 on top
        maze.add(border);
        maze.add(border);

        // make each row
        for (int i = 0; i < height ; i++)
        {

            ArrayList<String> list = new ArrayList<String>();
            list.add("¤");
            list.add("¤");
            for (int j = 0; j <width ; j++)
            {
                list.add(" ");

            }
            list.add("¤");
            list.add("¤");
            maze.add(list);
        }
        // 2 in the bottom
        maze.add(border);
        maze.add(border);
    }

    public void passInstanceOfRecursiveBacktracker(Game game) {
        this.game = game;
    }


    public void test() {
        System.out.println("test");
    }

    public void addTreeObjectAndpaseInstances(Tree tree, Lake lake) {
        this.tree = tree;
        this.lake = lake;
    }

    public void calculateMoneyEarnedFromTrees() {
        //what is the amount of trees




    }
}
