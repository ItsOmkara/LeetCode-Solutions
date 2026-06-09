class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }

        long result = (max - min) * k;
        return result;
    }
}