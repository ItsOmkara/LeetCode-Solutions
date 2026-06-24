class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) return m;

        long[][] up = new long[m][m];
        long[][] down = new long[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                up[i][j] = 1;
            }
            for (int j = i + 1; j < m; j++) {
                down[i][j] = 1;
            }
        }

        long[][] ud = multiply(up, down, m);

        int len = n - 1;
        long[][] res = power(ud, len / 2, m);

        if ((len & 1) == 1) {
            res = multiply(res, up, m);
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                ans += res[i][j];
                ans %= MOD;
            }
        }

        ans = (ans * 2) % MOD;

        return (int) ans;
    }

    private long[][] multiply(long[][] a, long[][] b, int n) {
        long[][] c = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;

                for (int j = 0; j < n; j++) {
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return c;
    }

    private long[][] power(long[][] mat, int exp, int n) {
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, mat, n);
            }

            mat = multiply(mat, mat, n);
            exp >>= 1;
        }

        return res;
    }
}