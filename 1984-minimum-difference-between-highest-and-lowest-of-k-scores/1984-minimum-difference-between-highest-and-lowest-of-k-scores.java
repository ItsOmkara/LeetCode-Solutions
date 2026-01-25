class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int minimum = Integer.MAX_VALUE;
        if (n == 1){return 0;}
        for(int i = 0; i <= n - k; i++){
            int diff = nums[i + k - 1] - nums[i]; 
            minimum = Math.min(minimum, diff);
        }
        return minimum;
    }
}