class Solution {
    public int singleNumber(int[] nums){
        int n = nums.length;
        boolean[] isVisited = new boolean[n];
        for(int i=0;i<n;i++){
            if(isVisited[i]){
                continue;
            }
            int count = 1;
            for(int j = i+1 ; j<n; j++){
                if(nums[i]==nums[j]){
                    isVisited[j] = true;
                    count++;
                }
            }
            if (count == 1) {
                return nums[i];   
            }
        }
        return -1;
    }
}