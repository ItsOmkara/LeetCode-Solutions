class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0, count = 0;
        
        
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        maxVowels = count;

        
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) count++;  
            if (isVowel(s.charAt(i - k))) count--;  

            maxVowels = Math.max(maxVowels, count);
        }
        
        return maxVowels;
    }
    
    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;  
    }
}