class Solution {
    public int totalNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int d : digits) cnt[d]++;
        
        int result = 0;
        
        for (int d1 = 1; d1 <= 9; d1++) {
            for (int d2 = 0; d2 <= 9; d2++) {
                for (int d3 = 0; d3 <= 8; d3 += 2) {
                    if (canForm(cnt, d1, d2, d3)) {
                        result++;
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean canForm(int[] cnt, int d1, int d2, int d3) {
        int[] need = new int[10];
        need[d1]++;
        need[d2]++;
        need[d3]++;
        
        for (int i = 0; i < 10; i++) {
            if (need[i] > cnt[i]) return false;
        }
        return true;
    }
}