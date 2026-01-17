import java.util.*;

public class SakthiDharan01_sudoku_solver {
    private static final int N = 9;
    private static char[][] board;
    private static List<int[]> empties;
    private static int[] rowBits, colBits, boxBits;

    private static int boxIndex(int r,int c){ return (r/3)*3 + c/3; }

    private static boolean backtrack(int idx){
        if (idx == empties.size()) return true;
        int r = empties.get(idx)[0];
        int c = empties.get(idx)[1];
        int b = boxIndex(r,c);
        for (char d='1'; d<='9'; d++){
            int bit = 1 << (d-'1');
            if ((rowBits[r] & bit)!=0) continue;
            if ((colBits[c] & bit)!=0) continue;
            if ((boxBits[b] & bit)!=0) continue;
            board[r][c] = d;
            rowBits[r] |= bit;
            colBits[c] |= bit;
            boxBits[b] |= bit;
            if (backtrack(idx+1)) return true;
            rowBits[r] ^= bit;
            colBits[c] ^= bit;
            boxBits[b] ^= bit;
            board[r][c] = '.';
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<String> tokens = new ArrayList<>();
        while (sc.hasNext()) tokens.add(sc.next());
        if (tokens.size() != N*N) return;
        board = new char[N][N];
        empties = new ArrayList<>();
        rowBits = new int[N];
        colBits = new int[N];
        boxBits = new int[N];
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                char ch = tokens.get(i*N + j).charAt(0);
                board[i][j] = ch;
                if (ch == '.'){
                    empties.add(new int[]{i,j});
                } else {
                    int bit = 1 << (ch - '1');
                    rowBits[i] |= bit;
                    colBits[j] |= bit;
                    boxBits[boxIndex(i,j)] |= bit;
                }
            }
        }
        backtrack(0);
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (j>0) System.out.print(" ");
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}
