class Solution {
    int Rob(int[] nums,int l,int r){
        int prev = nums[l];
        int prev2 = 0;
        int pick,notpick,curr;
        for(int i =l+1;i<r;i++){
            pick = i - 2 < l ? nums[i] : nums[i] + prev2;
            notpick = 0 + prev;
            curr = Math.max(pick,notpick);
            prev2 = prev;prev = curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(Rob(nums,1,n),Rob(nums,0,n-1));
    }
}