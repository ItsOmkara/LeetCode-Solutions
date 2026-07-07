class Solution {
    public long sumAndMultiply(int n) {
        int[] digits = Integer.toString(n)
                              .chars()
                              .map(c -> c - '0')
                              .toArray();

        long x = 0;
        long sum = 0;

        for (int digit : digits) {
            if (digit != 0) {
                x = x * 10 + digit;
                sum += digit;
            }
        }

        return x * sum;
    }
}