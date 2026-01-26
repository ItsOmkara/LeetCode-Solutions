class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Integer[] b = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            b[i] = arr[i];
        }
        Arrays.sort(b);
        
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 1; i < b.length; i++) {
            int diff = b[i] - b[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
                result.clear();
                result.add(Arrays.asList(b[i - 1], b[i]));
            } else if (diff == minDiff) {
                result.add(Arrays.asList(b[i - 1], b[i]));
            }
        }
        
        return result;
    }
}