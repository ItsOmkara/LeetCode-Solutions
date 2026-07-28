class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int n = nums.length;
        int max = 0;
        int min = Integer.MAX_VALUE;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i<n;i++){
            if(max < nums[i]){
                max = nums[i];
            }
            if(min > nums[i]){
                min = nums[i];
            }

            hs.add(nums[i]);
        }
        for(int i = min;i<=max;i++){
            if(!hs.contains(i)){
                l.add(i);
            }
        }

        return l;
    }
}