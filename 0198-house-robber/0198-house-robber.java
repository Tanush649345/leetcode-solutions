class Solution {
    public int rob(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;
        int pick,notpick,curr;
        for(int i = 1;i<nums.length;i++){
            pick = i-2 < 0 ? nums[i] : nums[i] + prev2;
            notpick = 0 + prev;
            curr = Math.max(pick,notpick);
            prev2 = prev;prev = curr;
        }
        return prev;
    }
}