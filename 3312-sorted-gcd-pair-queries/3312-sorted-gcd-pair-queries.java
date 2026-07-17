class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int[] countNum = new int[maxNum + 1];
        for (int num : nums) {
            countNum[num]++;
        }

        long[] countMultiples = new long[maxNum + 1];
        for (int i = 1; i <= maxNum; i++) {
            for (int j = i; j <= maxNum; j += i) {
                countMultiples[i] += countNum[j];
            }
        }
        long[] countGcdPairs = new long[maxNum + 1];
        for (int i = maxNum; i >= 1; i--) {
            long totalPairsWithFactorI = countMultiples[i] * (countMultiples[i] - 1) / 2;
            countGcdPairs[i] = totalPairsWithFactorI;

            for (int j = 2 * i; j <= maxNum; j += i) {
                countGcdPairs[i] -= countGcdPairs[j];
            }
        }

        long[] prefixSum = new long[maxNum + 1];
        for (int i = 1; i <= maxNum; i++) {
            prefixSum[i] = prefixSum[i - 1] + countGcdPairs[i];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = binarySearch(prefixSum, queries[i]);
        }

        return answer;
    }

    private int binarySearch(long[] prefixSum, long target) {
        int low = 1;
        int high = prefixSum.length - 1;
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefixSum[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}