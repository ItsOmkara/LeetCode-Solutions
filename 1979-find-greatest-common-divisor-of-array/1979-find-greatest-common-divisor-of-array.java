class Solution {
    public int findGCD(int[] nums) {
        int ans = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }

        ans = gcd(max,min);
        return ans;
    }

    public static int gcd(int a,int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}