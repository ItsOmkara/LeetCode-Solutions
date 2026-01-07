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
    private static final int MOD = 1000000007;
    private long maxProduct = 0;
    private long totalSum = 0;
    
    public int maxProduct(TreeNode root) {
       
        totalSum = getSum(root);
        
        
        maxProduct = 0;
        findBestSplit(root);
        
        return (int)(maxProduct % MOD);
    }
    
    private long getSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getSum(node.left) + getSum(node.right);
    }
    
    private long findBestSplit(TreeNode node) {
        if (node == null) return 0;
        
        
        long leftSum = findBestSplit(node.left);
        long rightSum = findBestSplit(node.right);
        long subtreeSum = leftSum + rightSum + node.val;
        
        
        long product = subtreeSum * (totalSum - subtreeSum);
        
        
        if (product > maxProduct) {
            maxProduct = product;
        }
        
        return subtreeSum;
    }
}