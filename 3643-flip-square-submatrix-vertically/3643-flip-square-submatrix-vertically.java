class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int[][] result = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result[i][j] = grid[i][j];
            }
        }

        for (int i = 0; i < k / 2; i++) {
            int topRow = x + i;
            int bottomRow = x + k - 1 - i;

            for (int j = y; j < y + k; j++) {
                int temp = result[topRow][j];
                result[topRow][j] = result[bottomRow][j];
                result[bottomRow][j] = temp;
            }
        }
        
        return result;

    }
}