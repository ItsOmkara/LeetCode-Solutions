class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length; 
        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            int lastEmpty = n - 1;
            
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') {
                    
                    lastEmpty = j - 1;
                } else if (boxGrid[i][j] == '#') {
                   
                    boxGrid[i][j] = '.';
                    boxGrid[i][lastEmpty] = '#';
                    lastEmpty--;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = boxGrid[i][j];
            }
        }
        
        return result;
    }
}