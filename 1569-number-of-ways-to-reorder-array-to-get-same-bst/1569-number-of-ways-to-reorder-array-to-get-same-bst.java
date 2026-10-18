class Solution {
    private int[][] binomialCoefficients;
    private final int MOD = (int) 1e9 + 7;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        binomialCoefficients = new int[n][n];
        binomialCoefficients[0][0] = 1;

        for (int i = 1; i < n; ++i) {
            binomialCoefficients[i][0] = 1;
            for (int j = 1; j <= i; ++j) {
                binomialCoefficients[i][j] = (binomialCoefficients[i - 1][j] + binomialCoefficients[i - 1][j - 1]) % MOD;
            }
        }

        List<Integer> numbersList = new ArrayList<>();
        for (int num : nums) {
            numbersList.add(num);
        }

        return (dfs(numbersList) - 1 + MOD) % MOD;
    }

    private int dfs(List<Integer> nums) {
        if (nums.size() < 2) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> leftSubtree = new ArrayList<>();
        List<Integer> rightSubtree = new ArrayList<>();

        for (int num : nums) {
            if (num < root) {
                leftSubtree.add(num);
            } else if (num > root) {
                rightSubtree.add(num);
            }
        }

        int leftSize = leftSubtree.size();
        int rightSize = rightSubtree.size();

        int leftWays = dfs(leftSubtree);
        int rightWays = dfs(rightSubtree);

        return (int) ((long) leftWays * rightWays % MOD * binomialCoefficients[leftSize + rightSize][rightSize] % MOD);
    }
}