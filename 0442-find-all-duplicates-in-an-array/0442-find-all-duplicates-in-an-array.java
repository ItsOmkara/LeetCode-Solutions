class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue() == 2){
                l.add(m.getKey());
            }
        }

        return l;
    }
}