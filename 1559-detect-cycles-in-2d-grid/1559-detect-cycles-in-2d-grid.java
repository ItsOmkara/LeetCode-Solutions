class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (hasCycle(grid, i, j, visited, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean hasCycle(char[][] grid, int i, int j, boolean[][] visited, 
                            int parentI, int parentJ) {
        visited[i][j] = true;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && 
                grid[newI][newJ] == grid[i][j]) {
                if (newI == parentI && newJ == parentJ) {
                    continue;
                }
                if (visited[newI][newJ]) {
                    return true;
                }
                if (hasCycle(grid, newI, newJ, visited, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
}