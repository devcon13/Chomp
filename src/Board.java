import java.util.ArrayList;

public class Board {

    ArrayList<int[]> possBoards = new ArrayList<int[]>();
    public int[] num;
    public int[] possNum;
    public int[] bestMove;
    public int count1=0; // keeps track of how many outcomes there are
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

        for (int z = 1; z <= j; z++) { // LVL 10
            possNum = new int[10];
            for(int x=0; x<9; x++){
                possNum[x]=num[x];
            }
            possNum[9] = j - z;
            possBoards.add(possNum);
            count1++;
        }

        for (int z = 1; z <= i; z++){ // LVL 9
            possNum = new int[10];
            for(int x=0; x<8; x++){
                possNum[x]=num[x];
            }
            possNum[8] = i - z;
            if (i - z > j) {
                possNum[9] = num[9];
            } else {
                possNum[9] = i-z;
            }
            possBoards.add(possNum);
            count1++;
        }

        for (int z = 1; z <= h; z++){ // LVL 8
            possNum = new int[10];
            for(int x=0; x<7; x++){
                possNum[x]=num[x];
            }
            possNum[7] = h-z;
            if(h-z > i){
                possNum[8] = num[8];
                possNum[9] = num[9];
            }
            else{
                possNum[8] = h-z;
                if(h-z > j){
                    possNum[9] = num[9];
                }
                else{
                    possNum[9] = h-z;
                }
            }
            possBoards.add(possNum);
            count1++;
        }

        for (int z = 1; z <= g; z++){ // LVL 7
            possNum = new int[10];
            for(int x=0; x<6; x++){
                possNum[x]=num[x];
            }
            possNum[6] = g-z;
            if(g-z > h){
                possNum[7] = num[7];
                possNum[8] = num[8];
                possNum[9] = num[9];
            }
            else{
                possNum[7] = g-z;
                if(g-z>i){
                    possNum[8] = num[8];
                    possNum[9] = num[9];
                }
                else{
                    possNum[8] = g-z;
                    if(g-z>j){
                        possNum[9] = num[9];
                    }
                    else{
                        possNum[9] = g-z;
                    }
                }
            }
            possBoards.add(possNum);
            count1++;
        }

        for (int z = 1; z <= f; z++){ // LVL 6
            possNum = new int[10];
            for(int x=0; x<5; x++){
                possNum[x]=num[x];
            }
            possNum[5] = f-z;
            if(f-z > g){
                possNum[6] = num[6];
                possNum[7] = num[7];
                possNum[8] = num[8];
                possNum[9] = num[9];
            }
            else{
                possNum[6] = f-z;
                if(f-z > h){
                    possNum[7] = num[7];
                    possNum[8] = num[8];
                    possNum[9] = num[9];
                }
                else{
                    possNum[7] = f-z;
                    if(f-z > i){
                        possNum[8] = num[8];
                        possNum[9] = num[9];
                    }
                    else{
                        possNum[8] = f-z;
                        if(f-z > j){
                            possNum[9] = num[9];
                        }
                        else{
                            possNum[9] = f-z;
                        }
                    }
                }
            }
            possBoards.add(possNum);
            count1++;
        }

        for (int z = 1; z <= e; z++) { // LVL 5
            possNum = new int[10];
            for (int x = 0; x < 4; x++) {
                possNum[x] = num[x];
            }
            possNum[4] = e - z;
            if (e - z > f) {
                possNum[5] = num[5];
                possNum[6] = num[6];
                possNum[7] = num[7];
                possNum[8] = num[8];
                possNum[9] = num[9];
            }
            else {
                possNum[5] = e - z;
                if (e - z > g) {
                    possNum[6] = num[6];
                    possNum[7] = num[7];
                    possNum[8] = num[8];
                    possNum[9] = num[9];
                } else {
                    possNum[6] = e - z;
                    if (e - z > h) {
                        possNum[7] = num[7];
                        possNum[8] = num[8];
                        possNum[9] = num[9];
                    } else {
                        possNum[7] = e - z;
                        if (e - z > i) {
                            possNum[8] = num[8];
                            possNum[9] = num[9];
                        }
                        else {
                            possNum[8] = e - z;
                            if (e - z > j) {
                                possNum[9] = num[9];
                            }
                            else {
                                possNum[9] = e - z;
                            }
                        }
                    }
                }
            }
            possBoards.add(possNum);
            count1++;
        }

