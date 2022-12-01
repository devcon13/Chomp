import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
public class MyPlayer {

    public Chip[][] gameBoard;
    public int[] columns;
    public int[] cols;
    public int count;

    public int counter; // keeps track of how many possible outcomes are win states
    public Board tempBoard; // temporary placeholder to generate the board in order to put into the arrayList
    public Board currentBoard;

    ArrayList<Board> boards = new ArrayList<Board>();
    ArrayList<Board> LBoards = new ArrayList<Board>();
    ArrayList<Board> WBoards = new ArrayList<Board>();

    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */

        for (int a = 1; a <= 10; a++) { // 1
            for (int b = 0; b <= a; b++) { // 2
                for (int c = 0; c <= b; c++) { // 3
                    for (int d = 0; d <= c; d++) { // 4
                        for (int e = 0; e <= d; e++) { // 5
                            for (int f = 0; f <= e; f++) { // 6
                                for (int g = 0; g <= f; g++) { // 7
                                    for (int h = 0; h <= g; h++) { // 8
                                        for (int i = 0; i <= h; i++) { // 9
                                            for (int j = 0; j <= i; j++) { // 10
                                                count++;
                                                tempBoard = new Board(a, b, c, d, e, f, g, h, i, j);
                                                findBestMove();
                                                boards.add(tempBoard);
                                                checkWinBoard();
                                                checkLoseBoard();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Print out possible boards w/ their best move, all boards in the lose boards array, all boards in the win boards array
        /*System.out.println();
        System.out.println("all possible boards ");
        for (Board i : boards) {
            System.out.println(Arrays.toString(i.num));
        }
        System.out.println();
        System.out.println("lose boards ");
        for (Board i : LBoards) {
            System.out.println(Arrays.toString(i.num));
        }
        System.out.println();
        System.out.println("win boards ");
        for (Board i : WBoards) {
            System.out.println(Arrays.toString(i.num));
        }
        System.out.println(count);

         */
    }



    public void findBestMove(){
        boolean pleaseBreak = false;
        for(int[] i : tempBoard.possBoards){
            if(pleaseBreak==true){
                break;
            }
            for(Board x : LBoards){
                if(Arrays.toString(i).equals("["+x.num[0]+", "+x.num[1]+", "+x.num[2]+"]")){ // if the possboard is a winning board...
                    tempBoard.bestMove=i;
                    pleaseBreak=true;
                    break;
                }
            }
        }
        int movesToLose=0;
        if(tempBoard.bestMove==null){ // if, after running through the loops above, there's still no best move (aka it's a losing board)
            for(int[] i : tempBoard.possBoards){
                if(i[0]+i[1]+i[2]>=movesToLose){ // just pick the possboard that leaves you with the most chips left on the board
                    movesToLose=i[0]+i[1]+i[2];
                    tempBoard.bestMove=i;
                }
            }
        }
    }

    public void checkLoseBoard(){ // if all of a board's possboards are winboards, put it in the loseboard array.
        counter=0; // keeps track of the number of win boards
        for(int[] x : tempBoard.possBoards) {
            for (Board i: WBoards) {
                if(Arrays.toString(x).equals("["+i.num[0]+", "+i.num[1]+", "+i.num[2]+"]")){
                    counter++;
                }
            }
        }
        if(counter==tempBoard.count1){  // if the number of possboards equals the number of counted winboards above...
            LBoards.add(tempBoard);
        }
    }

    public void checkWinBoard(){ // if one of the board's possboards is a lose board, put it in the winboard array.
        boolean pleaseBreak=false;
        for(int[] x : tempBoard.possBoards) {
            for (Board i: LBoards) {
                if(pleaseBreak==true){ // if true, prohibits loop from continuing
                    break;
                }
                if(Arrays.toString(x).equals("["+i.num[0]+", "+i.num[1]+", "+i.num[2]+"]")){
                    WBoards.add(tempBoard);
                    pleaseBreak=true; // if already found a win board, don't keep looping through board
                }
            }
        }
    }

    public Point move (Chip[][]pBoard){

            System.out.println("MyPlayer Move");

            gameBoard = pBoard;
            int column = 0;
            int row = 0;


            // use current board to make a board

            /***
             * This code will run each time the "MyPlayer" button is pressed.
             * Add your code to return the row and the column of the chip you want to take.
             * You'll be returning a data type called Point which consists of two integers.
             */

            /*for(int i = 0; i<gameBoard.length; i++){
                //System.out.print(gameBoard[0][i].isAlive);
                if(gameBoard[0][i].isAlive == false){
                    System.out.println();
                    cols = new int [10];
                    System.out.println(i);
                    break;
                }
                if(gameBoard[0][i]==gameBoard[0][9]){
                    System.out.println();
                    cols = new int [10];
                    System.out.println(10);
                    break;
                }
            }

            for(Chip[] x : gameBoard){
                for(int i=0; i<cols.length; i++){
                    if(x[i].isAlive == true){
                        cols[i]++;
                    }
                }
            }

            for(int y=0; y<cols.length; y++){
                //System.out.print(cols[y]);
            }

            currentBoard = new Board(cols[0], cols[1], cols[2], 0, 0, 0, 0, 0, 0, 0);

        if(currentBoard.num[0]!=1 || currentBoard.num[1]!=0 || currentBoard.num[2]!=0) {
            for (Board i : boards) {
                if (currentBoard.num[0] == i.num[0] && currentBoard.num[1] == i.num[1] && currentBoard.num[2] == i.num[2]) {
                    currentBoard = i;
                    //System.out.println(currentBoard.bestMove[0] + "" + currentBoard.bestMove[1] + "" + currentBoard.bestMove[2]);
                }
            }
        }

        currentBoard.translate();
        row = currentBoard.bestRow;
        column = currentBoard.bestCol;

             */

        row=8;
        column=7;

            Point myMove = new Point(row, column);
            return myMove;
        }
    }


