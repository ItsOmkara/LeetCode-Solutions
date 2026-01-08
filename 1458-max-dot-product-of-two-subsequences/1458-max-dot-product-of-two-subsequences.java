class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    
    
    int[][] dp = new int[m + 1][n + 1];
    
    
    for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++) {
            dp[i][j] = Integer.MIN_VALUE / 2;  
        }
    }
    
    
    for (int i = 1; i <= m; i++) {
        dp[i][0] = Integer.MIN_VALUE / 2;
    }
    for (int j = 1; j <= n; j++) {
        dp[0][j] = Integer.MIN_VALUE / 2;
    }
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            int prod = nums1[i-1] * nums2[j-1];
            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            dp[i][j] = Math.max(dp[i][j], Math.max(0, dp[i-1][j-1]) + prod);
        }
    }
    
    return dp[m][n];
    }

}