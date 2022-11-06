import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
public class MyPlayer {

    public Chip[][] gameBoard;
    public int[] columns;

    public int counter; // keeps track of how many possible outcomes are win states

    public Board tempBoard;


    ArrayList<Board> boards = new ArrayList<Board>();
    ArrayList<Board> LBoards = new ArrayList<Board>();
    ArrayList<Board> WBoards = new ArrayList<Board>();
    public boolean pleaseBreak;

    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */



        // PRIMARY OUTER LOOP. GENERATE BOARDS.
        for (int x = 1; x <= 3; x++) { // first number
            for (int y = 0; y <= x; y++) { // second number
                for (int z = 0; z <= y; z++) { // third number

                    tempBoard = new Board(x,y,z);

                    boards.add(tempBoard);
                    checkWinBoard();
                    checkLoseBoard();
                }
            }
        }



        System.out.println();
        System.out.println("All Possible Boards:");
        for (Board i : boards) {
            System.out.print(i.num[0]+""+i.num[1]+""+i.num[2]);
        }
        System.out.println();
        System.out.println("Losing Boards: ");
        for (Board i : LBoards) {
            System.out.print(i.num[0]+""+i.num[1]+""+i.num[2]);
        }
        System.out.println();
        System.out.println("Winning Boards: ");
        for (Board i : WBoards) {
            System.out.print(i.num[0]+""+i.num[1]+""+i.num[2]);
        }
    }

    public void checkLoseBoard(){ // if all of a board's outcomes are Win boards, it's a lose board.
        counter=0;
        for(int[] x : tempBoard.possBoards) {
            for (Board i: WBoards) {
                if(Arrays.toString(x).equals("["+i.num[0]+", "+i.num[1]+", "+i.num[2]+"]")){
                    counter++;
                }
            }
        }
        System.out.println(counter+" win boards out of "+ tempBoard.count1);
        System.out.println();
        if(counter== tempBoard.count1){
            LBoards.add(tempBoard);
        }
    }

    public void checkWinBoard(){ // if the board produces a lose board its automatically a win state
        pleaseBreak=false;
        for(int[] x : tempBoard.possBoards) {
            for (Board i: LBoards) {
                if(pleaseBreak==true){
                    break;
                }
                if(Arrays.toString(x).equals("["+i.num[0]+", "+i.num[1]+", "+i.num[2]+"]")){
                    WBoards.add(tempBoard);
                    pleaseBreak=true;
                    break;
                }
            }
        }
    }


    public Point move (Chip[][]pBoard){

            System.out.println("MyPlayer Move");

            gameBoard = pBoard;
            int column = 0;
            int row = 0;

            row = 1;
            column = 1;

            /***
             * This code will run each time the "MyPlayer" button is pressed.
             * Add your code to return the row and the column of the chip you want to take.
             * You'll be returning a data type called Point which consists of two integers.
             */

            Point myMove = new Point(row, column);
            return myMove;
        }

    }


