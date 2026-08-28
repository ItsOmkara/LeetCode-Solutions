class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;

        int oddCount = 0, oddChar = -1;
        for (int c = 0; c < 26; c++) {
            if (count[c] % 2 == 1) { oddCount++; oddChar = c; }
        }

        boolean nOdd = (n % 2 == 1);
        if (nOdd && oddCount != 1) return "";
        if (!nOdd && oddCount != 0) return "";

        int half = n / 2;
        int[] pairCounts = new int[26];
        for (int c = 0; c < 26; c++) pairCounts[c] = count[c] / 2;
        char midChar = nOdd ? (char) ('a' + oddChar) : 0;

        int[] cur = pairCounts.clone();
        boolean tight = true;
        int lastBreakPos = -1;
        char lastBreakChar = 0;
        int[] lastBreakCounts = null;

        for (int i = 0; i < half; i++) {
            char tc = target.charAt(i);
            for (int c = tc - 'a' + 1; c < 26; c++) {
                if (cur[c] > 0) {
                    lastBreakPos = i;
                    lastBreakChar = (char) ('a' + c);
                    lastBreakCounts = cur.clone();
                    break;
                }
            }
            if (cur[tc - 'a'] > 0) {
                cur[tc - 'a']--;
            } else {
                tight = false;
                break;
            }
        }

        if (tight) {
            String firstHalf = target.substring(0, half);
            StringBuilder sb = new StringBuilder(firstHalf);
            if (nOdd) sb.append(midChar);
            sb.append(new StringBuilder(firstHalf).reverse());
            String candidate = sb.toString();
            if (candidate.compareTo(target) > 0) return candidate;
        }

        if (lastBreakPos == -1) return "";

        StringBuilder h = new StringBuilder();
        h.append(target, 0, lastBreakPos);
        h.append(lastBreakChar);
        int[] rem = lastBreakCounts.clone();
        rem[lastBreakChar - 'a']--;
        for (int c = 0; c < 26; c++) {
            for (int k = 0; k < rem[c]; k++) h.append((char) ('a' + c));
        }

        StringBuilder full = new StringBuilder(h);
        if (nOdd) full.append(midChar);
        full.append(new StringBuilder(h).reverse());

        return full.toString();
    }
}