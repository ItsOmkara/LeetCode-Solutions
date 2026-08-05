class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDistance = 0;

        int globalMin = arrays.get(0).get(0);
        int globalMax = arrays.get(0).get(arrays.get(0).size() - 1);

        for(int i = 1;i<arrays.size();i++){
            List<Integer> currentList = arrays.get(i);
            int currMin = currentList.get(0);
            int currMax = currentList.get(currentList.size() - 1);

            int distance1 = Math.abs(currMax - globalMin);
            int distance2 = Math.abs(globalMax - currMin);

            maxDistance = Math.max(maxDistance, Math.max(distance1,distance2));

            globalMin = Math.min(globalMin, currMin);
            globalMax = Math.max(globalMax, currMax);
        }

        return maxDistance;
    }
}