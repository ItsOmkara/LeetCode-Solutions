class Solution {
    public int[] maxValue(int[] nums) {
         int n = nums.length;
        int[] suffixMin = new int[n];
        int[] ans = new int[n];

        // Build suffix minimum array
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int start = 0;
        int segmentMax = nums[0];
        int prefixMax = nums[0];

        for (int i = 0; i < n - 1; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);
            segmentMax = Math.max(segmentMax, nums[i]);

            // Segment boundary
            if (prefixMax <= suffixMin[i + 1]) {
                for (int j = start; j <= i; j++) {
                    ans[j] = segmentMax;
                }
                start = i + 1;
                if (start < n) {
                    segmentMax = nums[start];
                }
            }
        }

        // Fill last segment
        segmentMax = nums[start];
        for (int i = start; i < n; i++) {
            segmentMax = Math.max(segmentMax, nums[i]);
        }

        for (int i = start; i < n; i++) {
            ans[i] = segmentMax;
        }

        return ans;
    }
}