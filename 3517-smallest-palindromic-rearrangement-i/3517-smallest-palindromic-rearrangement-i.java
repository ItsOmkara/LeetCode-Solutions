class Solution {
    public String smallestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder left = new StringBuilder();
        String middle = "";

        for(char ch = 'a';ch <= 'z';ch++){
            if(map.containsKey(ch)){
                int freq = map.get(ch);

                for(int i  = 0;i<freq/2;i++){
                    left.append(ch);
                }

                if(freq % 2 == 1){
                    middle = String.valueOf(ch);
                }
            }
        }

        String right = new StringBuilder(left).reverse().toString();
        return left.toString() + middle + right;
    }
}