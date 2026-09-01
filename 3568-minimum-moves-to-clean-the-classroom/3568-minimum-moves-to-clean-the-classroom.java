import java.util.*;
class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) grid[i] = classroom[i].toCharArray();

        int sr = -1, sc = -1;
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) Arrays.fill(row, -1);
        int litterCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') { sr = i; sc = j; }
                else if (grid[i][j] == 'L') { litterId[i][j] = litterCount++; }
            }
        }

        if (litterCount == 0) return 0;

        int full = (1 << litterCount) - 1;
        boolean[][][][] visited = new boolean[m][n][1 << litterCount][energy + 1];

        Deque<int[]> queue = new ArrayDeque<>();
        visited[sr][sc][0][energy] = true;
        queue.add(new int[]{sr, sc, 0, energy});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1], mask = cur[2], e = cur[3];

                if (mask == full) return steps;
                if (e == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d], nc = c + dc[d];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if (grid[nr][nc] == 'X') continue;

                    int newMask = mask;
                    if (litterId[nr][nc] != -1) newMask |= (1 << litterId[nr][nc]);

                    int newE = (grid[nr][nc] == 'R') ? energy : e - 1;

                    if (!visited[nr][nc][newMask][newE]) {
                        visited[nr][nc][newMask][newE] = true;
                        queue.add(new int[]{nr, nc, newMask, newE});
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}