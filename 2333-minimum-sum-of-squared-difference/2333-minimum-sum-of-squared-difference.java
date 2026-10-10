class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int[] diff = new int[n];
        long sum = 0;
        int mx = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i];
            mx = Math.max(mx, diff[i]);
        }

        
        if (sum <= k) return 0;

        
        long[] cnt = new long[mx + 1];
        for (int d : diff) cnt[d]++;

        
        for (int d = mx; d > 0; d--) {
            if (cnt[d] == 0) continue;

            if (k >= cnt[d]) {
                
                k -= cnt[d];
                cnt[d - 1] += cnt[d];
                cnt[d] = 0;
            } else {
                
                cnt[d] -= k;
                cnt[d - 1] += k;
                k = 0;
                break;
            }
        }

        long ans = 0;
        for (int d = 0; d <= mx; d++) {
            ans += cnt[d] * (long) d * d;
        }
        return ans;
    }
}