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
    TreeNode buildTree(HashMap<Integer,Integer> inmap,int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend){
        if(prestart > preend || instart > inend) return null;
        TreeNode root = new TreeNode();
        root.val = preorder[prestart];
        int ind = inmap.get(root.val);
        int leftsize = ind - instart;
        root.left = buildTree(inmap,preorder,prestart +1,preend+leftsize,inorder,instart,ind-1);
        root.right = buildTree(inmap,preorder,prestart+leftsize+1,preend,inorder,ind+1,inend);
        return root;
        }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inmap = new HashMap<>();
        int n =inorder.length;
        for(int i=0;i<n;i++){
            inmap.put(inorder[i],i);
        }
        TreeNode root = buildTree(inmap,preorder,0,n-1,inorder,0,n-1);
        return root;
    }
}