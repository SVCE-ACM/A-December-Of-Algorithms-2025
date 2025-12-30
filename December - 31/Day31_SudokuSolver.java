import java.util.*;

public class Day31_SudokuSolver {
    static boolean solve(char[][] b){
        for(int i=0;i<9;i++) for(int j=0;j<9;j++) if(b[i][j]=='.'){
            for(char d='1';d<='9';d++) if(valid(b,i,j,d)){
                b[i][j]=d; if(solve(b)) return true; b[i][j]='.';
            }
            return false;
        }
        return true;
    }
    static boolean valid(char[][] b,int r,int c,char d){
        for(int i=0;i<9;i++) if(b[r][i]==d||b[i][c]==d) return false;
        int br=r/3*3, bc=c/3*3; for(int i=0;i<3;i++) for(int j=0;j<3;j++) if(b[br+i][bc+j]==d) return false;
        return true;
    }
    public static void main(String[] args){ Scanner sc=new Scanner(System.in); char[][] b=new char[9][9]; for(int i=0;i<9;i++) for(int j=0;j<9;j++){ String t=sc.next(); b[i][j]=t.equals(".")?'.':t.charAt(0);} solve(b); for(int i=0;i<9;i++){ for(int j=0;j<9;j++){ if(j>0) System.out.print(" "); System.out.print(b[i][j]); } System.out.println(); } sc.close(); }
}
