class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long f = 0;
        for(int i = 0;i<n;i++){
            sum += nums[i];
            f += (long)i * nums[i];
        }

        long max = f;
        for(int i = n - 1;i>0;i--){
            f = f + sum - n * nums[i];
            max = Math.max(max, f);
        }

        return(int)max;
    }
}