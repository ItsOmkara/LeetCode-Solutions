class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int p = nums.get(i);
            if ((p & 1) == 0) {  
                ans[i] = -1;
                continue;
            }
            for (int k = 1; k < 32; k++) {  
                if (((p >> k) & 1) == 0) {
                    ans[i] = p ^ (1 << (k - 1));
                    break;
                }
            }
        }
        return ans;
    }
}
