class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            char currentChar = nums[i].charAt(i);
            if (currentChar == '0') {
                result.append('1');
            } else {
                result.append('0');
            }
        }
        
        return result.toString();
    }
}