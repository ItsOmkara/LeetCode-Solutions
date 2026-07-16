class Solution {
   public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] pG = new int[n];
        int max = nums[0];
        
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                max = Math.max(max, nums[i]);
            }
            pG[i] = gcd(nums[i], max);
        }

        Arrays.sort(pG);
        
        long sum = 0;
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            sum += gcd(pG[left], pG[right]);
            left++;
            right--;
        }
        
        return sum;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}