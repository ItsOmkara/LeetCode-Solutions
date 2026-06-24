class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sc = new StringBuilder(s);
        StringBuilder sd = new StringBuilder(t);

        for (int i = 0; i < sd.length(); i++) {
            if (sd.charAt(i) == '#') {
                sd.deleteCharAt(i);
                if (i > 0) {
                    sd.deleteCharAt(i - 1);
                    i -= 2;                 
                } else {
                    i--;                    
                }
            }
        }

        for (int i = 0; i < sc.length(); i++) {
            if (sc.charAt(i) == '#') {
                sc.deleteCharAt(i);
                if (i > 0) {
                    sc.deleteCharAt(i - 1);
                    i -= 2;
                } else {
                    i--;
                }
            }
        }

        return sc.toString().equals(sd.toString());
    }
}