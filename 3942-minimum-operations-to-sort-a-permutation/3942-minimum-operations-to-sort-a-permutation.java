class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        long best = Long.MAX_VALUE;
        if (isRotationOfSorted(nums, n)) {
            int m = (n - nums[0]) % n;
            long cost = (m == 0) ? 0 : Math.min(m, (long) n - m + 2);
            best = Math.min(best, cost);
        }
        int[] rev = new int[n];
        for (int i = 0; i < n; i++) rev[i] = nums[n - 1 - i];
        if (isRotationOfSorted(rev, n)) {
            int m = (n - rev[0]) % n;
            long cost = 1 + Math.min(m, n - m); 
            best = Math.min(best, cost);
        }

        return best == Long.MAX_VALUE ? -1 : (int) best;
    }

    private boolean isRotationOfSorted(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            if (a[i] != (a[0] + i) % n) return false;
        }
        return true;
    }
}