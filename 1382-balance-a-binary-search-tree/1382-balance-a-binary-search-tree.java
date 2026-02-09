/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedValues = new ArrayList<>();
        inOrderTraversal(root, sortedValues);
        
        return buildBalancedBST(sortedValues, 0, sortedValues.size() - 1);
    }
    
    private void inOrderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) return;
        
        inOrderTraversal(node.left, values);
        values.add(node.val);
        inOrderTraversal(node.right, values);
    }
    
    private TreeNode buildBalancedBST(List<Integer> values, int left, int right) {
        if (left > right) return null;
        
       
        int mid = left + (right - left) / 2;
        
       
        TreeNode root = new TreeNode(values.get(mid));
        
        
        root.left = buildBalancedBST(values, left, mid - 1);
        root.right = buildBalancedBST(values, mid + 1, right);
        
        return root;
    }
}