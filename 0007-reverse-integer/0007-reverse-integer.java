class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        String numStr = String.valueOf(Math.abs((long)x)); 
        StringBuilder reversedBuilder = new StringBuilder(numStr);
        String reversedStr = reversedBuilder.reverse().toString();
        int i = 0;
        while (i < reversedStr.length() && reversedStr.charAt(i) == '0') {
            i++;
        }
        String cleanedStr = (i == reversedStr.length()) ? "0" : reversedStr.substring(i);
        String resultStr = isNegative ? "-" + cleanedStr : cleanedStr;
        try {
            long resultLong = Long.parseLong(resultStr);
            if (resultLong > Integer.MAX_VALUE || resultLong < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) resultLong;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}