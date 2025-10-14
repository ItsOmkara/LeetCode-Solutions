class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for (int i = 0; i <= n - 2 * k; i++) {
            boolean firstSubarray = isStrictlyIncreasing(nums, i, i + k - 1);
            boolean secondSubarray = isStrictlyIncreasing(nums, i + k, i + 2 * k - 1);

            if (firstSubarray && secondSubarray) {
                return true;
            }
        }

        return false;
    }

    private boolean isStrictlyIncreasing(List<Integer> nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}