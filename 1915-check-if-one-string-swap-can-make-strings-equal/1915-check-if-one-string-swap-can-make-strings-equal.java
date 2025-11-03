class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        
        
        char[] arr2 = s2.toCharArray();
        
        for (int i = 0; i < arr2.length; i++) {
            for (int j = i + 1; j < arr2.length; j++) {
                
                char temp = arr2[i];
                arr2[i] = arr2[j];
                arr2[j] = temp;
                
                
                if (s1.equals(new String(arr2))) {
                    return true;
                }
                
                temp = arr2[i];
                arr2[i] = arr2[j];
                arr2[j] = temp;
            }
        }
        
        return false;
    }
}