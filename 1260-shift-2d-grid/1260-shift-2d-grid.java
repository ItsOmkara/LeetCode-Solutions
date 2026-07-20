class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            result.add(new ArrayList<>());

            for (int j = 0; j < n; j++) {
                result.get(i).add(0);
            }
        }

        int total = m * n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int oldIndex = i * n + j;

                int newIndex = (oldIndex + k) % total;

                int newRow = newIndex / n;
                int newCol = newIndex % n;

                result.get(newRow).set(newCol, grid[i][j]);
            }
        }

        return result;
    }
}