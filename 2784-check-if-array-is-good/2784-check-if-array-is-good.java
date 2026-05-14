class Solution {
    public boolean isGood(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        int maxVal = 0;
        
        
        Map<Integer, Integer> counts = new HashMap<>();


        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        
        int n = maxVal;


        if (nums.length != n + 1) {
            return false;
        }

        
        if (counts.getOrDefault(n, 0) != 2) {
            return false;
        }


        for (int i = 1; i < n; i++) {
            if (counts.getOrDefault(i, 0) != 1) {
                return false;
            }
        }

        return true;
    }
}