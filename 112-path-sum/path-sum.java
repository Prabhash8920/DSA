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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 1. Base case: If the node is null, there is no path
        if (root == null) return false;

        // 2. Check if we are at a leaf node
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // 3. Recursively check left and right subtrees with the updated target
        int newTarget = targetSum - root.val;
        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
    }
}