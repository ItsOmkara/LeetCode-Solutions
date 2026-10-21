class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        char[] sorted = arr.clone();
        Arrays.sort(sorted);
        if (Arrays.equals(arr, sorted)) {
            return 0;
        }
        if (n == 2) {
            return -1;
        }

        char min = sorted[0];
        char max = sorted[n - 1];

        boolean firstIsMin = s.charAt(0) == min;
        boolean lastIsMax = s.charAt(n - 1) == max;

        if (firstIsMin || lastIsMax) {
            return 1;
        }

        boolean minInMiddle = false;
        boolean maxInMiddle = false;

        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == min) minInMiddle = true;
            if (s.charAt(i) == max) maxInMiddle = true;
        }

        if (minInMiddle || maxInMiddle) {
            return 2;
        }

        return 3;
    }
}