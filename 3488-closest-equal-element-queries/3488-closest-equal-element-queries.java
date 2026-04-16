class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
    int n = nums.length;
        List<Integer> answer = new ArrayList<>();
        
        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        for (int query : queries) {
            int targetValue = nums[query];
            List<Integer> indices = valueToIndices.get(targetValue);
            
            if (indices.size() == 1) {
                answer.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(indices, query);
            
            
            int minDistance = Integer.MAX_VALUE;
            
           
            int leftIdx = (pos - 1 + indices.size()) % indices.size();
            int leftDist = getCircularDistance(query, indices.get(leftIdx), n);
            minDistance = Math.min(minDistance, leftDist);
            
           
            int rightIdx = (pos + 1) % indices.size();
            int rightDist = getCircularDistance(query, indices.get(rightIdx), n);
            minDistance = Math.min(minDistance, rightDist);
            
            answer.add(minDistance);
        }
        
        return answer;
    }
    
    private int getCircularDistance(int i, int j, int n) {
        int directDist = Math.abs(i - j);
        int circularDist = n - directDist;
        return Math.min(directDist, circularDist);
    }
}