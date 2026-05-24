class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dfs(arr, i, d, memo));
        }
        return result;
    }
    
    private int dfs(int[] arr, int idx, int d, int[] memo) {
        if (memo[idx] != -1) {
            return memo[idx];
        }
        
        int maxPath = 1; 
        for (int i = idx + 1; i <= Math.min(arr.length - 1, idx + d); i++) {
            if (arr[i] >= arr[idx]) {
                break;
            }
            maxPath = Math.max(maxPath, 1 + dfs(arr, i, d, memo));
        }
        
        for (int i = idx - 1; i >= Math.max(0, idx - d); i--) {
            
            if (arr[i] >= arr[idx]) {
                break;
            }
            maxPath = Math.max(maxPath, 1 + dfs(arr, i, d, memo));
        }
        
        memo[idx] = maxPath;
        return maxPath;
    }
}