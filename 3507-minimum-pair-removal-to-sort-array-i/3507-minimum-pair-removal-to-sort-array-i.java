class Solution {
    public int minimumPairRemoval(int[] nums) {
        int operations = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        
        
        while (!isNonDecreasing(list)) {
            
            int minSum = Integer.MAX_VALUE;
            int minIndex = -1;
            
            for (int i = 0; i < list.size() - 1; i++) {
                int currentSum = list.get(i) + list.get(i + 1);
                if (currentSum < minSum) {
                    minSum = currentSum;
                    minIndex = i;
                }
            }
            
            
            list.set(minIndex, minSum); 
            list.remove(minIndex + 1);    
            
            operations++;
        }
        
        return operations;
    }
    
    private boolean isNonDecreasing(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}