class Solution {
    public int maxIceCream(int[] costs, int coins) {
        long sum = 0;
        int count = 0;
        for(int i = 0;i<costs.length;i++){
            if(costs[i] > coins){
                count++;
            }
            sum += costs[i];
        }
        if(coins >= sum){
            return costs.length;
        }
        if(count == costs.length){
            return 0;
        }
        Arrays.sort(costs);
        int price = 0;
        for(int i = 0;i<costs.length;i++){
            if(coins >= costs[i]){
               coins = coins - costs[i];
               price++;
            }
        }
        return price;
    }
}