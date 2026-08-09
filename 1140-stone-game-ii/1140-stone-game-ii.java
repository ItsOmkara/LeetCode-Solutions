class Solution {
    private int[][] dp;
    private int[] suffix;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        dp = new int[n][n + 1];

        return solve(0, 1);
    }

    private int solve(int index, int m) {
        if (index >= n) {
            return 0;
        }

        if (dp[index][m] != 0) {
            return dp[index][m];
        }

        int best = 0;

        for (int x = 1; x <= 2 * m && index + x <= n; x++) {
            int nextM = Math.max(m, x);

            int currentPlayerStones =
                    suffix[index] - solve(index + x, nextM);

            best = Math.max(best, currentPlayerStones);
        }

        dp[index][m] = best;
        return best;
    }
}