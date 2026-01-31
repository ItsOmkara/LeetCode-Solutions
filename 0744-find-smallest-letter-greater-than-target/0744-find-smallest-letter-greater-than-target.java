class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int firstGreater = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                firstGreater = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return firstGreater != -1 ? letters[firstGreater] : letters[0];
    }
}
