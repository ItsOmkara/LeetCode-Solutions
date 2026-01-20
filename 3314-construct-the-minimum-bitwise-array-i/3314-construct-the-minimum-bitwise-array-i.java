class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            ans[i] = findMinX(nums.get(i));
        }
        
        return ans;
    }
    
    private int findMinX(int N) {
        
        
        int minX = Integer.MAX_VALUE;
        boolean found = false;
        
        for (int subset = N; subset > 0; subset = (subset - 1) & N) {
            int x = subset;
            if ((x | (x + 1)) == N) {
                minX = Math.min(minX, x);
                found = true;
            }
        }
        
        
        if ((0 | 1) == N) {
            return 0;
        }
        
        return found ? minX : -1;
    }
}