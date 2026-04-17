class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Long, Integer> lastSeen = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long rev = reverse(num);
            if (lastSeen.containsKey(num)) {
                minDistance = Math.min(minDistance, i - lastSeen.get(num));
            }
            lastSeen.put(rev, i);
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
    
    private long reverse(long n) {
        long result = 0;
        while (n > 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }
        return result;
    }
}