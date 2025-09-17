import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // If the current string length equals max * 2, it's complete
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        // If we can still add '('
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        
        // If we can add ')' without breaking the rule
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
