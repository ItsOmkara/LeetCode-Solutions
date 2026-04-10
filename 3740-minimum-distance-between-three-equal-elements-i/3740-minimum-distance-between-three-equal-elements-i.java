class Solution {
    public int minimumDistance(int[] nums) {
        // Group indices by value
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int minDist = Integer.MAX_VALUE;
        
        for (List<Integer> indices : map.values()) {
            // Only care if value appears at least 3 times
            if (indices.size() < 3) continue;
            
            // Check every combination of 3 indices
            for (int a = 0; a < indices.size() - 2; a++) {
                for (int b = a + 1; b < indices.size() - 1; b++) {
                    for (int c = b + 1; c < indices.size(); c++) {
                        int i = indices.get(a);
                        int j = indices.get(b);
                        int k = indices.get(c);
                        
                        int dist = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
                        minDist = Math.min(minDist, dist);
                    }
                }
            }
        }
        
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}