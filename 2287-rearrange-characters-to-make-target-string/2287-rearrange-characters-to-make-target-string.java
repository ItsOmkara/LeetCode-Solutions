class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for (char c : s.toCharArray()) {
            freqS[c - 'a']++;
        }

        for (char c : target.toCharArray()){
            freqT[c - 'a']++;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            if (freqT[i] > 0){
                ans = Math.min(ans, freqS[i] / freqT[i]);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}