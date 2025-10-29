class Solution {
    public boolean buddyStrings(String s, String goal) {
        // If lengths are different, impossible to match
        if (s.length() != goal.length()) {
            return false;
        }
        
        // If strings are identical, check if we can swap same characters
        if (s.equals(goal)) {
            // Check for duplicate characters
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
                if (freq[c - 'a'] > 1) {
                    return true; // Found duplicate, can swap them
                }
            }
            return false; // No duplicates, can't swap
        }
        
        // Find positions where characters differ
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) {
                    first = i; // First mismatch
                } else if (second == -1) {
                    second = i; // Second mismatch
                } else {
                    return false; // More than 2 mismatches
                }
            }
        }
        
        // Check if we have exactly 2 mismatches and swapping works
        return (second != -1 && 
                s.charAt(first) == goal.charAt(second) && 
                s.charAt(second) == goal.charAt(first));
    }
}