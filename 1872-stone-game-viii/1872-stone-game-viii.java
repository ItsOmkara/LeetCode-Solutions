class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int maxDifference = sum;
        for (int i = n - 2; i > 0; i--) {
            sum -= stones[i + 1]; 
            maxDifference = Math.max(maxDifference, sum - maxDifference);
        }
        
        return maxDifference;
    }
}