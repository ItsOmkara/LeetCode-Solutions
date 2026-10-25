import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int closedIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        // 1. Eliminate islands touching the border
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boolean onBorder = r == 0 || r == rows - 1 || c == 0 || c == cols - 1;
                if (onBorder && grid[r][c] == 0) {
                    sink(grid, r, c);
                }
            }
        }

        // 2. Count remaining (closed) islands
        int count = 0;
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (grid[r][c] == 0) {
                    count++;
                    sink(grid, r, c);
                }
            }
        }
        return count;
    }

    // Iterative DFS: marks the whole connected land region as water
    private void sink(int[][] grid, int r, int c) {
        int rows = grid.length, cols = grid[0].length;
        Deque<int[]> stack = new ArrayDeque<>();
        grid[r][c] = 1;
        stack.push(new int[]{r, c});

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            for (int[] d : DIRS) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1;
                    stack.push(new int[]{nr, nc});
                }
            }
        }
    }
}