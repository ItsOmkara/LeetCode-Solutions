class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowMask = new HashMap<>();
        
        for (int[] r : reservedSeats) {
            int row = r[0], seat = r[1];
            if (seat < 2 || seat > 9) continue;
            int mask = rowMask.getOrDefault(row, 0);
            mask |= (1 << seat);
            rowMask.put(row, mask);
        }
        
        int leftMask  = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int midMask   = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int rightMask = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9); 
        
        int ans = 0;
        ans += (n - rowMask.size()) * 2;
        
        for (int mask : rowMask.values()) {
            boolean leftFree = (mask & leftMask) == 0;
            boolean rightFree = (mask & rightMask) == 0;
            
            if (leftFree && rightFree) {
                ans += 2;
            } else if (leftFree || rightFree) {
                ans += 1;
            } else if ((mask & midMask) == 0) {
                ans += 1;
            }
        }
        
        return ans;
    }
}