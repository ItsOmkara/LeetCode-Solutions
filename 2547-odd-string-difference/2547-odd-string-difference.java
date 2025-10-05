class Solution {
    public String oddString(String[] words) {
        int n = words[0].length();

        // Generate difference arrays
        int[][] diffArrays = new int[words.length][n - 1];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < n - 1; j++) {
                diffArrays[i][j] = words[i].charAt(j + 1) - words[i].charAt(j);
            }
        }

        // Compare difference arrays to find the odd one
        for (int i = 0; i < words.length; i++) {
            boolean isOdd = true;
            for (int j = 0; j < words.length; j++) {
                if (i != j && areArraysEqual(diffArrays[i], diffArrays[j])) {
                    isOdd = false;
                    break;
                }
            }
            if (isOdd) return words[i];
        }

        return ""; // Default case
    }

    private boolean areArraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}