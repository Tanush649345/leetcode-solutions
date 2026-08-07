class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int l = obstacleGrid.length-1;
        int r = obstacleGrid[0].length-1;
        int[] prev = new int[r+1];
        for(int i =0;i <= l;i++){
            int[] curr = new int[r+1];
            for(int j=0;j<=r;j++){
                if(obstacleGrid[i][j] == 1) curr[j] = 0;
                else if(i==0&&j==0) curr[j] = 1;
                else{
                int right =0,down =0;
                if(i>0) right = prev[j];
                if(j>0) down = curr[j-1];
                curr[j] = right+down;
                }
            }
            prev = curr;
        }
        return prev[r];
    }
}