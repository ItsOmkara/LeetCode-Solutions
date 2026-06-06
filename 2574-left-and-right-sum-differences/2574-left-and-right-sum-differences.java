class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] finals = new int[n];
        if(n == 1){
            finals[0] = 0;
            return finals;
        }
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        for(int i = 0;i<n;i++){
            if(i == 0){
                leftSum[i] = 0;
            }
            else{
            leftSum[i] = nums[i - 1] +  leftSum[i - 1];
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                rightSum[i] = 0;
            } else {
                rightSum[i] = nums[i + 1] + rightSum[i + 1];
            }
        }

        for(int i = 0;i<n;i++){
            finals[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return finals;    
    }
}