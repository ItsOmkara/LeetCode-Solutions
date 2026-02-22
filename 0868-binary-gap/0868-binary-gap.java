class Solution {
    public int binaryGap(int n) {
        int prev = -1;   // previous 1-bit position
        int maxGap = 0;
        int pos = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (prev != -1) {
                    maxGap = Math.max(maxGap, pos - prev);
                }
                prev = pos;
            }
            pos++;
            n >>= 1;
        }

        return maxGap;
    }
}