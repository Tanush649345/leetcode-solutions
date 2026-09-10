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
    int max(TreeNode root){
        if(root == null) return 0;
        int lc = max(root.left);
        int rc = max(root.right);
        return 1 + Math.max(lc,rc);
    }
    public int maxDepth(TreeNode root) {
        return max(root);
    }
}