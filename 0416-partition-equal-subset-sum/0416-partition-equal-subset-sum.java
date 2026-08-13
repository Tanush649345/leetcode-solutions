class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 0) return false;
        int sum = 0;
        for(int i : nums) sum += i;
        if(sum%2!=0) return false;
        int target = sum/2;
        int n = nums.length;
        boolean[] prev = new boolean[target+1];
        prev[0] = true;
        for(int i =0;i<n;i++){
            boolean[] curr = new boolean[target+1];
            curr[0] = true;
            for(int j=1;j<=target;j++){
                boolean notpick = prev[j];
                boolean pick = false;
                if(nums[i] <= j) pick = prev[j - nums[i]];
                curr[j] = notpick || pick;
            }
            prev = curr;
        }
        return prev[target];
    }
}