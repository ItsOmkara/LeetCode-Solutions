class Solution {
    public String countAndSay(int n) {
        String result = "1";

        for (int i = 2; i <= n; i++) {

            StringBuilder curr = new StringBuilder();
            int count = 1;

            for (int j = 1; j < result.length(); j++) {

                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    curr.append(count);
                    curr.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            curr.append(count);
            curr.append(result.charAt(result.length() - 1));

            result = curr.toString();
        }

        return result;
    }
}