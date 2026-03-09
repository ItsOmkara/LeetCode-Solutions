class Solution {
    private static final int MOD = 1000000007;
    
    public int numberOfStableArrays(int zero, int one, int limit) {
        
        int[][][][] dp = new int[zero + 1][one + 1][2][limit + 1];
        
        
        if (zero > 0) {
            dp[1][0][0][1] = 1;
        }
        if (one > 0) {
            dp[0][1][1][1] = 1;
        }
       
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                if (i == 0 && j == 0) continue;
                
                for (int last = 0; last < 2; last++) {
                    for (int consec = 1; consec <= limit; consec++) {
                        int current = dp[i][j][last][consec];
                        if (current == 0) continue;
                        
                        if (last == 0) {
                           
                            if (i < zero && consec + 1 <= limit) {
                                dp[i + 1][j][0][consec + 1] = 
                                    (dp[i + 1][j][0][consec + 1] + current) % MOD;
                            }
                           
                            if (j < one) {
                                dp[i][j + 1][1][1] = 
                                    (dp[i][j + 1][1][1] + current) % MOD;
                            }
                        } else { 
                            
                            if (j < one && consec + 1 <= limit) {
                                dp[i][j + 1][1][consec + 1] = 
                                    (dp[i][j + 1][1][consec + 1] + current) % MOD;
                            }
                            
                            if (i < zero) {
                                dp[i + 1][j][0][1] = 
                                    (dp[i + 1][j][0][1] + current) % MOD;
                            }
                        }
                    }
                }
            }
        }
        
        
        int result = 0;
        for (int last = 0; last < 2; last++) {
            for (int consec = 1; consec <= limit; consec++) {
                result = (result + dp[zero][one][last][consec]) % MOD;
            }
        }
        
        return result;  
    }
}