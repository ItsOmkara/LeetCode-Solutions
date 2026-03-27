class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        for (int i = 0; i < m; i++) {
        
            int[] originalRow = mat[i];
            int[] currentRow = originalRow.clone();
            
            for (int step = 0; step < k; step++) {
                if (i % 2 == 0) {
                    
                    int first = currentRow[0];
                    for (int j = 0; j < n - 1; j++) {
                        currentRow[j] = currentRow[j + 1];
                    }
                    currentRow[n - 1] = first;
                } else {
                    
                    int last = currentRow[n - 1];
                    for (int j = n - 1; j > 0; j--) {
                        currentRow[j] = currentRow[j - 1];
                    }
                    currentRow[0] = last;
                }
            }

            for (int j = 0; j < n; j++) {
                if (currentRow[j] != originalRow[j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}