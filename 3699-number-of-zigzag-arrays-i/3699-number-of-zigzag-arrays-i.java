class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) return m;

        long totalPairs = (1L * m * (m - 1)) % MOD;
        if (n == 2) return (int) totalPairs;

        long[] up = new long[m];
        long[] down = new long[m];

       
        for (int i = 0; i < m; i++) {
            up[i] = i;               
            down[i] = m - 1 - i;     
        }

        for (int len = 3; len <= n; len++) {

            long[] prefixDown = new long[m];
            long[] prefixUp = new long[m];

            prefixDown[0] = down[0];
            prefixUp[0] = up[0];

            for (int i = 1; i < m; i++) {
                prefixDown[i] = (prefixDown[i - 1] + down[i]) % MOD;
                prefixUp[i] = (prefixUp[i - 1] + up[i]) % MOD;
            }

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for (int i = 0; i < m; i++) {

                
                if (i > 0)
                    newUp[i] = prefixDown[i - 1];

                long greaterSum = (prefixUp[m - 1] - prefixUp[i] + MOD) % MOD;
                newDown[i] = greaterSum;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}