class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];
        int[][] diag1 = new int[m + 1][n + 1]; 
        int[][] diag2 = new int[m + 1][n + 2]; 

       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j];
            }
        }

        int maxSize = Math.min(m, n);

        for (int k = maxSize; k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {
                    if (isMagic(i, j, k, row, col, diag1, diag2)) {
                        return k;
                    }
                }
            }
        }

        return 1; 
    }

    private boolean isMagic(int r, int c, int k,
                            int[][] row, int[][] col,
                            int[][] d1, int[][] d2) {

        int target = row[r][c + k] - row[r][c];

        
        for (int i = r; i < r + k; i++) {
            if (row[i][c + k] - row[i][c] != target) return false;
        }

        for (int j = c; j < c + k; j++) {
            if (col[r + k][j] - col[r][j] != target) return false;
        }

    
        int diagMain = d1[r + k][c + k] - d1[r][c];
        int diagAnti = d2[r + k][c] - d2[r][c + k];

        return diagMain == target && diagAnti == target;
    }
}
