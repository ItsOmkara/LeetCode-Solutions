class Solution {
    public int findDuplicate(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int c : nums) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1){
                return entry.getKey();
            }
        }
        return 0;
    }
}