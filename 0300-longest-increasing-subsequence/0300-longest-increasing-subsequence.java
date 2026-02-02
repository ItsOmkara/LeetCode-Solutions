class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] temp = new int[nums.length];
        int len = 0;

        for(int x : nums){
            int i = 0, j = len;
            while(i < j){
                int mid = (i + j) / 2;
                if(temp[mid] < x) i = mid + 1;
                else j = mid;
            }
            temp[i] = x;
            if(i == len) len++;
        }
        return len;
    }
}
