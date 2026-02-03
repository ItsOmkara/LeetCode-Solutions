class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        
        for (int p = 1; p < n-2; p++) {
            
            boolean firstPartValid = true;
            for (int i = 1; i <= p; i++) {
                if (nums[i] <= nums[i-1]) {
                    firstPartValid = false;
                    break;
                }
            }
            if (!firstPartValid) continue;
            
            for (int q = p+1; q < n-1; q++) {
                
                boolean secondPartValid = true;
                for (int i = p; i < q; i++) {
                    if (nums[i] <= nums[i+1]) {
                        secondPartValid = false;
                        break;
                    }
                }
                if (!secondPartValid) continue;
                
                boolean thirdPartValid = true;
                for (int i = q; i < n-1; i++) {
                    if (nums[i] >= nums[i+1]) {
                        thirdPartValid = false;
                        break;
                    }
                }
                if (!thirdPartValid) continue;
                
                return true; 
            }
        }
        
        return false;
    }
}