class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return 0;
        
        Arrays.sort(nums);
        int minRemovals = n - 1;
        int left = 0;
        for (int right = 0; right < n; right++) {
            
            while (left < right && (long)nums[right] > (long)nums[left] * k) {
                left++;
            }
            
            int windowSize = right - left + 1;
            minRemovals = Math.min(minRemovals, n - windowSize);
        }
        
        return minRemovals;
    }
}