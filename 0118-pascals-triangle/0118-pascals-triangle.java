import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        // Handle the case when numRows is 0
        if (numRows == 0) return triangle;
        
        // First row is always [1]
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        
        // Generate remaining rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            
            // First element is always 1
            currentRow.add(1);
            
            // Calculate middle elements
            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            // Last element is always 1
            currentRow.add(1);
            
            triangle.add(currentRow);
        }
        
        return triangle;
    }
}