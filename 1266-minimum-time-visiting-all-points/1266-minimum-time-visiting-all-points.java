class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        
    int totalTime = 0;
        
       
        for (int i = 0; i < points.length - 1; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            int x2 = points[i + 1][0];
            int y2 = points[i + 1][1];
            
            
            int d1 = Math.abs(x2 - x1);
            int d2 = Math.abs(y2 - y1);
            
            totalTime += Math.max(d1, d2);
        }
        
        return totalTime;
    }
}