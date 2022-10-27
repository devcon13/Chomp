import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
public class MyPlayer {

    public Chip[][] gameBoard;
    public int[] columns;
    public int num1, num2, num3;

    public int[] num;
    public int[] possNum;
    ArrayList<int[]> boards = new ArrayList<int[]>();
    ArrayList<int[]> LBoards = new ArrayList<int[]>();
    ArrayList<int[]> WBoards = new ArrayList<int[]>();
    ArrayList<int[]> possBoards = new ArrayList<int[]>();

    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */

        for (int x = 1; x <= 3; x++) { // first number
            for (int y = 0; y <= x; y++) { // second number
                for (int z = 0; z <= y; z++) { // third number
                    num = new int[3];
                    num[0] = x;
                    num[1] = y;
                    num[2] = z;
                    boards.add(num);
                    if(num[0]==1 && num[1]==0 && num[2]==0){
                        LBoards.add(num);
                    }

/*
                    for (int c = 1; c <= z; c++) { // LVL 1
                        possNum = new int[3];
                        possNum[0] = x;
                        possNum[1] = y;
                        possNum[2] = z - c;

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


                    }

 */
                }
            }






        /*for (int x = 3; x >= 1; x--) { // first number
            for (int y = x; y >= 0; y--) { // second number
                for (int z = y; z >= 0; z--) { // third number
                    System.out.println();
                    System.out.print("(" + x + " " + y + " " + z + ") --> ");

                    for (int c = 1; c <= z; c++) { // LVL 1
                        num1 = x;
                        num2 = y;
                        num3 = z-c;
                        System.out.print(num1 + "" + num2 + "" + num3 + ", ");
                        checkS();
                    }


                    for (int b=1; b<=y; b++){ // LVL 2
                        if(y-b>z){
                            num1 = x;
                            num2 = y-b;
                            num3 = z;
                            System.out.print(num1 + "" + num2 + "" + num3 + ", ");
                            checkS();
                        }
                        else {
                            num1 = x;
                            num2 = y-b;
                            num3 = y-b;
                            System.out.print(num1 + "" + num2 + "" + num3 + ", ");
                            checkS();
                        }
                    }
                    if(num1==1 && num2==0 && num3==0){
                        WS=true;
                    }

                        for (int a = 1; a <= x - 1; a++) { // LVL 3
                            if (x - a > y) {
                                num1 = x - a;
                                num2 = y;
                                num3 = y;
                                System.out.print(num1 + "" + num2 + "" + num3 + ", ");
                                checkS();
                            } else {
                                if (x - a > z && x - a <= y) {
                                    num1 = x - a;
                                    num2 = x - a;
                                    num3 = z;
                                    System.out.print(num1 + "" + num2 + "" + num3 + ", ");
                                    checkS();
                                } else {
                                    num1 = x - a;
                                    num2 = x - a;
                                    num3 = x - a;
                                    System.out.print(num1 + "" + num2 + "" + num3 + ", ");
                                    checkS();
                                }
                            }
                            if (num1 == 1 && num2 == 0 && num3 == 0) {
                                WS = true;
                            }
                        }
                        if (WS == true) {
                            System.out.print(" [WS]");
                            WS = false;
                            LS = false;
                        }
                        if(LS==true){
                            //System.out.print(" [LS]");
                        }
                        num1=0; // this is just so it doesn't confuse 100 with a WS
                }
            }
        }
        System.out.println(" [LS]"); // this is just so it prints 100 as a lose state
    */
        }
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

    /*public void checkS(){
        if(((num1==3 || num1==2) && num2==0 && num3==0) || (num1==1 && num2==1 && (num3==0 || num3==1))){
            LS = true;
        }
        else{
            LS = false;
        }
    }

     */
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