        for (int z = 1; z <= d; z++){ // LVL 4
            possNum = new int[10];
            possNum[0]=num[0];
            possNum[1]=num[1];
            possNum[2]=num[2];
            possNum[3] = d-z;
            if (d - z > e){
                possNum[4] = num[4];
                possNum[5] = num[5];
                possNum[6] = num[6];
                possNum[7] = num[7];
                possNum[8] = num[8];
                possNum[9] = num[9];
            }
            else {
                possNum[4] = d - z;
                if (d - z > f) {
                    possNum[5] = num[5];
                    possNum[6] = num[6];
                    possNum[7] = num[7];
                    possNum[8] = num[8];
                    possNum[9] = num[9];
                } else {
                    possNum[5] = d - z;
                    if (d - z > g) {
                        possNum[6] = num[6];
                        possNum[7] = num[7];
                        possNum[8] = num[8];
                        possNum[9] = num[9];
                    } else {
                        possNum[6] = d - z;
                        if (d - z > h) {
                            possNum[7] = num[7];
                            possNum[8] = num[8];
                            possNum[9] = num[9];
                        } else {
                            possNum[7] = d - z;
                            if (d - z > i) {
                                possNum[8] = num[8];
                                possNum[9] = num[9];
                            } else {
                                possNum[8] = d - z;
                                if (d - z > j) {
                                    possNum[9] = num[9];
                                }
                                else {
                                    possNum[9] = d - z;
                                }
                            }
                        }
                    }
                }
            }

            possBoards.add(possNum);
            count1++;
        }

