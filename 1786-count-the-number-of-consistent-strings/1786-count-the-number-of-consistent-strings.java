class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allowedChars = new boolean[26];
        
        
        for (char c : allowed.toCharArray()) {
            allowedChars[c - 'a'] = true;
        }
        
        int count = 0;
        
        
        for (String word : words) {
            boolean isConsistent = true;
            
            
            for (char c : word.toCharArray()) {
                if (!allowedChars[c - 'a']) {
                    isConsistent = false;
                    break;
                }
            }
            
            
            if (isConsistent) {
                count++;
            }
        }
        
        return count;
    }
}