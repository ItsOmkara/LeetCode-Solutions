class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = nums[i];
            } else if (nums[i] > 0) {
                
                int steps = nums[i];
                int target = (i + steps) % n;
                result[i] = nums[target];
            } else { 
                int steps = -nums[i];
       
                int target = ((i - steps) % n + n) % n;
                result[i] = nums[target];
            }
        }
        
        return result;
    }
}