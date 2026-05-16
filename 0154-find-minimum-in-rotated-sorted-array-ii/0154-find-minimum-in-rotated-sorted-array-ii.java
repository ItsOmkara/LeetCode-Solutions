class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int stable = 0;
        for(int i = 0;i<n - 1;i++){
            if(nums[i] < nums[i + 1]){
                stable++;
            }
        }

        if(stable != n){
            Arrays.sort(nums);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            if(min>=nums[i]){
                min = nums[i];
            }
        }

        return min;

    }
}