class Solution {
    private static final int MOD = 1_000_000_007;
    private Integer[][][] dp;

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        dp = new Integer[n][maxVal + 1][maxVal + 1];
        return solve(0, 0, 0, nums);
    }

    private int solve(int idx, int gcd1, int gcd2, int[] nums) {
        if (idx == nums.length) {
            return (gcd1 > 0 && gcd1 == gcd2) ? 1 : 0;
        }

        if (dp[idx][gcd1][gcd2] != null) {
            return dp[idx][gcd1][gcd2];
        }
        long ans = solve(idx + 1, gcd1, gcd2, nums);

        int nextGcd1 = (gcd1 == 0) ? nums[idx] : gcd(gcd1, nums[idx]);
        ans = (ans + solve(idx + 1, nextGcd1, gcd2, nums)) % MOD;
        int nextGcd2 = (gcd2 == 0) ? nums[idx] : gcd(gcd2, nums[idx]);
        ans = (ans + solve(idx + 1, gcd1, nextGcd2, nums)) % MOD;

        return dp[idx][gcd1][gcd2] = (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
