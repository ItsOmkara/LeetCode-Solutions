class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        boolean[] inStack = new boolean[26];
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (inStack[current - 'a']) {
                continue;
            }
            while (stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > current &&
                   last[stack.charAt(stack.length() - 1) - 'a'] > i) {

                char removed = stack.charAt(stack.length() - 1);

                inStack[removed - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }

            stack.append(current);
            inStack[current - 'a'] = true;
        }

        return stack.toString();
    }
}