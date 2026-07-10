class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] sortedI = new int[n];
        for (int i = 0; i < n; i++) sortedI[i] = order[i];

        int[] iToIdx = new int[n];
        for (int idx = 0; idx < n; idx++) iToIdx[sortedI[idx]] = idx;

        int[] prefix = new int[n];
        for (int i = 0; i < n - 1; i++) {
            prefix[i + 1] = prefix[i] + ((nums[sortedI[i + 1]] - nums[sortedI[i]] <= maxDiff) ? 0 : 1);
        }

        int rows = bitLength(n - 2) + 1; // ceil_log2_x(n - 1) + 1
        int[][] P = new int[rows][n];
        for (int[] row : P) Arrays.fill(row, n - 1);

        for (int right = 0, left = 0; right < n; ++right) {
            for (; nums[sortedI[right]] - nums[sortedI[left]] > maxDiff; ++left) {
                P[0][left] = right - 1;
            }
        }

        for (int i = 0; i + 1 < rows; i++) {
            for (int j = 0; j < n; j++) {
                P[i + 1][j] = P[i][P[i][j]];
            }
        }

        int[] result = new int[queries.length];
        Arrays.fill(result, -1);

        for (int idx = 0; idx < queries.length; idx++) {
            int i = queries[idx][0], j = queries[idx][1];
            if (i == j) {
                result[idx] = 0;
                continue;
            }
            if (prefix[iToIdx[i]] != prefix[iToIdx[j]]) {
                continue;
            }
            if (iToIdx[i] > iToIdx[j]) {
                int tmp = i;
                i = j;
                j = tmp;
            }
            int curr = iToIdx[i], l = 0;
            for (int k = rows - 1; k >= 0; k--) {
                if (P[k][curr] < iToIdx[j]) {
                    curr = P[k][curr];
                    l += 1 << k;
                }
            }
            result[idx] = l + 1;
        }

        return result;
    }

    private int bitLength(int x) {
        // Mirrors: (x ? __lg(x) : -1) + 1
        if (x <= 0) return 0;
        return 32 - Integer.numberOfLeadingZeros(x);
    }
}