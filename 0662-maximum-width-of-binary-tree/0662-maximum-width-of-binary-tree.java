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
    static class pair{
        TreeNode root;
        int ind;
        public pair(TreeNode root,int ind){
            this.root = root;
            this.ind = ind;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root.left == null && root.right == null) return 1;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(root,0));
        int width = 1;
        while(!q.isEmpty()){
            int min = q.peek().ind;
            int size = q.size();
            int first=0,last=0;
            for(int i=0;i<size;i++){
                if(i==0) first = q.peek().ind - min;
                if(i== size -1) last = q.peek().ind - min;
                if(q.peek().root.left != null) q.offer(new pair(q.peek().root.left,2*(q.peek().ind-min)+1));
                if(q.peek().root.right != null) q.offer(new pair(q.peek().root.right,2*(q.peek().ind-min)+2));
                q.poll();
            }
            width = Math.max(width,last-first + 1);
        }
        return width;
    }
}