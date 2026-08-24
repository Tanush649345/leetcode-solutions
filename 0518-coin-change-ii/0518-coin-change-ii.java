class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        for(int i = 0;i<=amount;i++){
            if(i % coins[0] == 0){
                prev[i] = 1;
            }
        }
        for(int ind = 1;ind < n;ind++){
            int[] curr = new int[amount+1];
            for(int target = 0;target<=amount;target++){
                int nottake = prev[target];
                int take = 0;
                if(coins[ind] <=target) take = curr[target-coins[ind]];
                curr[target] = take + nottake;
            }
            prev = curr;
        }
        return prev[amount];
    }
}