class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int leftMax = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                leftMax = i;
                break;
            }
        }
        int rightMax = 0;
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                rightMax = n - 1 - i;
                break;
            }
        }
        return Math.max(leftMax, rightMax);  
    }
}