class Solution {
    public double separateSquares(int[][] squares) {
        List<double[]> events = new ArrayList<>();
        double totalArea = 0;
        
       
        for (int[] square : squares) {
            int yi = square[1];
            int li = square[2];
            double y1 = yi;
            double y2 = yi + li;
            
            events.add(new double[]{y1, li});  
            events.add(new double[]{y2, -li}); 
            
            totalArea += (double) li * li;
        }
        
       
        events.sort((a, b) -> Double.compare(a[0], b[0]));
        
        double targetArea = totalArea / 2.0;
        double currentY = events.get(0)[0];
        double currentArea = 0;
        double currentSlope = 0;
        
        
        if (currentY > 0) {
            
            if (targetArea == 0) return 0;
        }
        
        
        for (int i = 0; i < events.size(); i++) {
            double[] event = events.get(i);
            double nextY = event[0];
            
            
            double segmentWidth = nextY - currentY;
            double areaInSegment = currentSlope * segmentWidth;
        
            if (currentArea + areaInSegment >= targetArea) {

                return currentY + (targetArea - currentArea) / currentSlope;
            }
            
            currentArea += areaInSegment;
            currentY = nextY;
            currentSlope += event[1];
            
            
            while (i + 1 < events.size() && events.get(i + 1)[0] == currentY){
                i++;
                currentSlope += events.get(i)[1];
            }
        }
        
        
        double maxY = 0;
        for (int[] square : squares) {
            maxY = Math.max(maxY, square[1] + square[2]);
        }
        return maxY;
    }
}