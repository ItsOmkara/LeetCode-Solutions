class Solution {
    public int[] sortedSquares(int[] nums) {
        int sorted[] = new int[nums.length];
        int curr = 0;
        for(int i = 0;i<sorted.length;i++){
            curr = (nums[i] * nums[i]);
            sorted[i] = curr;
        }
        Arrays.sort(sorted);
        return sorted;
    }
}