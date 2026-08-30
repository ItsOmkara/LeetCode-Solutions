class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxPos = 0;
        int minPos = 0;

        for(int i = 0;i<n;i++){
            if(nums[i] > max){
                max = nums[i];
                maxPos = i;
            }

            if(nums[i] < min){
                min = nums[i];
                minPos = i;
            }
        }

        int left = 0;
        int right = n - 1;
        int minDeletions = 0;
        int count = 1;
        
        int bothFront = Math.max(maxPos, minPos) + 1;

        int bothBack = n - Math.min(maxPos, minPos);

        int maxFrontMinBack = maxPos + 1 + (n - minPos);

        int minFrontMaxBack = minPos + 1 + (n - maxPos);

        return Math.min(
            Math.min(bothFront, bothBack),
            Math.min(maxFrontMinBack, minFrontMaxBack)
        );

    }
}