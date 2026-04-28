class Solution {
    public int minOperations(int[][] grid, int x) {
    
    int m = grid.length, n = grid[0].length;
    int[] arr = new int[m * n];
    int idx = 0;
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            arr[idx++] = grid[i][j];
        }
    }
    
    int remainder = arr[0] % x;
    for (int num : arr) {
        if (num % x != remainder) {
            return -1;
        }
    }

    Arrays.sort(arr);
    int median = arr[arr.length / 2];

    int operations = 0;
    for (int num : arr) {
        operations += Math.abs(num - median) / x;
    }
    
    return operations;
}
}