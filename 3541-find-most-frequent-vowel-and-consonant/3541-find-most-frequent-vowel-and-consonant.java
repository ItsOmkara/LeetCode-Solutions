class Solution {
    public int maxFreqSum(String s) {
        StringBuilder sc = new StringBuilder(s);
        Map<Character,Integer> m1 = new HashMap<>();
        Map<Character,Integer> m2 = new HashMap<>();
        int count = s.length();
        for(int i = 0;i<s.length();i++){
            if(sc.charAt(i) == 'a' || sc.charAt(i) == 'o' ||
               sc.charAt(i) == 'e' || sc.charAt(i) == 'i' ||
               sc.charAt(i) == 'u')
            {
                m1.put(sc.charAt(i),m1.getOrDefault(sc.charAt(i),0) + 1);
            }
            else{
                m2.put(sc.charAt(i),m2.getOrDefault(sc.charAt(i),0) + 1);
            }      
        }
        int maxV = 0;
        for(Map.Entry<Character,Integer>m:m1.entrySet()){
            maxV = Math.max(maxV,m.getValue());
        }
        int maxC = 0;
        for(Map.Entry<Character,Integer>m:m2.entrySet()){
            maxC = Math.max(maxC,m.getValue());
        }

        return maxV + maxC;        
    }
}