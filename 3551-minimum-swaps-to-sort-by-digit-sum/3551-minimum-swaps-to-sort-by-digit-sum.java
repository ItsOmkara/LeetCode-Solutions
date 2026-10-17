import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = digitSum(nums[i]);
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0])
                                                : Integer.compare(a[1], b[1]));

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][2] == i) continue;

            int j = i, cycleLen = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][2];
                cycleLen++;
            }
            swaps += cycleLen - 1;
        }
        return swaps;
    }

    private int digitSum(int x) {
        int s = 0;
        while (x > 0) {
            s += x % 10;
            x /= 10;
        }
        return s;
    }
}