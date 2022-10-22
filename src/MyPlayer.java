import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    public int num1, num2, num3;
    public boolean WS;

    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */

        for (int x = 3; x >= 1; x--) { // first number
            for (int y = x; y >= 0; y--) { // second number
                for (int z = y; z >= 0; z--) { // third number
                    System.out.println();
                    System.out.print("(" + x + " " + y + " " + z + ") --> ");

                    for (int c = 1; c <= z; c++) { // LVL 1
                        num1 = x;
                        num2 = y;
                        num3 = z-c;
                        System.out.print(num1 + "" + num2 + "" + num3 + ", ");
                    }
                    if(num1==1 && num2==0 && num3==0){
                        WS=true;
                    }


                    for (int b=1; b<=y; b++){ // LVL 2
                        if(y-b>z){
                            num1 = x;
                            num2 = y-b;
                            num3 = z;
                            System.out.print(num1 + "" + num2 + "" + num3 + ", ");
                        }
                        else {
                            num1 = x;
                            num2 = y-b;
                            num3 = y-b;
                            System.out.print(num1 + "" + num2 + "" + num3 + ", ");
                        }
                    }
                    if(num1==1 && num2==0 && num3==0){
                        WS=true;
                    }


                    for (int a=1; a<=x-1; a++){ // LVL 3
                        if(x-a>y){
                            num1 = x-a;
                            num2 = y;
                            num3 = y;
                            System.out.print(num1 + "" + num2 + "" + num3 + ", ");
                        }
                        if(x-a>z && x-a<=y){
                            num1 = x-a;
                            num2 = x-a;
                            num3 = z;
                            System.out.print(num1 + "" + num2 + "" + num3 + ", ");
                        }
                        else {
                            num1 = x-a;
                            num2 = x-a;
                            num3 = x-a;
                            System.out.print(num1 + "" + num2 + "" + num3 + ", ");;
                        }
                        if(num1==1 && num2==0 && num3==0){
                            WS=true;
                        }
                    }
                    if(WS==true){
                        System.out.print(" WS");
                        WS = false;
                    }
                }
            }
        }
        System.out.println(" LS");
    }

    public Point move(Chip[][] pBoard) {

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
