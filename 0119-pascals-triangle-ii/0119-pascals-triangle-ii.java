class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for(int i=0;i<rowIndex;i++){
            int last = row.get(row.size() - 1);
            
            for (int j = row.size() - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(last); 
        }
        return row;
    }
}