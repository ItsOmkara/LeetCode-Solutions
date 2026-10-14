class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num || sum <= 0) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        int remaining = sum;
        
        for (int i = 0; i < num; i++) {
            int remainingPositions = num - i - 1;
            int maxDigit = Math.min(9, remaining);
            
            int minDigit = Math.max(0, remaining - 9 * remainingPositions);
            int digit = maxDigit;
            
            result.append(digit);
            remaining -= digit;
        }
        
        return result.toString();
    }
}