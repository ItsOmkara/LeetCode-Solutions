class Solution {
    public long distributeCandies(int n, int limit) {
        return totalWays(n) - 3 * totalWays(n - (limit + 1)) + 3 * totalWays(n - 2 * (limit + 1)) - totalWays(n - 3 * (limit + 1));
    }
    
    private long totalWays(int n) {
        if (n < 0) return 0;
        return (long) (n + 2) * (n + 1) / 2;
    }
}