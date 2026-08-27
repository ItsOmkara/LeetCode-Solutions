class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] counts = new int[26];
        for (char c : s.toCharArray()) counts[c - 'a']++;

        int lastBreakPos = -1;
        char lastBreakChar = 0;
        int[] lastBreakCounts = null;

        int[] cur = counts.clone();
        boolean tight = true;

        for (int i = 0; i < n && tight; i++) {
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
            }
        }

        if (lastBreakPos == -1) return "";

        StringBuilder sb = new StringBuilder();
        sb.append(target, 0, lastBreakPos);
        sb.append(lastBreakChar);

        int[] rem = lastBreakCounts.clone();
        rem[lastBreakChar - 'a']--;
        for (int c = 0; c < 26; c++) {
            for (int k = 0; k < rem[c]; k++) sb.append((char) ('a' + c));
        }

        return sb.toString();
    }
}