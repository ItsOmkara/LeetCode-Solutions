class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        String t = "1" + s + "1";

        List<Character> ch = new ArrayList<>();
        List<Integer> len = new ArrayList<>();

        int i = 0;
        while (i < t.length()) {
            char c = t.charAt(i);
            int j = i;
            while (j < t.length() && t.charAt(j) == c) j++;

            ch.add(c);
            len.add(j - i);

            i = j;
        }

        int maxGain = 0;

        for (i = 1; i < ch.size() - 1; i++) {
            if (ch.get(i) == '1'
                    && ch.get(i - 1) == '0'
                    && ch.get(i + 1) == '0') {

                maxGain = Math.max(maxGain,
                        len.get(i - 1) + len.get(i + 1));
            }
        }

        return ones + maxGain;
    }
}