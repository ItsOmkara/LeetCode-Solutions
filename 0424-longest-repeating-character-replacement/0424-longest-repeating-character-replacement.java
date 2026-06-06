class Solution {
    public int characterReplacement(String s, int k) {
        StringBuilder sc = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sc.append(s.charAt(i));
        }
        int[] counts = new int[26];
        int left = 0;
        int maxRepeatCount = 0;
        int maxLen = 0;
        for (int right = 0; right < sc.length(); right++) {
            char rightChar = sc.charAt(right);
            counts[rightChar - 'A']++;
            maxRepeatCount = Math.max(maxRepeatCount, counts[rightChar - 'A']);
            if ((right - left + 1) - maxRepeatCount > k) {
                char leftChar = sc.charAt(left);
                counts[leftChar - 'A']--;
                left++; 
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
