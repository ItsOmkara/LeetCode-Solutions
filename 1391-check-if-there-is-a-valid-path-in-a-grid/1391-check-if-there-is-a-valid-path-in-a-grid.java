class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {
            {-1, 0, 2},
            {0, 1, 3},   
            {1, 0, 0},  
            {0, -1, 1}   
        };
        
        
        int[][] streetConnections = {
            {},       
            {1, 3},       
            {0, 2},      
            {2, 3},       
            {1, 2},       
            {0, 3},       
            {0, 1}       
        };
        
        // BFS
        boolean[][] visited = new boolean[m][n];
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            
            int currentStreet = grid[x][y];
            int[] connections = streetConnections[currentStreet];
            
            for (int dir : connections) {
                int dx = dirs[dir][0];
                int dy = dirs[dir][1];
                int oppositeDir = dirs[dir][2];
                
                int newX = x + dx;
                int newY = y + dy;
                
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    int neighborStreet = grid[newX][newY];
                    int[] neighborConnections = streetConnections[neighborStreet];
                    
                    boolean hasConnection = false;
                    for (int neighborDir : neighborConnections) {
                        if (neighborDir == oppositeDir) {
                            hasConnection = true;
                            break;
                        }
                    }
                    
                    if (hasConnection) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        
        return false;
    }
}