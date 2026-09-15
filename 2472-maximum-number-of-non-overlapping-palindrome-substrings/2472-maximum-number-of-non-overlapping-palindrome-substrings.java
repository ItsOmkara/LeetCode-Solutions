class Solution {
    
    private int[] memo;
    
    private boolean[][] isPalindrome;
   
    private String s;
    
    private int n;
    
    private int k;

    /**
     * Finds the maximum number of non-overlapping palindromic substrings
     * with length at least k in the given string.
     * 
     * @param s 
     * @param k 
     * @return 
     */
    public int maxPalindromes(String s, int k) {
        this.n = s.length();
        this.s = s;
        this.k = k;
      
        this.memo = new int[n];
        Arrays.fill(memo, -1);
      
        
        this.isPalindrome = new boolean[n][n];
      
        for (int i = 0; i < n; i++) {
            Arrays.fill(isPalindrome[i], true);
        }
      
        for (int i = n - 1; i >= 0; i--) {
            
            for (int j = i + 1; j < n; j++) {
                
                isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
            }
        }
      
        // Start DFS from index 0 to find maximum palindromes
        return dfs(0);
    }

    /**
     * Depth-first search with memoization to find the maximum number of
     * non-overlapping palindromic substrings starting from index i.
     * 
     * @param i the starting index
     * @return the maximum number of palindromes from index i to the end
     */
    private int dfs(int i) {
        
        if (i >= n) {
            return 0;
        }
      
        if (memo[i] != -1) {
            return memo[i];
        }
        int maxPalindromes = dfs(i + 1);
      
        for (int j = i + k - 1; j < n; j++) {
            
            if (isPalindrome[i][j]) {
                
                maxPalindromes = Math.max(maxPalindromes, 1 + dfs(j + 1));
            }
        }
        memo[i] = maxPalindromes;
        return maxPalindromes;
    }
}
