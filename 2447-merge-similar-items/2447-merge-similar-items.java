class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        
        for (int i = 0; i < items1.length; i++) {
            int key = items1[i][0];
            int value = items1[i][1];
            map.put(key, map.getOrDefault(key, 0) + value);
        }
        
        
        for (int i = 0; i < items2.length; i++) {
            int key = items2[i][0];
            int value = items2[i][1];
            map.put(key, map.getOrDefault(key, 0) + value);
        }
        
       
        List<List<Integer>> result = new ArrayList<>();
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> pair = new ArrayList<>();
            pair.add(entry.getKey());
            pair.add(entry.getValue());
            result.add(pair);
        }
        
        return result;
    }
}