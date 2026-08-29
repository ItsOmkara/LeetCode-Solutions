class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> nums[a] - nums[b]);

        int[] result = new int[n];
        int i = 0;
        while (i < n) {
            int j = i;
            
            while (j + 1 < n && nums[idx[j + 1]] - nums[idx[j]] <= limit) {
                j++;
            }
            
            List<Integer> groupIndices = new ArrayList<>();
            for (int k = i; k <= j; k++) groupIndices.add(idx[k]);
            Collections.sort(groupIndices); 

            for (int k = 0; k <= j - i; k++) {
                result[groupIndices.get(k)] = nums[idx[i + k]];
            }

            i = j + 1;
        }

        return result;
    }
}