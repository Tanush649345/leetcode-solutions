class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int l = matrix.length;
        int r = matrix[0].length;
        int[] prev = new int[r];
        for(int i=0;i<r;i++) prev[i]=matrix[0][i];
        for(int i=1;i<l;i++){
            int[] curr = new int[r];
            for(int j=0;j<r;j++){
                int s,dr = Integer.MAX_VALUE,dl = Integer.MAX_VALUE;
                s = prev[j];
                if(j > 0) dl = prev[j-1];
                if(j < r-1) dr = prev[j+1];
                curr[j] = matrix[i][j] + Math.min(s,(Math.min(dl,dr)));
            }
            prev = curr;
        }
        int max = Integer.MAX_VALUE;
        for(int i =0;i<r;i++){
            max = Math.min(max,prev[i]);
        }
        return max;
    }
}