        for (int z = 1; z <= c; z++){ // LVL 3
            possNum = new int[10];
            possNum[0]=num[0];
            possNum[1]=num[1];
            possNum[2] = c-z;
            if(c-z > d){
                possNum[3] = num[3];
                possNum[4] = num[4];
                possNum[5] = num[5];
                possNum[6] = num[6];
                possNum[7] = num[7];
                possNum[8] = num[8];
                possNum[9] = num[9];
            }
            else {
                possNum[3] = c-z;
                if (c - z > e) {
                    possNum[4] = num[4];
                    possNum[5] = num[5];
                    possNum[6] = num[6];
                    possNum[7] = num[7];
                    possNum[8] = num[8];
                    possNum[9] = num[9];
                } else {
                    possNum[4] = c - z;
                    if (c - z > f) {
                        possNum[5] = num[5];
                        possNum[6] = num[6];
                        possNum[7] = num[7];
                        possNum[8] = num[8];
                        possNum[9] = num[9];
                    } else {
                        possNum[5] = c - z;
                        if (c - z > g) {
                            possNum[6] = num[6];
                            possNum[7] = num[7];
                            possNum[8] = num[8];
                            possNum[9] = num[9];
                        } else {
                            possNum[6] = c - z;
                            if (c - z > h) {
                                possNum[7] = num[7];
                                possNum[8] = num[8];
                                possNum[9] = num[9];
                            } else {
                                possNum[7] = c - z;
                                if (c - z > i) {
                                    possNum[8] = num[8];
                                    possNum[9] = num[9];
                                } else {
                                    possNum[8] = c - z;
                                    if (c - z > j) {
                                        possNum[9] = num[9];
                                    } else {
                                        possNum[9] = c - z;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            possBoards.add(possNum);
            count1++;
        }

        for (int z = 1; z <= b; z++){ // LVL 2
            possNum = new int[10];
            possNum[0]=num[0];
            possNum[1]= b-z;
            if(b-z > c){
                possNum[2] = num[2];
                possNum[3] = num[3];
                possNum[4] = num[4];
                possNum[5] = num[5];
                possNum[6] = num[6];
                possNum[7] = num[7];
                possNum[8] = num[8];
                possNum[9] = num[9];
            } else {
                possNum[2] = b - z;
                if (b - z > d) {
                    possNum[3] = num[3];
                    possNum[4] = num[4];
                    possNum[5] = num[5];
                    possNum[6] = num[6];
                    possNum[7] = num[7];
                    possNum[8] = num[8];
                    possNum[9] = num[9];
                } else {
                    possNum[3] = b - z;
                    if (b - z > e) {
                        possNum[4] = num[4];
                        possNum[5] = num[5];
                        possNum[6] = num[6];
                        possNum[7] = num[7];
                        possNum[8] = num[8];
                        possNum[9] = num[9];
                    } else {
                        possNum[4] = b - z;
                        if (b - z > f) {
                            possNum[5] = num[5];
                            possNum[6] = num[6];
                            possNum[7] = num[7];
                            possNum[8] = num[8];
                            possNum[9] = num[9];
                        } else {
                            possNum[5] = b - z;
                            if (b - z > g) {
                                possNum[6] = num[6];
                                possNum[7] = num[7];
                                possNum[8] = num[8];
                                possNum[9] = num[9];
                            } else {
                                possNum[6] = b - z;
                                if (b - z > h) {
                                    possNum[7] = num[7];
                                    possNum[8] = num[8];
                                    possNum[9] = num[9];
                                } else {
                                    possNum[7] = b - z;
                                    if (b - z > i) {
                                        possNum[8] = num[8];
                                        possNum[9] = num[9];
                                    } else {
                                        possNum[8] = b - z;
                                        if (b - z > j) {
                                            possNum[9] = num[9];
                                        } else {
                                            possNum[9] = b - z;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            possBoards.add(possNum);
            count1++;
        }


        for (int z = 1; z < a; z++) { // LVL 1
            possNum = new int[10];
            possNum[0] = a - z;
            if(a - z > b){
                possNum[1] = num[1];
                possNum[2] = num[2];
                possNum[3] = num[3];
                possNum[4] = num[4];
                possNum[5] = num[5];
                possNum[6] = num[6];
                possNum[7] = num[7];
                possNum[8] = num[8];
                possNum[9] = num[9];
            } else {
                possNum[1] = a - z;
                if (a - z > c) {
                    possNum[2] = num[2];
                    possNum[3] = num[3];
                    possNum[4] = num[4];
                    possNum[5] = num[5];
                    possNum[6] = num[6];
                    possNum[7] = num[7];
                    possNum[8] = num[8];
                    possNum[9] = num[9];
                } else {
                    possNum[2] = a - z;
                    if (a - z > d) {
                        possNum[3] = num[3];
                        possNum[4] = num[4];
                        possNum[5] = num[5];
                        possNum[6] = num[6];
                        possNum[7] = num[7];
                        possNum[8] = num[8];
                        possNum[9] = num[9];
                    } else {
                        possNum[3] = a - z;
                        if (a - z > e) {
                            possNum[4] = num[4];
                            possNum[5] = num[5];
                            possNum[6] = num[6];
                            possNum[7] = num[7];
                            possNum[8] = num[8];
                            possNum[9] = num[9];
                        } else {
                            possNum[4] = a - z;
                            if (a - z > f) {
                                possNum[5] = num[5];
                                possNum[6] = num[6];
                                possNum[7] = num[7];
                                possNum[8] = num[8];
                                possNum[9] = num[9];
                            } else {
                                possNum[5] = a - z;
                                if (a - z > g) {
                                    possNum[6] = num[6];
                                    possNum[7] = num[7];
                                    possNum[8] = num[8];
                                    possNum[9] = num[9];
                                } else {
                                    possNum[6] = a - z;
                                    if (a - z > h) {
                                        possNum[7] = num[7];
                                        possNum[8] = num[8];
                                        possNum[9] = num[9];
                                    } else {
                                        possNum[7] = a - z;
                                        if (a - z > i) {
                                            possNum[8] = num[8];
                                            possNum[9] = num[9];
                                        } else {
                                            possNum[8] = a - z;
                                            if (a - z > j) {
                                                possNum[9] = num[9];
                                            } else {
                                                possNum[9] = a - z;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            possBoards.add(possNum);
            count1++;
        }
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


