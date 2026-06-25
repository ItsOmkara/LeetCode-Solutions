class Solution {
    
    public int countMajoritySubarrays(int[] nums, int target) {

        int ans = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {

            int freq = 0;

            for(int j = i; j < n; j++) {

                if(nums[j] == target)
                    freq++;

                int len = j - i + 1;

                if(2 * freq > len)
                    ans++;
            }
        }

        return ans;
    }

    
}