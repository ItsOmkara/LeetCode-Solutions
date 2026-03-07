class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String doubled = s + s;
        
        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();
        
        for (int i = 0; i < 2 * n; i++) {
            alt1.append(i % 2 == 0 ? '0' : '1');
            alt2.append(i % 2 == 0 ? '1' : '0');
        }
        
      
        int diff1 = 0; 
        int diff2 = 0; 
        
        for (int i = 0; i < n; i++) {
            if (doubled.charAt(i) != alt1.charAt(i)) {
                diff1++;
            }
            if (doubled.charAt(i) != alt2.charAt(i)) {
                diff2++;
            }
        }
        
        int result = Math.min(diff1, diff2);
        
        for (int i = 1; i < n; i++) {
           
            if (doubled.charAt(i - 1) != alt1.charAt(i - 1)) {
                diff1--;
            }
            if (doubled.charAt(i - 1) != alt2.charAt(i - 1)) {
                diff2--;
            }
        
            if (doubled.charAt(i + n - 1) != alt1.charAt(i + n - 1)) {
                diff1++;
            }
            if (doubled.charAt(i + n - 1) != alt2.charAt(i + n - 1)) {
                diff2++;
            }
            
            result = Math.min(result, Math.min(diff1, diff2));
        }
        
        return result;
    }
}