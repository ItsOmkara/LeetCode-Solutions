class Solution {
    public int minPairSum(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int maxPairSum = 0;

        while (left < right) {
            int pairSum = nums[left] + nums[right];
            maxPairSum = Math.max(maxPairSum, pairSum);
            left++;
            right--;
        }

        return maxPairSum;
    }
}