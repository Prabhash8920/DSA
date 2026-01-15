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
    public boolean isSameTree(TreeNode p, TreeNode q) {
       // Case 1: both are null
        if (p == null && q == null) return true;

        // Case 2: one is null
        if (p == null || q == null) return false;

        // Case 3: values differ
        if (p.val != q.val) return false;

        // Case 4: check left and right recursively
        return isSameTree(p.left, q.left) 
            && isSameTree(p.right, q.right);
    }


public TreeNode invertTree(TreeNode root) {
         // Base case
        if (root == null) return null;

        // Swap left and right
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recurse on children
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        root.left = invertTree(root.left);
        return isSameTree(root.left,root.right);
    }
    
}
