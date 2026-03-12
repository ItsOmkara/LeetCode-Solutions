class Solution {
    public String reversePrefix(String s, int k) {
    if (k <= 1) return s;
    if (k > s.length()) k = s.length(); 

    char[] arr = s.toCharArray();
    int start = 0;
    int end = k - 1;

    while (start < end) {
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }

    return new String(arr);
    }
}