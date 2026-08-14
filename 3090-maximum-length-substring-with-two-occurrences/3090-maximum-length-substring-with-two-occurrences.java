class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        int max = 0;
        int[] freq = new int[256];
        for(int right = 0;right < s.length();right++){
            char ch = s.charAt(right);
            freq[ch]++;

            while(freq[ch] > 2){
                freq[s.charAt(left)]--;
                left++;
            }
            max = Math.max(max,right - left + 1);
        }

        return max;
    }
}