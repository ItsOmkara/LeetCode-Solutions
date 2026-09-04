class Solution {
    public boolean uniformArray(int[] nums1) {
        long[] minVal = new long[2];
        minVal[0] = Long.MAX_VALUE;
        minVal[1] = Long.MAX_VALUE;
        
        for (int num : nums1) {
            int p = num % 2;
            if (num < minVal[p]) minVal[p] = num;
        }
        
        for (int t = 0; t <= 1; t++) {
            if (canAchieve(nums1, minVal, t)) return true;
        }
        
        return false;
    }
    
    private boolean canAchieve(int[] nums1, long[] minVal, int t) {
        for (int num : nums1) {
            int p = num % 2;
            if (p == t) continue; 
            
            int required = p ^ t; 
            if (minVal[required] < num) {
                continue;
            }
            
            return false;
        }
        return true;
    }
}