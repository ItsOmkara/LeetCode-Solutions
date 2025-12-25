class Solution {
    public int[] getConcatenation(int[] nums){
        int n = nums.length;
        int[] brr = new int[n * 2];

        for(int i = 0; i < n; i++){
            brr[i] = nums[i];
            brr[i + n] = nums[i];
        }

        return brr;
    }
}