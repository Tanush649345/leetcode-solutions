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
    int max = 0;
    int finddiameter(TreeNode root){
        if(root == null) return 0;
        int lc = finddiameter(root.left);
        int rc = finddiameter(root.right);
        max = Math.max(max,lc+rc);
        return 1+Math.max(lc,rc);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        finddiameter(root);
        return max;
    }
}