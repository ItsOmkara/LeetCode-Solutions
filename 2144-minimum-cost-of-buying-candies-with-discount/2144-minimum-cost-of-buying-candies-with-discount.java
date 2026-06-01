class Solution {
    public int minimumCost(int[] cost) {
        int totalCost = 0;
        Arrays.sort(cost);
        for(int i = cost.length - 1;i>=0;i--){
            totalCost += cost[i];
            i--;
            if (i >= 0) {
                totalCost += cost[i];
            }
            i--; 
        }
        return totalCost;
    }
}