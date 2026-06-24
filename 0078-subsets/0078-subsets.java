class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int[] nums, int index,
                        List<Integer> curr,
                        List<List<Integer>> ans) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Include nums[index]
        curr.add(nums[index]);
        helper(nums, index + 1, curr, ans);

        // Exclude nums[index]
        curr.remove(curr.size() - 1);
        helper(nums, index + 1, curr, ans);
    }
}