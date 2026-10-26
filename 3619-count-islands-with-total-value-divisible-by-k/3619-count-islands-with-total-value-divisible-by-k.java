class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[] dirs = {0, 1, 0, -1, 0};
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long sum = 0;
                    java.util.ArrayDeque<int[]> stack = new java.util.ArrayDeque<>();
                    stack.push(new int[]{i, j});
                    sum += grid[i][j];
                    grid[i][j] = 0; // mark visited

                    while (!stack.isEmpty()) {
                        int[] cur = stack.pop();
                        for (int d = 0; d < 4; d++) {
                            int x = cur[0] + dirs[d];
                            int y = cur[1] + dirs[d + 1];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > 0) {
                                sum += grid[x][y];
                                grid[x][y] = 0;
                                stack.push(new int[]{x, y});
                            }
                        }
                    }

                    if (sum % k == 0) count++;
                }
            }
        }
        return count;
    }
}