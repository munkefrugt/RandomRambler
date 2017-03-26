package com.company;

import java.util.ArrayList;

/**
 * Created by v on 4/20/16.
 */
public class SolveMaze {


    private final ArrayList<ArrayList<String>> maze;

    int currentRowPosition;
    int currentColumnPosition;


    int[] failedBackTrackingDirections ={0,0,0,0};
    int[] failedPathDirections ={0,0,0,0};
    private boolean solved;


    public SolveMaze(ArrayList<ArrayList<String>> maze, int randomRowForEntrance)
    {


        this.maze= maze;
        // initialise the values
        currentRowPosition=randomRowForEntrance;
        //
        currentColumnPosition=2;
        // set the first solving trail.
        maze.get(currentRowPosition).set(currentColumnPosition,"T");

        // test if they are all 0's
        System.out.println("failedPathDirections[0] :" +failedPathDirections[0]+
                "\nfailedPathDirections[1] :" +failedPathDirections[1]+
                "\nfailedPathDirections[2] :" +failedPathDirections[2]+
                "\nfailedPathDirections[3] :" +failedPathDirections[3]);


        chooseSolvingDir();

    }





    private void BactrackOnSolvingPath() {
        // in this method we change the T' to D's so we can see we have been there.
        // D stands for Dead end.

        System.out.println("start backtrack with D's " );

        int randomBactrackDirection = (int) (Math.random()*4);

        // if the
         if(failedBackTrackingDirections[0] == 1 && failedBackTrackingDirections[1] == 1 && failedBackTrackingDirections[2] == 1 && failedBackTrackingDirections[3] == 1)
        {
            System.out.println("finshed backtracking");
            // go back to making trails
            chooseSolvingDir();


        }
         else {
             if (solved == true) {
                 System.out.println("done No more backtracking please");
                 //break;
             }
             // choose backtrack diriction.
             else {
                 // delay
                 try {
                     Thread.sleep(10);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 // DIRECTIONS:
                 // by random we are c

                 // if you are in  a downward facing dead end and going up again.

                 //Backtrack UP
                 // randomBactrackDirection = 0 and the position above is equal to "T"
                 if (randomBactrackDirection == 0 && maze.get(currentRowPosition - 1).get(currentColumnPosition).equals("T") &&
                         maze.get(currentRowPosition - 1).get(currentColumnPosition).equals("T")) {
                     // change T to S
                     // so the trail path becomes a Solved path, or a path that is the right path.

                     resetArrayBacktrackfailedDirections();

                     // make the mark the trail so we can see we have been there, and that we are not gonna go there again
                     // ("D") the D stands for Dead end
                     maze.get(currentRowPosition).set(currentColumnPosition, "D");
                     try {
                         Thread.sleep(10);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     maze.get(currentRowPosition - 1).set(currentColumnPosition, "D");

                     //change row
                     currentRowPosition = currentRowPosition - 2;
                     chooseSolvingDir();

                 }

                 //Backtrack Down
                 else if (randomBactrackDirection == 1 && maze.get(currentRowPosition + 1).get(currentColumnPosition).equals("T") &&
                         maze.get(currentRowPosition + 1).get(currentColumnPosition).equals("T")) {
                     // change T to S
                     // so the trail path becomes a Solved path, or a path that is the right path.

                     resetArrayBacktrackfailedDirections();

                     // make the mark the trail so we can see we have been there, and that we are not gonna go there again
                     // ("D") the D stands for Dead end
                     maze.get(currentRowPosition).set(currentColumnPosition, "D");
                     try {
                         Thread.sleep(10);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     maze.get(currentRowPosition + 1).set(currentColumnPosition, "D");

                     //change row
                     currentRowPosition = currentRowPosition + 2;
                     chooseSolvingDir();

                 }
                 //Backtrack Left
                 else if (randomBactrackDirection == 2 && maze.get(currentRowPosition).get(currentColumnPosition - 1).equals("T") &&
                         maze.get(currentRowPosition).get(currentColumnPosition - 2).equals("T")) {
                     // change T to S
                     // so the trail path becomes a Solved path, or a path that is the right path.

                     resetArrayBacktrackfailedDirections();

                     // make the mark the trail so we can see we have been there, and that we are not gonna go there again
                     // ("D") the D stands for Dead end
                     maze.get(currentRowPosition).set(currentColumnPosition, "D");
                     try {
                         Thread.sleep(10);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     maze.get(currentRowPosition).set(currentColumnPosition - 1, "D");

                     //change currentColumnPosition

                     currentColumnPosition = currentColumnPosition - 2;
                     chooseSolvingDir();

                 }
                 //Backtrack right
                 else if (randomBactrackDirection == 3 && maze.get(currentRowPosition).get(currentColumnPosition + 1).equals("T") &&
                         maze.get(currentRowPosition).get(currentColumnPosition + 2).equals("T")) {
                     // change T to S
                     // so the trail path becomes a Solved path, or a path that is the right path.

                     resetArrayBacktrackfailedDirections();

                     // make the mark the trail so we can see we have been there, and that we are not gonna go there again
                     // ("D") the D stands for Dead end
                     maze.get(currentRowPosition).set(currentColumnPosition, "D");
                     try {
                         Thread.sleep(10);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     maze.get(currentRowPosition).set(currentColumnPosition + 1, "D");

                     //change currentColumnPosition

                     currentColumnPosition = currentColumnPosition + 2;
                     chooseSolvingDir();


                 } else

                     System.out.println("backtrack , choose an other random path.");
                 BactrackOnSolvingPath();

             }
         }






    }

    // reset array for backtracking directions.
    private void resetArrayBacktrackfailedDirections() {
        failedBackTrackingDirections[0]=0;
        failedBackTrackingDirections[1]=0;
        failedBackTrackingDirections[2]=0;
        failedBackTrackingDirections[3]=0;

    }


    public void chooseSolvingDir()
    {
        System.out.println("chooseSolvingDir()");

        System.out.println("TEST begining of method see if they are 1, or 0!");
        System.out.println("failedPathDirections[0] :" +failedPathDirections[0]+
                "\nfailedPathDirections[1] :" +failedPathDirections[1]+
                "\nfailedPathDirections[2] :" +failedPathDirections[2]+
                "\nfailedPathDirections[3] :" +failedPathDirections[3]);

        // this method is trying to walk on the path that is already made by the labyrith generator, Now we need to solve it.
        // so first we mark the path we are walking on, and when we meet a dead end we turn around and follow the path back
        // til the next cross section. and takes the path we havent allready marked. and eventualy we will find the exit.

        // if the currentposition  is right next to the exit then break out of the recursion
        if (maze.get(currentRowPosition).get(currentColumnPosition +1).equals("F") ||
                maze.get(currentRowPosition).get(currentColumnPosition +2).equals("F"))
        {
            System.out.println("solved ***************************************************");
            solved = true;
        }

        // all directions failed. DEAD END
        else if(failedPathDirections[0] == 1 && failedPathDirections[1] == 1 && failedPathDirections[2] == 1 && failedPathDirections[3] == 1)
        {
            System.out.println("DEAD END!->BACKTRACK");
            resetArrayfailedPathDirections();
            BactrackOnSolvingPath();
        }
        // not done yet find the direction:
        else
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // choose a random direction. and mae a solutions path. so we have a trail for back tracking marked with ("T")
            int randomSolvingPath =(int)( Math.random()*4);
            System.out.println("trysolvingPath : "+ randomSolvingPath);


            //up
            if (maze.get(currentRowPosition-2).get(currentColumnPosition).equals("M") ||
                    randomSolvingPath==0 && maze.get(currentRowPosition-2).get(currentColumnPosition).equals(" ") &&
                    !maze.get(currentRowPosition -1).get(currentColumnPosition).equals("+")
                    )
            {


                System.out.println("make trail UP");
                // make a trail for backtracking:
                maze.get(currentRowPosition-1).set(currentColumnPosition,"T");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                maze.get(currentRowPosition-2).set(currentColumnPosition,"T");

                //change row
                currentRowPosition= currentRowPosition-2;
                resetArrayfailedPathDirections();
                chooseSolvingDir();

            }

            //down
            else if(maze.get(currentRowPosition+2).get(currentColumnPosition).equals("M") ||
                    randomSolvingPath==1 && maze.get(currentRowPosition+2).get(currentColumnPosition).equals(" ")
                    && !maze.get(currentRowPosition +1).get(currentColumnPosition).equals("+"))
            {
                System.out.println("make trail DOWN");

                maze.get(currentRowPosition+1).set(currentColumnPosition , "T");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                maze.get(currentRowPosition+2).set(currentColumnPosition , "T");

                //change row
                currentRowPosition= currentRowPosition+2;

                resetArrayfailedPathDirections();
                chooseSolvingDir();
            }

            //left
            else if(maze.get(currentRowPosition).get(currentColumnPosition-2).equals("M") ||
            randomSolvingPath==2 && maze.get(currentRowPosition).get(currentColumnPosition-2).equals(" ") &&
                    !maze.get(currentRowPosition).get(currentColumnPosition -1).equals("+"))
            {
                System.out.println("make trail LEFT");

                //delay
                maze.get(currentRowPosition).set(currentColumnPosition - 1, "T");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                maze.get(currentRowPosition).set(currentColumnPosition - 2, "T");


                // change column to new position
                currentColumnPosition = currentColumnPosition -2;

                resetArrayfailedPathDirections();
                chooseSolvingDir();
            }
            //right
            else if(maze.get(currentRowPosition).get(currentColumnPosition+2).equals("M") ||
                    randomSolvingPath==3 && maze.get(currentRowPosition).get(currentColumnPosition +2).equals(" ")
                    && !maze.get(currentRowPosition).get(currentColumnPosition +1).equals("+")
                    )
            {
                System.out.println("make trail RIGHT");


                //make to  Trails.
                maze.get(currentRowPosition).set(currentColumnPosition + 1, "T");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                maze.get(currentRowPosition).set(currentColumnPosition + 2, "T");


                // change column to new position
                currentColumnPosition = currentColumnPosition +2;


                resetArrayfailedPathDirections();

                // recurse:
                chooseSolvingDir();


            }

            else
            {
                System.out.println("we cant take this way : (nb is a direction) " + randomSolvingPath);
                System.out.println("TEST array!");
                System.out.println("failedPathDirections[0] :" +failedPathDirections[0]+
                        "\nfailedPathDirections[1] :" +failedPathDirections[1]+
                        "\nfailedPathDirections[2] :" +failedPathDirections[2]+
                        "\nfailedPathDirections[3] :" +failedPathDirections[3]);

                System.out.println();
                // make sure that this direction gets saved in the failed dirctions array.
                failedPathDirections[randomSolvingPath]=1;
                // show the array, to see if its full of 1's
                System.out.println("failedPathDirections[0] :" +failedPathDirections[0]+
                        "\nfailedPathDirections[1] :" +failedPathDirections[1]+
                        "\nfailedPathDirections[2] :" +failedPathDirections[2]+
                        "\nfailedPathDirections[3] :" +failedPathDirections[3]);




                // recurse
                chooseSolvingDir();
            }

        }

    }

    // reset array. make all values 0's
    private void resetArrayfailedPathDirections() {

        failedPathDirections[0]=0;
        failedPathDirections[1]=0;
        failedPathDirections[2]=0;
        failedPathDirections[3]=0;
    }


}
