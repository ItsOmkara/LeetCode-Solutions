class Solution {
    private static final long LIMIT = 1_000_000L;

    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) cnt[s.charAt(i) - 'a']++;

        int[] half = new int[26];
        int mid = -1;
        for (int c = 0; c < 26; c++) {
            half[c] = cnt[c] / 2;
            if (cnt[c] % 2 == 1) mid = c;
        }
        int halfLen = n / 2;

        long total = permCount(half);
        if (total < k) return "";

        long kk = k;
        StringBuilder sb = new StringBuilder();
        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;
                half[c]--;
                long cnt2 = permCount(half);
                if (cnt2 >= kk) {
                    sb.append((char) ('a' + c));
                    break;
                } else {
                    kk -= cnt2;
                    half[c]++;
                }
            }
        }

        StringBuilder ans = new StringBuilder(sb);
        if (mid != -1) ans.append((char) ('a' + mid));
        ans.append(sb.reverse());
        return ans.toString();
    }

    private long permCount(int[] freq) {
        int total = 0;
        long count = 1;
        for (int c = 0; c < 26; c++) {
            if (freq[c] == 0) continue;
            int n = total + freq[c];
            long cc = comb(n, freq[c]);
            count *= cc;
            if (count > LIMIT) return LIMIT + 1;
            total = n;
        }
        return count;
    }
    private long comb(int n, int r) {
        if (r < 0 || r > n) return 0;
        r = Math.min(r, n - r);
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
            if (res > LIMIT) return LIMIT + 1;
        }
        return res;
    }
}