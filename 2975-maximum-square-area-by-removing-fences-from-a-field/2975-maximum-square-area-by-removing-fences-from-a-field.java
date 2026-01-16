import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final int MOD = 1_000_000_007;
        
        List<Integer> hPoints = new ArrayList<>();
        hPoints.add(1);
        hPoints.add(m);
        for (int fence : hFences) {
            hPoints.add(fence);
        }
        
        List<Integer> vPoints = new ArrayList<>();
        vPoints.add(1);
        vPoints.add(n);
        for (int fence : vFences) {
            vPoints.add(fence);
        }
        
        
        Set<Integer> hDistances = new HashSet<>();
        for (int i = 0; i < hPoints.size(); i++) {
            for (int j = i + 1; j < hPoints.size(); j++) {
                hDistances.add(Math.abs(hPoints.get(j) - hPoints.get(i)));
            }
        }
        
        
        Set<Integer> vDistances = new HashSet<>();
        for (int i = 0; i < vPoints.size(); i++) {
            for (int j = i + 1; j < vPoints.size(); j++) {
                vDistances.add(Math.abs(vPoints.get(j) - vPoints.get(i)));
            }
        }
               
        long maxSide = -1;
        for (int dist : hDistances) {
            if (vDistances.contains(dist)) {
                maxSide = Math.max(maxSide, dist);
            }
        }
        
        if (maxSide == -1) {
            return -1;
        }
        
        long area  = (maxSide * maxSide) % MOD;
        return (int) area;
    }
}