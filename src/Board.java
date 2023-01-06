import java.util.ArrayList;

public class Board {

    ArrayList<int[]> possBoards = new ArrayList<int[]>();
    public int[] num;
    public int[] bestMove;
    public int bestCol;
    public int bestRow;


    public Board(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j){
        num = new int[10];
        num[0]=a;
        num[1]=b;
        num[2]=c;
        num[3]=d;
        num[4]=e;
        num[5]=f;
        num[6]=g;
        num[7]=h;
        num[8]=i;
        num[9]=j;

    }

    public void translate(){
        if(num[0]==1 && num[1]==0 && num[2]==0 && num[3]==0 && num[4]==0 && num[5]==0 && num[6]==0 && num[7]==0 && num[8]==0 && num[9]==0) {
            bestRow = 0;
            bestCol = 0;
        } else{
            int colCount = 0;
            int rowVal = 0;

            for (int i = 0; i < bestMove.length; i++) {
                if (num[i] == bestMove[i]) {
                    colCount++;
                } else {
                    break;
                }
            }
            rowVal = bestMove[colCount];

            bestRow = rowVal;
            bestCol = colCount;
        }
    }

}


