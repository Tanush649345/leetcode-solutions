class Solution {
    public int minPathSum(int[][] grid) {
        int l = grid.length;
        int r = grid[0].length;
        int[] prev = new int[r];
        for(int i =0;i<l;i++){
            int[] curr = new int[r];
            for(int j=0;j<r;j++){
                if(i==0 && j==0) curr[j] = grid[i][j];
                else{
                    int left = Integer.MAX_VALUE,up = Integer.MAX_VALUE;;
                    if(i>0) up = prev[j];
                    if(j>0) left = curr[j-1];
                    curr[j] = grid[i][j] + Math.min(up,left);
                }
            }
            prev = curr;
        }
        return prev[r-1];
    }
}