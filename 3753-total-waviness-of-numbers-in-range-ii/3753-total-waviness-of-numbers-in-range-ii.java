class Solution {
    public long totalWaviness(long num1, long num2) {
        return count(num2) - count(num1 - 1);
    }

    private long count(long x) {
        String s = Long.toString(x);
        int n = s.length();
        long[][][][] dpCnt = new long[11][11][2][2];
        long[][][][] dpWav = new long[11][11][2][2];
        long[][][][] newCnt = new long[11][11][2][2];
        long[][][][] newWav = new long[11][11][2][2];
        for (long[][][] a : dpCnt)
            for (long[][] b : a)
                for (long[] c : b)
                    java.util.Arrays.fill(c, 1L);

        for (int i = n - 1; i >= 0; i--) {
            // Clear new_dp
            for (long[][][] a : newCnt)
                for (long[][] b : a)
                    for (long[] c : b) java.util.Arrays.fill(c, 0L);
            for (long[][][] a : newWav)
                for (long[][] b : a)
                    for (long[] c : b) java.util.Arrays.fill(c, 0L);

            int digitAtI = s.charAt(i) - '0';

            for (int prev = -1; prev <= 9; prev++) {
                for (int prev2 = -1; prev2 <= 9; prev2++) {
                    for (int zero = 0; zero <= 1; zero++) {
                        for (int tight = 0; tight <= 1; tight++) {
                            long cnt = 0, wav = 0;
                            int mx = (tight == 1) ? digitAtI : 9;

                            for (int d = 0; d <= mx; d++) {
                                int newTight = (tight == 1 && d == digitAtI) ? 1 : 0;
                                int newZero  = (zero  == 1 && d == 0)        ? 1 : 0;
                                int newPrev2 = prev;
                                int newPrev  = (newZero == 0) ? d : -1;

                                long nCnt = dpCnt[newPrev + 1][newPrev2 + 1][newZero][newTight];
                                long nWav = dpWav[newPrev + 1][newPrev2 + 1][newZero][newTight];

                                cnt += nCnt;

                                if (zero == 0 && prev2 != -1) {
                                    if ((prev2 < prev && prev > d) || (prev2 > prev && prev < d)) {
                                        wav += nCnt;
                                    }
                                }
                                wav += nWav;
                            }

                            newCnt[prev + 1][prev2 + 1][zero][tight] = cnt;
                            newWav[prev + 1][prev2 + 1][zero][tight] = wav;
                        }
                    }
                }
            }
            long[][][][] tmp;
            tmp = dpCnt; dpCnt = newCnt; newCnt = tmp;
            tmp = dpWav; dpWav = newWav; newWav = tmp;
        }
        return dpWav[0][0][1][1];
    }
}