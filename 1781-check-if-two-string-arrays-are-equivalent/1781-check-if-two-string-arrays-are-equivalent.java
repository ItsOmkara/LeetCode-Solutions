class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String word1add = "";
        for(String s:word1) {
			word1add+= s;
		}
        String word2add = "";
        for(String s2:word2) {
			word2add+= s2;
		}
        if(word1add.equals(word2add)){
            return true;
        }
        return false;

    }
}