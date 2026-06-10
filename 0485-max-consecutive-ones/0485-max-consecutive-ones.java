class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int left = 0;
        int maxCount = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                l.add(i);
                maxCount = Math.max(maxCount,l.size());
            }
            else{
                l.clear();
            }
        }
        return maxCount;
    }
}