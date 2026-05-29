class Solution {
    static int digitSum(int n){
        if(n == 0){
            return 0;
        }
        return n % 10 + digitSum(n / 10);
    }
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        int[] brr = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            brr[i] = digitSum(nums[i]);
        }
        for(int i = 0;i<brr.length;i++){
            if(min>brr[i]){
                min = brr[i];
            }
        }
        return min;
    }
}