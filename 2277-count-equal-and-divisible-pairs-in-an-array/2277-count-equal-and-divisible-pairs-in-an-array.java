class Solution {
    public int countPairs(int[] nums, int k) {
        int l = nums.length;
        int count = 0;
        for(int i=0;i<l;i++){
            for(int j = i + 1;j<l;j++){
                if(nums[i] == nums[j] && (i*j) % k == 0){
                    count++;
                }
            }
        }
        return count;
    }
}