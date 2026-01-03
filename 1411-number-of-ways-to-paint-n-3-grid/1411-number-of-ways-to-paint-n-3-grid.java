class Solution {
    public int numOfWays(int n) {
      final int MOD = 1000000007;

        
        long dpA = 6; 
        long dpB = 6; 

        for (int i = 2; i <= n; i++) {
            long newA = (2 * dpA + 2 * dpB) % MOD;
            long newB = (2 * dpA + 3 * dpB) % MOD;

            dpA = newA;
            dpB = newB;
        }

        return (int)((dpA + dpB) % MOD);
    }
}