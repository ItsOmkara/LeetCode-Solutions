import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> intervals.get(a).get(1) - intervals.get(b).get(1));

        int[] sortedL = new int[n];
        int[] sortedR = new int[n];
        int[] sortedW = new int[n];
        int[] sortedOrig = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> iv = intervals.get(order[i]);
            sortedL[i] = iv.get(0);
            sortedR[i] = iv.get(1);
            sortedW[i] = iv.get(2);
            sortedOrig[i] = order[i];
        }

        long[][] dpSum = new long[n + 1][5];
        int[][][] dpList = new int[n + 1][5][];
        for (int k = 0; k <= 4; k++) dpList[0][k] = new int[0];

        for (int i = 1; i <= n; i++) {
            int origIdx = sortedOrig[i - 1];
            int l = sortedL[i - 1];
            int w = sortedW[i - 1];

            // p = count of first (i-1) sorted intervals with end < l
            int lo = 0, hi = i - 2, p = -1;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                if (sortedR[mid] < l) { p = mid; lo = mid + 1; }
                else hi = mid - 1;
            }
            p = p + 1;

            dpList[i][0] = new int[0];
            dpSum[i][0] = 0;

            for (int k = 1; k <= 4; k++) {
                long skipSum = dpSum[i - 1][k];
                int[] skipList = dpList[i - 1][k];

                long takeSum = dpSum[p][k - 1] + w;
                int[] prevList = dpList[p][k - 1];
                int[] takeList = Arrays.copyOf(prevList, prevList.length + 1);
                takeList[prevList.length] = origIdx;
                Arrays.sort(takeList);

                boolean takeBetter = (takeSum != skipSum)
                        ? takeSum > skipSum
                        : compareLists(takeList, skipList) < 0;

                if (takeBetter) {
                    dpSum[i][k] = takeSum;
                    dpList[i][k] = takeList;
                } else {
                    dpSum[i][k] = skipSum;
                    dpList[i][k] = skipList;
                }
            }
        }

        return dpList[n][4];
    }

    private int compareLists(int[] a, int[] b) {
        int len = Math.min(a.length, b.length);
        for (int idx = 0; idx < len; idx++) {
            if (a[idx] != b[idx]) return Integer.compare(a[idx], b[idx]);
        }
        return Integer.compare(a.length, b.length);
    }
}