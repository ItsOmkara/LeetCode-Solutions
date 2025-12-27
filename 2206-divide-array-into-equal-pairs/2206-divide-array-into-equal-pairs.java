class Solution {
    public boolean divideArray(int[] nums) {
       int[] freq = new int[501];
       for(int n:nums){
          freq[n]++;
       }
       for(int count:freq){
        if(count%2 == 1){
            return false;
        }
       }
       return true;
    }
}