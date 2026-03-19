class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] prefX = new int[m][n];
        int[][] prefY = new int[m][n];
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = (grid[i][j] == 'X') ? 1 : 0;
                int y = (grid[i][j] == 'Y') ? 1 : 0;
                
                prefX[i][j] = x;
                prefY[i][j] = y;
                
                if (i > 0) { prefX[i][j] += prefX[i-1][j]; prefY[i][j] += prefY[i-1][j]; }
                if (j > 0) { prefX[i][j] += prefX[i][j-1]; prefY[i][j] += prefY[i][j-1]; }
                if (i > 0 && j > 0) { prefX[i][j] -= prefX[i-1][j-1]; prefY[i][j] -= prefY[i-1][j-1]; }
                
                if (prefX[i][j] == prefY[i][j] && prefX[i][j] > 0) count++;
            }
        }
        
        return count;
    }
}