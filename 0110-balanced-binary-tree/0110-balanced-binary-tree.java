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
    int findheight(TreeNode root){
        if(root == null) return 0;
        int lc = findheight(root.left);
        int rc = findheight(root.right);
        if(lc == -1 || rc == -1) return -1;
        if(Math.abs(lc-rc) >1) return -1;
        return Math.max(lc,rc)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(findheight(root) == -1) return false;
        else return true;
    }
}