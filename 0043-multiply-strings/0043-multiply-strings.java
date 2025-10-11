class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        int[] ans = new int[m + n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = ans[i + j + 1] + mul;
                ans[i + j + 1] = sum % 10;
                ans[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < ans.length && ans[i] == 0) i++; // skip leading zero
        for (; i < ans.length; i++) sb.append(ans[i]);
        return sb.toString();
    }
}
