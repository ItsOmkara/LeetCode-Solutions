class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i<n;i++){
            int k = n % (i + 1);
            if(k == 0){
                sum += (nums[i] * nums[i]); 
            }
        }

        return sum;
    }
}