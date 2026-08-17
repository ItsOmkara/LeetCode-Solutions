class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                int best = 0;
                for (int k = i; k < j; k++) {
                    long leftSum = prefix[k + 1] - prefix[i];
                    long rightSum = prefix[j + 1] - prefix[k + 1];
                    
                    if (leftSum < rightSum) {
                        best = Math.max(best, (int) leftSum + dp[i][k]);
                    } else if (leftSum > rightSum) {
                        best = Math.max(best, (int) rightSum + dp[k + 1][j]);
                    } else {
                        best = Math.max(best, (int) leftSum + Math.max(dp[i][k], dp[k + 1][j]));
                    }
                }
                dp[i][j] = best;
            }
        }
        
        return dp[0][n - 1];
    }
}