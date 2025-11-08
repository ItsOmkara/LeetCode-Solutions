class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0;
        int right = n - 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                result[left] = nums[i];
                left++;
            } else {
                result[right] = nums[i];
                right--;
            }
        }

        return result;
    }
}