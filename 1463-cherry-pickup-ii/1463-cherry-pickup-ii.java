class Solution {
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] prev = new int[c][c];
        for(int i =0;i<c;i++){
            for(int j=0;j<c;j++){
                if(i==j) prev[i][j] = grid[r-1][i];
                else prev[i][j] = grid[r-1][i]+grid[r-1][j];
            }
        }

        for(int k = r-2;k>=0;k--){
            int[][] curr = new int[c][c];
            for(int i =0;i<c;i++){
                for(int j=0;j<c;j++){
                    int max = Integer.MIN_VALUE;
                    for(int di = -1; di<=1;di++){
                        for(int dj = -1;dj<=1;dj++){
                            int value = 0;
                            if(i==j) value = grid[k][j];
                            else value = grid[k][i]+grid[k][j];
                            if(i+di >=0 && i+di < c && j+dj >=0 && j+dj < c) value += prev[i+di][j+dj];
                            else value += Integer.MIN_VALUE;
                            max = Math.max(max,value);
                        }
                    }
                    curr[i][j] = max;
                }
            }
            prev = curr;      
        }
        return prev[0][c-1];
    }
}