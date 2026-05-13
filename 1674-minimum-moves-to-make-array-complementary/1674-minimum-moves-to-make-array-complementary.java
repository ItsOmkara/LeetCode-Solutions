class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];
        
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            
            int sum = a + b;
            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;
            
            diff[2] += 2;
            diff[low] -= 1;
            diff[sum] -= 1;
            diff[sum + 1] += 1;
            diff[high + 1] += 1;
        }
        
        int minMoves = Integer.MAX_VALUE;
        int curr = 0;
        for (int s = 2; s <= 2 * limit; s++) {
            curr += diff[s];
            minMoves = Math.min(minMoves, curr);
        }
        
        return minMoves;
    }
}