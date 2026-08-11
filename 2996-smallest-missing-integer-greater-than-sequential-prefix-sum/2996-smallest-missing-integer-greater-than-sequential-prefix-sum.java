class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        Set<Integer> l =  new HashSet<>();
        int sum = nums[0];
        for(int i = 0;i<n;i++){
            l.add(nums[i]);
        }
        
        for(int i = 1;i<n;i++){
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        while(l.contains(sum)){
            sum++;
        }

        return sum;
    }
}