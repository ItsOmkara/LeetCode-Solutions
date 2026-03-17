class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = (i > 0) ? matrix[i-1][j] + 1 : 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
            int[] row = matrix[i];
            Integer[] rowInteger = new Integer[n];
            for (int j = 0; j < n; j++) {
                rowInteger[j] = row[j];
            }
            Arrays.sort(rowInteger, Collections.reverseOrder());
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, rowInteger[j] * (j + 1));
            }
        }
        
        return maxArea;
    }
}