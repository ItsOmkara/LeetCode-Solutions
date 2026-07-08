class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final long MOD = 1_000_000_007L;
        int m = s.length();

       
        long[] digitSum = new long[m + 1];
        for (int i = 0; i < m; i++) {
            digitSum[i + 1] = digitSum[i] + (s.charAt(i) - '0');
        }

        
        int[] pos = new int[m];
        int[] nz = new int[m];
        int M = 0;
        for (int i = 0; i < m; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                pos[M] = i;
                nz[M] = d;
                M++;
            }
        }

       
        long[] H = new long[M + 1];
        long[] pow10 = new long[M + 1];
        pow10[0] = 1;
        for (int i = 0; i < M; i++) {
            H[i + 1] = (H[i] * 10 + nz[i]) % MOD;
            pow10[i + 1] = (pow10[i] * 10) % MOD;
        }

        int n = queries.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            long sum = (digitSum[r + 1] - digitSum[l]) % MOD;

            int lo = lowerBound(pos, M, l);       
            int hi = upperBound(pos, M, r) - 1;  

            long x;
            if (lo > hi) {
                x = 0;
            } else {
                int len = hi - lo + 1;
                x = ((H[hi + 1] - H[lo] * pow10[len]) % MOD + MOD) % MOD;
            }

            answer[i] = (int) ((x * sum) % MOD);
        }

        return answer;
    }

    private int lowerBound(int[] pos, int M, int target) {
        int left = 0, right = M;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (pos[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    private int upperBound(int[] pos, int M, int target) {
        int left = 0, right = M;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (pos[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}