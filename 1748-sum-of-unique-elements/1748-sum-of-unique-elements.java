class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer,Integer>map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        int sum = 0;
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            if(m.getValue() == 1){
                sum += m.getKey();
            }
        }
        return sum;
    }
}