import java.util.ArrayList;

public class Board {

    public int[] num;
    public int[] possNum;
    public int[] bestMove;
    public int count1=0; // keeps track of how many outcomes there are
    ArrayList<int[]> possBoards = new ArrayList<int[]>();


    public Board(int x, int y, int z){
        num = new int[3];
        num[0]=x;
        num[1]=y;
        num[2]=z;

        for (int c = 1; c <= z; c++) { // LVL 1: changing the last digit of the board
            possNum = new int[3];
            possNum[0] = x;
            possNum[1] = y;
            possNum[2] = z - c;
            possBoards.add(possNum);
            count1++;
        }

        for (int b = 1; b <= y; b++) { // LVL 2: changing the middle digit+following digits of the board
            possNum = new int[3];
            if (y - b > z) {
                possNum[0] = x;
                possNum[1] = y - b;
                possNum[2] = z;
            } else {
                possNum[0] = x;
                possNum[1] = y - b;
                possNum[2] = y - b;
            }
            possBoards.add(possNum);
            count1++;
        }

        for (int a = 1; a <= x - 1; a++) { // LVL 3: changing the first+following digits of the board.
            possNum = new int[3];
            if (x - a > y) {
                possNum[0] = x - a;
                possNum[1] = y;
                possNum[2] = z;
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
            count1++;
        }

    }
}
