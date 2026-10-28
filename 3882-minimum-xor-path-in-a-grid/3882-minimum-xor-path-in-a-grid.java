class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        final int SIZE = 1024;

        boolean[][] prev = new boolean[n][SIZE];
        for (int i = 0; i < m; i++) {
            boolean[][] cur = new boolean[n][SIZE];
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                if (i == 0 && j == 0) {
                    cur[0][v] = true;
                    continue;
                }
                if (i > 0) {
                    boolean[] up = prev[j];
                    for (int x = 0; x < SIZE; x++) {
                        if (up[x]) cur[j][x ^ v] = true;
                    }
                }
                if (j > 0) {
                    boolean[] left = cur[j - 1];
                    for (int x = 0; x < SIZE; x++) {
                        if (left[x]) cur[j][x ^ v] = true;
                    }
                }
            }
            prev = cur;
        }

        for (int x = 0; x < SIZE; x++) {
            if (prev[n - 1][x]) return x;
        }
        return -1;
    }
}