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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        helper(root, targetSum, currentPath, result);
        return result;
    }

    private void helper(TreeNode node, int target, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return;

        // 1. Add current node to the path
        currentPath.add(node.val);

        // 2. Check if it's a leaf and the sum matches
        if (node.left == null && node.right == null && target == node.val) {
            // We must create a NEW list because currentPath keeps changing
            result.add(new ArrayList<>(currentPath));
        } else {
            // 3. Continue exploring left and right
            helper(node.left, target - node.val, currentPath, result);
            helper(node.right, target - node.val, currentPath, result);
        }

        // 4. BACKTRACK: Remove the current node before returning to the caller
        currentPath.remove(currentPath.size() - 1);
    }
}