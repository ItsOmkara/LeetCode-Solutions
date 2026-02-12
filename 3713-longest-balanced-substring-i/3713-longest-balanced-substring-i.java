class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            
            if (n - i <= maxLen) {
                break;
            }
            int[] freq = new int[26];
            int distinctChars = 0;
            
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                
                if (freq[c - 'a'] == 0) {
                    distinctChars++;
                }
                
                freq[c - 'a']++;
                
                int currentLen = j - i + 1;
                if (currentLen <= maxLen) {
                    continue;
                }
                
                int targetFreq = freq[s.charAt(i) - 'a'];
                boolean balanced = true;
                
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0 && freq[k] != targetFreq) {
                        balanced = false;
                        break;
                    }
                }
                
                if (balanced) {
                    maxLen = Math.max(maxLen, currentLen);
                }
            }
        }
        
        return maxLen;
    }
}