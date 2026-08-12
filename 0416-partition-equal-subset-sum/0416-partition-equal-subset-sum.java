class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;
        if(sum%2!=0) return false;
        int target = sum/2;
        int n = nums.length;
        boolean[] prev = new boolean[target+1];
        prev[0] = true;
        if(nums[0] <= target) prev[nums[0]] = true;
        for(int i =1;i<n;i++){
            boolean[] curr = new boolean[target+1];
            for(int j=0;j<=target;j++){
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