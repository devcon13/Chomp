import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
public class MyPlayer {

    public Chip[][] gameBoard;
    public int[] columns;

    public int[] cols;

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

        for (int x = 1; x <= 3; x++) { // first number
            for (int y = 0; y <= x; y++) { // second number
                for (int z = 0; z <= y; z++) { // third number
                    tempBoard = new Board(x,y,z);
                    findBestMove();
                    boards.add(tempBoard);
                    checkWinBoard();
                    checkLoseBoard();
                }
            }
        }

        // Print out possible boards w/ their best move, all boards in the lose boards array, all boards in the win boards array
        System.out.println();
        System.out.println("all possible boards ");
        for (Board i : boards) {
            System.out.println(i.num[0]+""+i.num[1]+""+i.num[2]+" best move "+Arrays.toString(i.bestMove));
        }
        System.out.println();
        System.out.println("lose boards ");
        for (Board i : LBoards) {
            System.out.print(i.num[0]+""+i.num[1]+""+i.num[2]+" ");
        }
        System.out.println();
        System.out.println("win boards ");
        for (Board i : WBoards) {
            System.out.print(i.num[0]+""+i.num[1]+""+i.num[2]+" ");
        }
    }

    public void findBestMove(){
        int movesToWin = 1000;
        for(int[] i : tempBoard.possBoards){
            for(Board x : LBoards){
                if(Arrays.toString(i).equals("["+x.num[0]+", "+x.num[1]+", "+x.num[2]+"]")){ // if the possboard is a winning board...
                    if(x.num[0]+x.num[1]+x.num[2]<movesToWin){ // if the possboard takes less moves to win than the previous recorded best move... this possboard is the best move
                        tempBoard.bestMove=i;
                    }
                }
            }
        }
        if(tempBoard.bestMove==null){ // if, after running through the loops above, there's still no best move (aka it's a losing board)
            for(int[] i : tempBoard.possBoards){ // just pick the last possboard that the board has (kinda random)
                tempBoard.bestMove=i;
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

            row = 3;
            column = 3;

            /***
             * This code will run each time the "MyPlayer" button is pressed.
             * Add your code to return the row and the column of the chip you want to take.
             * You'll be returning a data type called Point which consists of two integers.
             */

            for(int i = 0; i<gameBoard.length; i++){
                System.out.print(gameBoard[0][i].isAlive);
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
                System.out.print(cols[y]);
            }

            currentBoard = new Board(cols[0], cols[1], cols[2]);
            for(Board i : boards){
                if(currentBoard.num[0] == i.num[0] && currentBoard.num[1] == i.num[1] && currentBoard.num[2] == i.num[2]){
                    currentBoard = i;
                    System.out.println(currentBoard.bestMove[0]+""+currentBoard.bestMove[1]+""+currentBoard.bestMove[2]);
                }
            }

            int newCount=0;
            int newThing=0;
            for(int i=0; i<currentBoard.bestMove.length; i++){
                if(currentBoard.num[i]==currentBoard.bestMove[i]){
                    newCount++;
                }
                else{
                    break;
                }
            }

            newThing = currentBoard.bestMove[newCount];

            System.out.println(newCount+""+newThing);

            row = newCount;
            column = newThing;

            Point myMove = new Point(row, column);
            return myMove;
        }
    }


