class Solution {
    public int pivotIndex(int[] nums) {
        int tsum = 0;
        for(int i=0;i<nums.length;i++){
            tsum+=nums[i];
        }
        int lsum = 0; 
        for(int j=0; j<nums.length; j++){
            if(lsum == tsum-lsum-nums[j]){
                return j;
            }
            lsum+=nums[j];
        }
        return -1;
    }    
}