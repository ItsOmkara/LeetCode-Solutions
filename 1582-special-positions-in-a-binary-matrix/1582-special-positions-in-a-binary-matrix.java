class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        
        // Count 1s in each row and column
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        int count = 0;
        
        // Check special positions
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1){
                    count++;
                }
            }
        }
        
        return count;
    }
}