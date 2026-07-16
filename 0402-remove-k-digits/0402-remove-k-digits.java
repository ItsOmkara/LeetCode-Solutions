class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k >= n) {
            return "0"; 
        }

        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char digit = num.charAt(i);
            while (k > 0 && stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(digit);
        }
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        int idx = 0;
        while (idx < stack.length() && stack.charAt(idx) == '0') {
            idx++;
        }

        String result = (idx == stack.length()) ? "0" : stack.substring(idx);
        return result;
    }
}