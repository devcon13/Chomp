import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
public class MyPlayer {

    public Chip[][] gameBoard;
    public int[] columns;
    public int num1, num2, num3;

    public int counter;
    public int count1;

    public int[] num;
    public int[] possNum;
    ArrayList<int[]> boards = new ArrayList<int[]>();
    ArrayList<int[]> LBoards = new ArrayList<int[]>();
    ArrayList<int[]> WBoards = new ArrayList<int[]>();
    ArrayList<int[]> possBoards = new ArrayList<int[]>();

    public boolean loseBoard;

    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */


        // to check for a winning/losing board, check the current board against the current arraylist of boards you have.

        for (int x = 1; x <= 3; x++) { // first number
            for (int y = 0; y <= x; y++) { // second number
                for (int z = 0; z <= y; z++) { // third number
                    possBoards.clear();
                    num = new int[3];
                    num[0] = x;
                    num[1] = y;
                    num[2] = z;
                    boards.add(num);
                    possNum = new int[3];
                    possNum[0]=0;
                    possNum[1]=0;
                    possNum[2]=0;


                    for (int c = 1; c <= z; c++) { // LVL 1
                        possNum = new int[3];
                        possNum[0] = x;
                        possNum[1] = y;
                        possNum[2] = z - c;
                        System.out.print(Arrays.toString(possNum)+"HERE 1");
                        possBoards.add(possNum);


                        checkOneZeroZero();
                        count1++;
                    }


                    for (int b = 1; b <= y; b++) { // LVL 2
                        if (y - b > z) {
                            possNum[0] = x;
                            possNum[1] = y - b;
                            possNum[2] = z;
                        } else {
                            possNum[0] = x;
                            possNum[1] = y - b;
                            possNum[2] = y - b;
                        }
                        for(int[] i : possBoards){
                            System.out.print(Arrays.toString(i)+ "HERE 2");
                        }
                        possBoards.add(possNum);
                        for(int[] i : possBoards){
                            System.out.print(Arrays.toString(i)+"HERE 3");
                        }
                        checkOneZeroZero();
                        count1++;
                    }

                    for (int a = 1; a <= x - 1; a++) { // LVL 3
                        if (x - a > y) {
                            possNum[0] = x - a;
                            possNum[1] = y;
                            possNum[2] = y;
                        } else {
                            if (x - a > z && x - a <= y) {
                                possNum[0] = x - a;
                                possNum[1] = x - a;
                                possNum[2] = z;

                            } else {
                                possNum[0] = x - a;
                                possNum[1] = x - a;
                                possNum[2] = x - a;
                            }
                        }
                        possBoards.add(possNum);
                        checkOneZeroZero();
                        count1++;
                    }
                    System.out.print(Arrays.toString(num)+"       ");
                    for(int[] i : possBoards){
                        System.out.print(Arrays.toString(i));
                    }
                    checkLoseBoard();
                }
            }
        }



        System.out.println();
        System.out.println("All Possible Boards:");
        for (int[] i : boards) {
            System.out.print(Arrays.toString(i)+" ");
        }
        System.out.println();
        System.out.println("Losing Boards: ");
        for (int[] i : LBoards) {
            System.out.print(Arrays.toString(i)+" ");
        }
        System.out.println();
        System.out.println("Winning Boards: ");
        for (int[] i : WBoards) {
            System.out.print(Arrays.toString(i)+" ");
        }
    }

    public void checkOneZeroZero(){ // if an outcome is 100, its automatically a winning board.
        if(possNum[0]==1 && possNum[1]==0 && possNum[2]==0){
            WBoards.add(num);
        }
    }

    public void checkLoseBoard(){ // if all of a board's outcomes are Win boards, it's a lose board.
        counter=0;
        for(int[] x : possBoards) {
            for (int[] i : WBoards) {
                if(Arrays.toString(x).equals(Arrays.toString(i))){
                    //System.out.println(Arrays.toString(x)+" "+Arrays.toString(i));
                    counter++;
                    break;
                }
            }
        }
        System.out.println(counter+"  "+ count1);
        System.out.println();
        if(counter==count1){
            LBoards.add(num);
        }
        count1 = 0;
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


