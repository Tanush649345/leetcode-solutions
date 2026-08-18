class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0] == 0) prev[i] = i/coins[0];
            else prev[i]=Integer.MAX_VALUE;
        }
        for(int i=1;i<n;i++){
            int[] curr = new int[amount+1];
            for(int j=0;j<=amount;j++){
                int nottake = 0 + prev[j];
                int take = Integer.MAX_VALUE;
                if(j>=coins[i] && curr[j-coins[i]] != Integer.MAX_VALUE) take = 1 + curr[j-coins[i]];
                curr[j] = Math.min(take,nottake);
            }
            prev = curr;
        }
        if(prev[amount] >= Integer.MAX_VALUE) return -1;
        return prev[amount];
    }
}