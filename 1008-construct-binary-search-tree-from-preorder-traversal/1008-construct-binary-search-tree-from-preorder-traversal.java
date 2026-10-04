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
    TreeNode create(int[] preorder,int[] i,int bound){
        if(i[0]==preorder.length || preorder[i[0]] > bound) return null;
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = create(preorder,i,root.val);
        root.right = create(preorder,i,bound);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return create(preorder,new int[]{0},Integer.MAX_VALUE);
    }
}