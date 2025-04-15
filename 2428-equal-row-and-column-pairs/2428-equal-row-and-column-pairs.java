import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowCounts = new HashMap<>();
        int result = 0;

        for (int[] row : grid) {
            String rowStr = Arrays.toString(row);
            rowCounts.put(rowStr, rowCounts.getOrDefault(rowStr, 0) + 1);
        }

        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = grid[i][j];
            }
            String colStr = Arrays.toString(column);
            result += rowCounts.getOrDefault(colStr, 0);
        }

        return result;
    }
}