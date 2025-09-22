class Solution {
    public String oddString(String[] words) {
       
        String first = diff(words[0]);
        String second = diff(words[1]);
        String third = diff(words[2]);

        String common;
        if (first.equals(second) || first.equals(third)) {
            common = first;
        } else {
            common = second;
        }

        
        for (String w : words) {
            if (!diff(w).equals(common)) {
                return w;
            }
        }
        return "";
    }

    private String diff(String s) {
        String ans = "";
        for (int i = 0; i < s.length() - 1; i++) {
            ans += (s.charAt(i+1) - s.charAt(i)) + ",";
        }
        return ans;
    }
}