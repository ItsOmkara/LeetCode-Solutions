class Solution {
    public void setZeroes(int[][] matrix) {
    int r = matrix.length;
    int c = matrix[0].length;

    boolean[] zeroRow = new boolean[r];
    boolean[] zeroCol = new boolean[c];

    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            if(matrix[i][j]==0){
                zeroRow[i]=true;
                zeroCol[j]=true;
            }
        }
    }

    for(int i=0;i<r;i++){
        if(zeroRow[i]){
            for(int j=0;j<c;j++){
                matrix[i][j]=0;
            }
        }
    }

    for(int j=0;j<c;j++){
        if(zeroCol[j]){
            for(int i=0;i<r;i++){
                matrix[i][j]=0;
            }
        }
    }
    }
}