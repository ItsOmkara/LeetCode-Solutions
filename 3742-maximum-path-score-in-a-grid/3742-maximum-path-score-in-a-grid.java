class Solution {
    public int maxPathScore(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    int[][][] dp = new int[m][n][k + 1];

    for (int[][] a : dp)
        for (int[] b : a)
            Arrays.fill(b, -1);
    dp[0][0][0] = 0;
 
    for (int j = 1; j < n; j++) {
        int cost = grid[0][j] == 0 ? 0 : 1;
        int score = grid[0][j];
        for (int c = cost; c <= k; c++) {
            if (dp[0][j-1][c - cost] != -1) {
                dp[0][j][c] = dp[0][j-1][c - cost] + score;
            }
        }
    }
    for (int i = 1; i < m; i++) {
        int cost = grid[i][0] == 0 ? 0 : 1;
        int score = grid[i][0];
        for (int c = cost; c <= k; c++) {
            if (dp[i-1][0][c - cost] != -1) {
                dp[i][0][c] = dp[i-1][0][c - cost] + score;
            }
        }
    }
    
    // Baaki cells
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            int cost = grid[i][j] == 0 ? 0 : 1;
            int score = grid[i][j];
            for (int c = cost; c <= k; c++) {
                // Upar se
                if (dp[i-1][j][c - cost] != -1) {
                    dp[i][j][c] = Math.max(dp[i][j][c],
                                  dp[i-1][j][c - cost] + score);
                }
                // Left se
                if (dp[i][j-1][c - cost] != -1) {
                    dp[i][j][c] = Math.max(dp[i][j][c],
                                  dp[i][j-1][c - cost] + score);
                }
            }
        }
    }
    int ans = -1;
    for (int c = 0; c <= k; c++) {
        if (dp[m-1][n-1][c] != -1) {
            ans = Math.max(ans, dp[m-1][n-1][c]);
        }
    }
    
    return ans;
    }
}