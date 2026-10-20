class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int total = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean ok = true;
            int prevMax = 0;

            for (int s = 0; s < n && ok; s += k) {
                int desc = 0;
                int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;

                for (int i = 0; i < k; i++) {
                    int cur = nums[s + i];
                    int next = nums[s + (i + 1) % k]; 
                    if (cur > next) desc++;
                    mn = Math.min(mn, cur);
                    mx = Math.max(mx, cur);
                }

                
                if (desc > 1 || mn < prevMax) {
                    ok = false;
                } else {
                    prevMax = mx;
                }
            }

            if (ok) total += k;
        }
        return total;
    }
}