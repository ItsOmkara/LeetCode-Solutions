class Solution {
    public String majorityFrequencyGroup(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }

        Map<Integer,Integer> freqCount = new HashMap<>();
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            int freq = m.getValue();
            freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
        }
        int max = 0;
        for(Map.Entry<Integer, Integer> m : freqCount.entrySet()){
            max = Math.max(max,m.getValue());
        }
        int currentKey = 0;
        for(Map.Entry<Integer, Integer> m : freqCount.entrySet()){
            if(max == m.getValue()){
                currentKey = m.getKey();
            }
        }
        StringBuilder ans = new StringBuilder();
        for(Map.Entry<Character,Integer> m: map.entrySet()){
            if(m.getValue() == currentKey){
                ans.append(m.getKey());
            }
        }

        return ans.toString();
    }
}