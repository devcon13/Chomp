import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class MyPlayer {

    public Chip[][] gameBoard;
    public int[] columns;
    public int[] cols;
    public int[] possNum;

    public Board tempBoard; // temporary placeholder to generate the board in order to put into the arrayList
    public Board currentBoard;

    ArrayList<int[]> LBoards = new ArrayList<int[]>();
    ArrayList<int[]> tempPossBoards = new ArrayList<int[]>();
    ArrayList<String> losBoards = new ArrayList<String>();

    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
        /*standard=new int[10];
        standard[0]=1;
        for(int i=1; i<10; i++){
            standard[i]=0;
        }
        System.out.println(Arrays.toString(standard));
        LBoards.add(standard);

         */


        //tempBoard = new Board (0,0,0,0,0,0,0,0,0,0);


        /*for (int a = 1; a <= 10; a++) { // 1
            for (int b = 0; b <= a; b++) { // 2
                for (int c = 0; c <= b; c++) { // 3
                    for (int d = 0; d <= c; d++) { // 4
                        for (int e = 0; e <= d; e++) { // 5
                            for (int f = 0; f <= e; f++) { // 6
                                for (int g = 0; g <= f; g++) { // 7
                                    for (int h = 0; h <= g; h++) { // 8
                                        for (int i = 0; i <= h; i++) { // 9
                                            for (int j = 0; j <= i; j++) { // 10
                                                tempBoard = new Board (a,b,c,d,e,f,g,h,i,j);
                                                getPossBoards(tempBoard);
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

         */

        // READS FILE + CREATES ARRAY OF LOSE BOARDS

        try {
            File loseBoards = new File("loseboards.txt");
            Scanner myReader = new Scanner(loseBoards);
            while (myReader.hasNextLine()) {
                losBoards.add(myReader.nextLine());
            }
            myReader.close();
            for(String i: losBoards){
                System.out.println(i);
            }
        } catch (IOException e){
            e.printStackTrace();
        }








/*
        for (int a = 1; a <= 3; a++) { // 1
            for (int b = 0; b <= a; b++) { // 2
                for (int c = 0; c <= b; c++) { // 3

                    tempBoard = new Board(a, b, c, 0,0,0,0,0,0,0);
                    //System.out.print(tempBoard.num[0]+""+tempBoard.num[1]+""+tempBoard.num[2]+" --> ");
                    getPossBoards(tempBoard);
                    //System.out.println();

                }
            }
        }

       System.out.println("hi");
       for(int[] x : LBoards) {
           System.out.println(Arrays.toString(x)+"Hi");
       }

 */








    }


    public void getPossBoards(Board b) {
        boolean pleaseBreak = false;
        possNum = new int[10];

        for (int z = 1; z <= b.num[9]; z++) { // LVL 10
            for (int x = 0; x < 9; x++) {
                possNum[x] = b.num[x];
            }
            possNum[9] = b.num[9] - z;
            //call cheeck board type here
            //check if checkboard type return true then break;
            //else no keep going
            if (checkBoardType(possNum) == true) {
                b.bestMove=possNum;
                pleaseBreak = true;
            }
        }

        for (int z = 1; z <= b.num[8]; z++) { // LVL 9
            if (pleaseBreak == true) {
                break;
            }
            for (int x = 0; x < 8; x++) {
                possNum[x] = b.num[x];
            }
            possNum[8] = b.num[8] - z;
            if (b.num[8] - z > b.num[9]) {
                possNum[9] = b.num[9];
            } else {
                possNum[9] = b.num[8] - z;
            }
            if (checkBoardType(possNum) == true) {
                b.bestMove=possNum;
                pleaseBreak = true;
            }
        }

        for (int z = 1; z <= b.num[7]; z++) { // LVL 8
            if (pleaseBreak == true) {
                break;
            }
            for (int x = 0; x < 7; x++) {
                possNum[x] = b.num[x];
            }
            possNum[7] = b.num[7] - z;
            if (b.num[7] - z > b.num[8]) {
                possNum[8] = b.num[8];
                possNum[9] = b.num[9];
            } else {
                possNum[8] = b.num[7] - z;
                if (b.num[7] - z > b.num[9]) {
                    possNum[9] = b.num[9];
                } else {
                    possNum[9] = b.num[7] - z;
                }
            }
            if (checkBoardType(possNum) == true) {
                b.bestMove=possNum;
                pleaseBreak = true;
            }
        }

        for (int z = 1; z <= b.num[6]; z++) { // LVL 7
            if (pleaseBreak == true) {
                break;
            }
            for (int x = 0; x < 6; x++) {
                possNum[x] = b.num[x];
            }
            possNum[6] = b.num[6] - z;
            if (b.num[6] - z > b.num[7]) {
                possNum[7] = b.num[7];
                possNum[8] = b.num[8];
                possNum[9] = b.num[9];
            } else {
                possNum[7] = b.num[6] - z;
                if (b.num[6] - z > b.num[8]) {
                    possNum[8] = b.num[8];
                    possNum[9] = b.num[9];
                } else {
                    possNum[8] = b.num[6] - z;
                    if (b.num[6] - z > b.num[9]) {
                        possNum[9] = b.num[9];
                    } else {
                        possNum[9] = b.num[6] - z;
                    }
                }
            }
            if (checkBoardType(possNum) == true) {
                b.bestMove=possNum;
                pleaseBreak = true;
            }
        }

        for (int z = 1; z <= b.num[5]; z++) { // LVL 6
            if (pleaseBreak == true) {
                break;
            }
            for (int x = 0; x < 5; x++) {
                possNum[x] = b.num[x];
            }
            possNum[5] = b.num[5] - z;
            if (b.num[5] - z > b.num[6]) {
                for (int i = 6; i < 10; i++) {
                    possNum[i] = b.num[i];
                }
            } else {
                possNum[6] = b.num[5] - z;
                if (b.num[5] - z > b.num[7]) {
                    possNum[7] = b.num[7];
                    possNum[8] = b.num[8];
                    possNum[9] = b.num[9];
                } else {
                    possNum[7] = b.num[5] - z;
                    if (b.num[5] - z > b.num[8]) {
                        possNum[8] = b.num[8];
                        possNum[9] = b.num[9];
                    } else {
                        possNum[8] = b.num[5] - z;
                        if (b.num[5] - z > b.num[9]) {
                            possNum[9] = b.num[9];
                        } else {
                            possNum[9] = b.num[5] - z;
                        }
                    }
                }
            }
            if (checkBoardType(possNum) == true) {
                b.bestMove=possNum;
                pleaseBreak = true;
            }
        }

        for (int z = 1; z <= b.num[4]; z++) { // LVL 5
            if (pleaseBreak == true) {
                break;
            }
            for (int x = 0; x < 4; x++) {
                possNum[x] = b.num[x];
            }
            possNum[4] = b.num[4] - z;
            if (b.num[4] - z > b.num[5]) {
                for (int i = 5; i < 10; i++) {
                    possNum[i] = b.num[i];
                }
            } else {
                possNum[5] = b.num[4] - z;
                if (b.num[4] - z > b.num[6]) {
                    for (int i = 6; i < 10; i++) {
                        possNum[i] = b.num[i];
                    }
                } else {
                    possNum[6] = b.num[4] - z;
                    if (b.num[4] - z > b.num[7]) {
                        possNum[7] = b.num[7];
                        possNum[8] = b.num[8];
                        possNum[9] = b.num[9];
                    } else {
                        possNum[7] = b.num[4] - z;
                        if (b.num[4] - z > b.num[8]) {
                            possNum[8] = b.num[8];
                            possNum[9] = b.num[9];
                        } else {
                            possNum[8] = b.num[4] - z;
                            if (b.num[4] - z > b.num[9]) {
                                possNum[9] = b.num[9];
                            } else {
                                possNum[9] = b.num[4] - z;
                            }
                        }
                    }
                }
            }
            if (checkBoardType(possNum) == true) {
                b.bestMove=possNum;
                pleaseBreak = true;
            }
        }

        for (int z = 1; z <= b.num[3]; z++) { // LVL 4
            if (pleaseBreak == true) {
                break;
            }
            possNum[0] = b.num[0];
            possNum[1] = b.num[1];
            possNum[2] = b.num[2];
            possNum[3] = b.num[3] - z;
            if (b.num[3] - z > b.num[4]) {
                for (int i = 4; i < 10; i++) {
                    possNum[i] = b.num[i];
                }
            } else {
                possNum[4] = b.num[3] - z;
                if (b.num[3] - z > b.num[5]) {
                    for (int i = 5; i < 10; i++) {
                        possNum[i] = b.num[i];
                    }
                } else {
                    possNum[5] = b.num[3] - z;
                    if (b.num[3] - z > b.num[6]) {
                        for (int i = 6; i < 10; i++) {
                            possNum[i] = b.num[i];
                        }
                    } else {
                        possNum[6] = b.num[3] - z;
                        if (b.num[3] - z > b.num[7]) {
                            possNum[7] = b.num[7];
                            possNum[8] = b.num[8];
                            possNum[9] = b.num[9];
                        } else {
                            possNum[7] = b.num[3] - z;
                            if (b.num[3] - z > b.num[8]) {
                                possNum[8] = b.num[8];
                                possNum[9] = b.num[9];
                            } else {
                                possNum[8] = b.num[3] - z;
                                if (b.num[3] - z > b.num[9]) {
                                    possNum[9] = b.num[9];
                                } else {
                                    possNum[9] = b.num[3] - z;
                                }
                            }
                        }
                    }
                }
            }

            if (checkBoardType(possNum) == true) {
                b.bestMove=possNum;
                pleaseBreak = true;
            }
        }

        for (int z = 1; z <= b.num[2]; z++) { // LVL 3
            if (pleaseBreak == true) {
                break;
            }
            possNum[0] = b.num[0];
            possNum[1] = b.num[1];
            possNum[2] = b.num[2] - z;
            if (b.num[2] - z > b.num[3]) {
                for (int i = 3; i < 10; i++) {
                    possNum[i] = b.num[i];
                }
            } else {
                possNum[3] = b.num[2] - z;
                if (b.num[2] - z > b.num[4]) {
                    for (int i = 4; i < 10; i++) {
                        possNum[i] = b.num[i];
                    }
                } else {
                    possNum[4] = b.num[2] - z;
                    if (b.num[2] - z > b.num[5]) {
                        for (int i = 5; i < 10; i++) {
                            possNum[i] = b.num[i];
                        }
                    } else {
                        possNum[5] = b.num[2] - z;
                        if (b.num[2] - z > b.num[6]) {
                            for (int i = 6; i < 10; i++) {
                                possNum[i] = b.num[i];
                            }
                        } else {
                            possNum[6] = b.num[2] - z;
                            if (b.num[2] - z > b.num[7]) {
                                possNum[7] = b.num[7];
                                possNum[8] = b.num[8];
                                possNum[9] = b.num[9];
                            } else {
                                possNum[7] = b.num[2] - z;
                                if (b.num[2] - z > b.num[8]) {
                                    possNum[8] = b.num[8];
                                    possNum[9] = b.num[9];
                                } else {
                                    possNum[8] = b.num[2] - z;
                                    if (b.num[2] - z > b.num[9]) {
                                        possNum[9] = b.num[9];
                                    } else {
                                        possNum[9] = b.num[2] - z;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (checkBoardType(possNum) == true) {
                b.bestMove=possNum;
                pleaseBreak = true;
            }
        }

        for (int z = 1; z <= b.num[1]; z++) { // LVL 2
            if (pleaseBreak == true) {
                break;
            }
            possNum[0] = b.num[0];
            possNum[1] = b.num[1] - z;
            if (b.num[1] - z > b.num[2]) {
                for (int i = 2; i < 10; i++) {
                    possNum[i] = b.num[i];
                }
            } else {
                possNum[2] = b.num[1] - z;
                if (b.num[1] - z > b.num[3]) {
                    for (int i = 3; i < 10; i++) {
                        possNum[i] = b.num[i];
                    }
                } else {
                    possNum[3] = b.num[1] - z;
                    if (b.num[1] - z > b.num[4]) {
                        for (int i = 4; i < 10; i++) {
                            possNum[i] = b.num[i];
                        }
                    } else {
                        possNum[4] = b.num[1] - z;
                        if (b.num[1] - z > b.num[5]) {
                            for (int i = 5; i < 10; i++) {
                                possNum[i] = b.num[i];
                            }
                        } else {
                            possNum[5] = b.num[1] - z;
                            if (b.num[1] - z > b.num[6]) {
                                for (int i = 6; i < 10; i++) {
                                    possNum[i] = b.num[i];
                                }
                            } else {
                                possNum[6] = b.num[1] - z;
                                if (b.num[1] - z > b.num[7]) {
                                    possNum[7] = b.num[7];
                                    possNum[8] = b.num[8];
                                    possNum[9] = b.num[9];
                                } else {
                                    possNum[7] = b.num[1] - z;
                                    if (b.num[1] - z > b.num[8]) {
                                        possNum[8] = b.num[8];
                                        possNum[9] = b.num[9];
                                    } else {
                                        possNum[8] = b.num[1] - z;
                                        if (b.num[1] - z > b.num[9]) {
                                            possNum[9] = b.num[9];
                                        } else {
                                            possNum[9] = b.num[1] - z;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (checkBoardType(possNum) == true) {
                b.bestMove=possNum;
                pleaseBreak = true;
            }
        }

        for (int z = 1; z < b.num[0]; z++) { // LVL 1
            if (pleaseBreak == true) {
                break;
            }
            possNum[0] = b.num[0] - z;
            if (b.num[0] - z > b.num[1]) {
                for (int i = 1; i < 10; i++) {
                    possNum[i] = b.num[i];
                }
            } else {
                possNum[1] = b.num[0] - z;
                if (b.num[0] - z > b.num[2]) {
                    for (int i = 2; i < 10; i++) {
                        possNum[i] = b.num[i];
                    }
                } else {
                    possNum[2] = b.num[0] - z;
                    if (b.num[0] - z > b.num[3]) {
                        for (int i = 3; i < 10; i++) {
                            possNum[i] = b.num[i];
                        }
                    } else {
                        possNum[3] = b.num[0] - z;
                        if (b.num[0] - z > b.num[4]) {
                            for (int i = 4; i < 10; i++) {
                                possNum[i] = b.num[i];
                            }
                        } else {
                            possNum[4] = b.num[0] - z;
                            if (b.num[0] - z > b.num[5]) {
                                for (int i = 5; i < 10; i++) {
                                    possNum[i] = b.num[i];
                                }
                            } else {
                                possNum[5] = b.num[0] - z;
                                if (b.num[0] - z > b.num[6]) {
                                    for (int i = 6; i < 10; i++) {
                                        possNum[i] = b.num[i];
                                    }
                                } else {
                                    possNum[6] = b.num[0] - z;
                                    if (b.num[0] - z > b.num[7]) {
                                        possNum[7] = b.num[7];
                                        possNum[8] = b.num[8];
                                        possNum[9] = b.num[9];
                                    } else {
                                        possNum[7] = b.num[0] - z;
                                        if (b.num[0] - z > b.num[8]) {
                                            possNum[8] = b.num[8];
                                            possNum[9] = b.num[9];
                                        } else {
                                            possNum[8] = b.num[0] - z;
                                            if (b.num[0] - z > b.num[9]) {
                                                possNum[9] = b.num[9];
                                            } else {
                                                possNum[9] = b.num[0] - z;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (checkBoardType(possNum) == true) {
                b.bestMove=possNum;
                pleaseBreak = true;
            }
        }
    }

    //param should be the poss num
    public boolean checkBoardType(int[] b) { // check if its a win or lose board
        for (String i : losBoards) { // if one of the possboards is a lose board, it's a win board so set pleasebreak to true
            if (Arrays.toString(b).equals(i)) {
                return true;
            }
        }
        // if losing is not true (there were no lose boards), then add this to lose board
            return false;
    }

    public void findBestMove(Board b){
        //boolean pleaseBreak = false;

        getPossBoards(b);

        /*for(int[] i : tempPossBoards){
            if(pleaseBreak==true){
                break;
            }
            for(int[] x : LBoards){
                if(Arrays.toString(i).equals(Arrays.toString(x))){ // if the possboard is a winning board...
                    b.bestMove=i;
                    pleaseBreak=true;
                    break;
                }
            }
        }
        int movesToLose=0;
         */
        if(b.bestMove==null){ // if, after running through the loops above, there's still no best move (aka it's a losing board)

            b.bestMove = new int[10];
            for(int x=0; x<b.num.length; x++){
                b.bestMove[x]=b.num[x];
            }

            if(b.bestMove[9]>0){
                b.bestMove[9]--;
            }
            else{
                if(b.bestMove[8]>0){
                    b.bestMove[8]--;
                }
                else{
                    if(b.bestMove[7]>0){
                        b.bestMove[7]--;
                    }
                    else{
                        if(b.bestMove[6]>0){
                            b.bestMove[6]--;
                        }
                        else{
                            if(b.bestMove[5]>0){
                                b.bestMove[5]--;
                            }
                            else{
                                if(b.bestMove[4]>0){
                                    b.bestMove[4]--;
                                }
                                else{
                                    if(b.bestMove[3]>0){
                                        b.bestMove[3]--;
                                    }
                                    else{
                                        if(b.bestMove[2]>0){
                                            b.bestMove[2]--;
                                        }
                                        else{
                                            if(b.bestMove[1]>0){
                                                b.bestMove[1]--;
                                            }
                                            else{
                                                b.bestMove[0]--;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            /*for(int[] i : tempPossBoards){
                if(i[0]+i[1]+i[2]>=movesToLose){ // just pick the possboard that leaves you with the most chips left on the board
                    movesToLose=i[0]+i[1]+i[2]+i[3]+i[4]+i[5]+i[6]+i[7]+i[8]+i[9];
                    b.bestMove=i;
                }
            }

             */
        }
    }

    public Point move (Chip[][]pBoard){

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;

            /***
             * This code will run each time the "MyPlayer" button is pressed.
             * Add your code to return the row and the column of the chip you want to take.
             * You'll be returning a data type called Point which consists of two integers.
             */


            cols = new int[10];

            for(Chip[] x : gameBoard){
                for(int i=0; i<cols.length; i++){
                    if(x[i].isAlive == true){
                        cols[i]++;
                    }
                }
            }


            currentBoard = new Board(cols[0], cols[1], cols[2], cols[3], cols[4], cols[5], cols[6], cols[7], cols[8], cols[9]);
            System.out.print(Arrays.toString(currentBoard.num));
            findBestMove(currentBoard);
            System.out.print(Arrays.toString(currentBoard.num));
            System.out.println(Arrays.toString(currentBoard.bestMove));

            /*
        if(currentBoard.num[0]!=1 || currentBoard.num[1]!=0 || currentBoard.num[2]!=0) {
            for (Board i : boards) {
                if (currentBoard.num[0] == i.num[0] && currentBoard.num[1] == i.num[1] && currentBoard.num[2] == i.num[2]) {
                    currentBoard = i;
                    //System.out.println(currentBoard.bestMove[0] + "" + currentBoard.bestMove[1] + "" + currentBoard.bestMove[2]);
                }
            }
        }

             */

        currentBoard.translate();
        row = currentBoard.bestRow;
        column = currentBoard.bestCol;

            Point myMove = new Point(row, column);
            return myMove;
        }
    }


