import java.util.*;

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] inc = new int[n];
        inc[0] = 1;

        // Step 1: Compute increasing streaks
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1))
                inc[i] = inc[i - 1] + 1;
            else
                inc[i] = 1;
        }

        int low = 1, high = n / 2, ans = 0;

        // Step 2: Binary search for maximum k
        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(nums, inc, mid)) {
                ans = mid;
                low = mid + 1;  // try for bigger k
            } else {
                high = mid - 1; // smaller k
            }
        }
        return ans;
    }

    private boolean isPossible(List<Integer> nums, int[] inc, int k) {
        int n = nums.size();

        for (int i = 0; i + 2 * k - 1 < n; i++) {
            int end1 = i + k - 1;
            int end2 = i + 2 * k - 1;

            if (inc[end1] >= k && inc[end2] >= k)
                return true;
        }
        return false;
    }
}
