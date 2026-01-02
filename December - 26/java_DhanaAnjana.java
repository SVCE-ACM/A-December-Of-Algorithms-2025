import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class java_DhanaAnjana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        Map<String, Integer> memo = new HashMap<>();
        int result = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(matrix, i, j, m, n, memo));
            }
        }
        
        System.out.println(result);
        scanner.close();
    }
    
    static int dfs(int[][] matrix, int row, int col, int m, int n, Map<String, Integer> memo) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 0;
        }
        
        String key = row + "," + col;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int current = matrix[row][col];
        int maxLength = 1;
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                matrix[newRow][newCol] > current) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, newRow, newCol, m, n, memo));
            }
        }
        
        memo.put(key, maxLength);
        return maxLength;
    }
}
