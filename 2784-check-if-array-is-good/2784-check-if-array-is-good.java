class Solution {
    public boolean isGood(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        int maxVal = 0;
        // Use a HashMap to store frequencies during the first pass
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // M is the candidate for n
        int n = maxVal;

        // 2. Length Validation
        // A good array must have a length of n + 1.
        if (nums.length != n + 1) {
            return false;
        }

        // 3. Frequency Validation
        
        // Check the maximum element 'n'
        // 'n' must appear exactly twice.
        if (counts.getOrDefault(n, 0) != 2) {
            return false;
        }

        // Check elements from 1 to n - 1
        // These elements must each appear exactly once.
        for (int i = 1; i < n; i++) {
            if (counts.getOrDefault(i, 0) != 1) {
                return false;
            }
        }
        return true;
    }
}