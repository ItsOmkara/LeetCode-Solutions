class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        int maxVal = 0;
        for (int x : nums) {
            uniqueNums.add(x);
            maxVal = Math.max(maxVal, x);
        }
        int maxXor = 1;
        while (maxXor <= maxVal) {
            maxXor <<= 1;
        }
        boolean[] dp = new boolean[maxXor];
        dp[0] = true;

        for (int t = 0; t < 3; t++) {
            boolean[] ndp = new boolean[maxXor];
            for (int x : uniqueNums) {
                for (int v = 0; v < maxXor; v++) {
                    if (dp[v]) {
                        ndp[v ^ x] = true;
                    }
                }
            }
            dp = ndp;
        }
        int count = 0;
        for (boolean reachable : dp) {
            if (reachable) {
                count++;
            }
        }

        return count;
    }
}