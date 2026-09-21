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
    TreeNode buildTree(HashMap<Integer,Integer> inmap,int[] inorder,int instart,int inend,int[] postorder,int postart,int posend){
        if(instart > inend || postart > posend) return null;
        TreeNode root = new TreeNode();
        root.val = postorder[posend];
        int ind = inmap.get(root.val);
        int leftsize = ind - instart;
        root.left = buildTree(inmap,inorder,instart,ind-1,postorder,postart,postart+leftsize-1);
        root.right = buildTree(inmap,inorder,ind+1,inend,postorder,postart+leftsize,posend-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> inmap = new HashMap<>();
        int n =inorder.length;
        for(int i=0;i<n;i++){
            inmap.put(inorder[i],i);
        }
        TreeNode root;
        root = buildTree(inmap,inorder,0,n-1,postorder,0,n-1);
        return root;
    }
}