class Solution {
    public String findValidPair(String s) 
    {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<s.length() - 1;i++){
            char first = s.charAt(i);
            char second = s.charAt(i + 1);
            if(first != second &&
               map.get(first) == Character.getNumericValue(first) &&
               map.get(second) == Character.getNumericValue(second)
            ){
                return "" + first + second;
            }        
        }
        return "";
    }
}