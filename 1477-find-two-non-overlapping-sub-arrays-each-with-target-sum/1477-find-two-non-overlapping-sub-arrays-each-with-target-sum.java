class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = Integer.MAX_VALUE / 2;
        int[] bestLeft = new int[n];
        int minLen = INF;
        int sum = 0, left = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left++];
            }
            if (sum == target) {
                minLen = Math.min(minLen, right - left + 1);
            }
            bestLeft[right] = minLen;
        }
        int[] bestRight = new int[n];
        minLen = INF;
        sum = 0;
        int right = n - 1;

        for (int l = n - 1; l >= 0; l--) {
            sum += arr[l];
            while (sum > target) {
                sum -= arr[right--];
            }
            if (sum == target) {
                minLen = Math.min(minLen, right - l + 1);
            }
            bestRight[l] = minLen;
        }
        int result = INF;
        for (int i = 0; i < n - 1; i++) {
            if (bestLeft[i] != INF && bestRight[i + 1] != INF) {
                result = Math.min(result, bestLeft[i] + bestRight[i + 1]);
            }
        }

        return result == INF ? -1 : result;
    }
}