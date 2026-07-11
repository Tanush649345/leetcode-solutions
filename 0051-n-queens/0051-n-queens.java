class Solution {
    int[] rowcheck;
    int[] lowdiagcheck;
    int[] updiagcheck;
    char[][] board;
    void placequeen(int col,int n,List<List<String>> ans){
        if(col == n){
            List<String> ds = new ArrayList<>();
            for(int i = 0;i<n;i++){
                String sol = "";
                for(int j=0;j<n;j++){
                    sol += board[i][j];
                }
                ds.add(sol);
            }
            ans.add(ds);
            return;
        }
        for(int row =0;row<n;row++){
            if(rowcheck[row]==0 && lowdiagcheck[row+col]==0 &&
            updiagcheck[(n-1)+(col - row)]==0){
            board[row][col] = 'Q';
            rowcheck[row]=1;
            lowdiagcheck[row+col]=1;
            updiagcheck[(n-1)+(col - row)]=1;
            placequeen(col+1,n,ans);
            board[row][col] = '.';
            rowcheck[row]=0;
            lowdiagcheck[row+col]=0;
            updiagcheck[(n-1)+(col - row)]=0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        rowcheck = new int[n];
        lowdiagcheck = new int[2*n -1];
        updiagcheck = new int[2*n -1];
        board =  new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for(int i =0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        placequeen(0,n,ans);
        return ans;
    }
}