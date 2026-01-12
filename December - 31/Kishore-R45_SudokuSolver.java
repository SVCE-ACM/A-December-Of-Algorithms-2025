import java.util.Scanner;

public class SudokuSolver {
    static char[][] puzzle = new char[9][9];
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        for(int x=0; x<9; x++){
            for(int y=0; y<9; y++){
                String cell = sc.next();
                puzzle[x][y] = cell.charAt(0);
            }
        }
        
        solve();
        
        for(int x=0; x<9; x++){
            for(int y=0; y<9; y++){
                System.out.print(puzzle[x][y]);
                if(y < 8) System.out.print(" ");
            }
            System.out.println();
        }
        sc.close();
    }
    
    static boolean solve(){
        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                if(puzzle[r][c] == '.'){
                    for(char num='1'; num<='9'; num++){
                        if(canPlace(r, c, num)){
                            puzzle[r][c] = num;
                            
                            if(solve()) return true;
                            
                            puzzle[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean canPlace(int row, int col, char num){
        for(int x=0; x<9; x++){
            if(puzzle[row][x] == num) return false;
        }
        
        for(int x=0; x<9; x++){
            if(puzzle[x][col] == num) return false;
        }
        
        int boxR = 3 * (row/3);
        int boxC = 3 * (col/3);
        for(int x=boxR; x<boxR+3; x++){
            for(int y=boxC; y<boxC+3; y++){
                if(puzzle[x][y] == num) return false;
            }
        }
        
        return true;
    }
}
