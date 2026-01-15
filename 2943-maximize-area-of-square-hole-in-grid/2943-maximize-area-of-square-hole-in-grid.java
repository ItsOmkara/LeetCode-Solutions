class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        
        int maxHGap = getMaxGap(hBars);
        
        
        int maxVGap = getMaxGap(vBars);
        
        
        int side = Math.min(maxHGap, maxVGap) + 1;
        
        return side * side;
    }
    
    private int getMaxGap(int[] bars) {
        if (bars.length == 0) return 0;
        
        Arrays.sort(bars);
        int maxGap = 1;
        int currentGap = 1;
        
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i-1] + 1) {
                
                currentGap++;
                maxGap = Math.max(maxGap, currentGap);
            } else {
                
                currentGap = 1;
            }
        }
        
        return maxGap;
    }
}
