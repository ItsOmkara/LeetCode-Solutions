class Solution {
    public int[] validSequence(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int[] suf = new int[n1 + 1];
        suf[n1] = 0;
        for (int i = n1 - 1; i >= 0; i--) {
            suf[i] = suf[i + 1];
            if (suf[i] < n2 && word1.charAt(i) == word2.charAt(n2 - 1 - suf[i])) {
                suf[i]++;
            }
        }
        
        int[] res = new int[n2];
        int idx = 0, j = 0;
        boolean used = false;
        
        for (int i = 0; i < n1 && j < n2; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                res[idx++] = i;
                j++;
            } else if (!used && suf[i + 1] >= n2 - j - 1) {
                used = true;
                res[idx++] = i;
                j++;
            }
        }
        
        if (j < n2) return new int[0];
        return res;
    }
}