import java.util.*;

class Solution {
    public int maxSum(int[] nums) {
       
        Map<Integer, List<Integer>> groups = new HashMap<>();
        
        
        for (int num : nums) {
            int maxDigit = getMaxDigit(num);
            groups.putIfAbsent(maxDigit, new ArrayList<>());
            groups.get(maxDigit).add(num);
        }
        
        
        int maxSum = -1;
        
        for (List<Integer> group : groups.values()) {
            if (group.size() >= 2) {
                
                Collections.sort(group, Collections.reverseOrder());
                int sum = group.get(0) + group.get(1);
                maxSum = Math.max(maxSum, sum);
            }
        }
        
        return maxSum;
    }
    
    
    private int getMaxDigit(int num) {
        int maxDigit = 0;
        while (num > 0) {
            int digit = num % 10;
            maxDigit = Math.max(maxDigit, digit);
            num /= 10;
        }
        return maxDigit;
    }
}