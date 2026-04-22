class Solution {
   public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for (String query : queries) {
            if (canMatchWithTwoEdits(query, dictionary)) {
                result.add(query);
            }
        }
        return result;
    }
    
    private boolean canMatchWithTwoEdits(String query, String[] dictionary) {
        for (String dictWord : dictionary) {
            int differences = 0;
            for (int i = 0; i < query.length(); i++) {
                if (query.charAt(i) != dictWord.charAt(i)) {
                    differences++;
                    if (differences > 2) {
                        break;
                    }
                }
            }
            if (differences <= 2) {
                return true;
            }
        }
        return false;
    }
}