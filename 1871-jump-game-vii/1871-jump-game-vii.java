class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') return false;
        boolean[] canReach = new boolean[n];
        canReach[0] = true;
        int reachableCount = 0;
        
        for (int i = 1; i < n; i++) {
            if (i - minJump >= 0 && canReach[i - minJump]) {
                reachableCount++;
            }
            if (i - maxJump - 1 >= 0 && canReach[i - maxJump - 1]) {
                reachableCount--;
            }
            if (s.charAt(i) == '0' && reachableCount > 0) {
                canReach[i] = true;
            }
        }
        
        return canReach[n - 1];
    }
}