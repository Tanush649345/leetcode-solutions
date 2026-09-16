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
        int col,row;
        public pair(TreeNode root,int col,int row){
            this.root = root;
            this.col = col;
            this.row = row;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(root,0,0));
        while(!q.isEmpty()){
            TreeNode curr = q.peek().root;
            int col = q.peek().col;
            int row = q.peek().row;
            if(!map.containsKey(col)) map.put(col,new TreeMap<>());
            if(!map.get(col).containsKey(row)) map.get(col).put(row,new PriorityQueue<Integer>());
            map.get(col).get(row).offer(curr.val);
            if(curr.left!=null) q.offer(new pair(curr.left,col-1,row+1));
            if(curr.right!=null) q.offer(new pair(curr.right,col+1,row+1));
            q.poll();
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> rows: map.values()){
            List<Integer> col = new ArrayList<>();
            for(PriorityQueue<Integer> row : rows.values()){
                while(!row.isEmpty()){
                    col.add(row.poll());
                }
            }
            ans.add(col);
        }
        return ans;
    }
}