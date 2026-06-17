class Solution {
    public char processStr(String s, long k) {

        int n = s.length();
        long[] len = new long[n];

        long curr = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) {
                curr++;
            }
            else if (ch == '*') {
                if (curr > 0)
                    curr--;
            }
            else if (ch == '#') {
                curr *= 2;
            }
            // %
            // length same

            len[i] = curr;
        }

        if (k >= curr)
            return '.';

        for (int i = n - 1; i >= 0; i--) {

            char ch = s.charAt(i);
            long currLen = len[i];

            if (Character.isLowerCase(ch)) {

                if (k == currLen - 1)
                    return ch;

                // remove this character
                // k remains same
            }

            else if (ch == '#') {

                long prevLen = currLen / 2;
                k %= prevLen;
            }

            else if (ch == '%') {

                k = currLen - 1 - k;
            }
        }

        return '.';
    }
}