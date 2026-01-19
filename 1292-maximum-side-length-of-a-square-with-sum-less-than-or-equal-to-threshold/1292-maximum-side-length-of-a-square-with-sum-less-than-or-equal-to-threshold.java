class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] prefix = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }
        
        int left = 0, right = Math.min(m, n), ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 || hasValidSquare(prefix, m, n, mid, threshold)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
    public boolean hasValidSquare(int[][] prefix, int m, int n, int side, int threshold) {
        for (int i = side; i <= m; i++) {
            for (int j = side; j <= n; j++) {
                int sum = prefix[i][j] - prefix[i-side][j] - prefix[i][j-side] + prefix[i-side][j-side];
                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
