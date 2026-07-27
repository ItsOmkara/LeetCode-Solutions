class Solution {
    public int[] searchRange(int[] nums, int target) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        int n = nums.length;
        for(int i = 0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        int lastIndex = 0;
        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        for(Map.Entry<Integer,Integer>m:map.entrySet()){
            int x = m.getKey();
            int y = m.getValue();
            int currFreq = m.getValue();
            lastIndex += y;
            if(target == x){
                int firstIndex = lastIndex - currFreq;
                int currlastIndex = lastIndex - 1;
                arr[0] = firstIndex;
                arr[1] = currlastIndex;
                return arr;
            } 
        }

        return arr;
    }
}