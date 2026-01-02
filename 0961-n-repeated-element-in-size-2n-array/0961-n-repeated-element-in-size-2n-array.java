class Solution {
    public int repeatedNTimes(int[] nums) {
       int n = nums.length; 
       int result = 0;  
    Map<Integer, Integer> map = new HashMap<>();
    
    for(int i = 0; i < n; i++){
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); 
    }
    
    
    final int[] resultArray = {0};
    map.forEach((a, b) -> {
        if(b == n / 2){  
            resultArray[0] = a;
        }
    });
    
    return resultArray[0];
    }
}