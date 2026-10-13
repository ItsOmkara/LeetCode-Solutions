import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        int[] brr = Arrays.stream(nums)
                          .map(x -> x * x)
                          .toArray();

        Arrays.sort(brr);

        long sum = 0;
        int positiveCount = (n + 1) / 2;

       
        for (int i = n - 1; i >= n - positiveCount; i--) {
            sum += brr[i];
        }

        
        for (int i = 0; i < n / 2; i++) {
            sum -= brr[i];
        }

        return sum;
    }
}