class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(!stack.isEmpty()) {
                char top = stack.peek();
                if((top == 'A' && ch == 'B') || (top == 'C' && ch == 'D')) {
                    stack.pop(); // remove pair
                    continue;
                }
            }
            stack.push(ch);
        }

        return stack.size();
    }
}