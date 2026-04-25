class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        int i = 0;
        while(i<nums.length){
            sum += nums[i];
            i++;
        }
        int count = 0;
        while(sum % k != 0 && sum>=0){
            sum = sum - 1;
            count++;
        }
        return count;
    }
}