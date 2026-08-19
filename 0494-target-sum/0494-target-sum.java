class Solution {
    public int findTargetSumWays(int[] nums, int target){
        int total = 0;
        int n = nums.length;
        for(int i : nums){
            total += i;
        }
        if((total+target)%2!=0) return 0;
        if(Math.abs(target) > total) return 0;
        target = (total+target)/2;
        int[] prev = new int[target+1];
        prev[0] = 1;
        if(nums[0] <= target) prev[nums[0]]+= 1;
        for(int ind =1;ind<n;ind++){
            int[] curr = new int[target+1];
            for(int targ = 0;targ<=target;targ++){
                int take = 0;
                if(nums[ind]<=targ) take = prev[targ-nums[ind]];
                int nottake = prev[targ];
                curr[targ] = take+nottake;
            }
            prev = curr;
        }
        return prev[target];
    }
}