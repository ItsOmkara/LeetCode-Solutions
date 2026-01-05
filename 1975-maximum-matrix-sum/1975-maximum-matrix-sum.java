class Solution {
    public long maxMatrixSum(int[][] matrix) {
       int n = matrix.length;
        long totalAbsSum = 0;
        int minAbs = Integer.MAX_VALUE;
        int negCountBlack = 0; 
        int negCountWhite = 0; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                int absVal = Math.abs(val);
                totalAbsSum += absVal;
                minAbs = Math.min(minAbs, absVal);
                
                
                if ((i + j) % 2 == 0) { 
                    if (val < 0) negCountBlack++;
                } else { 
                    if (val < 0) negCountWhite++;
                }
            }
        }

        if ((negCountBlack % 2) == (negCountWhite % 2)) {
            return totalAbsSum;
        } else {
            return totalAbsSum - 2L * minAbs;
        } 
    }
}