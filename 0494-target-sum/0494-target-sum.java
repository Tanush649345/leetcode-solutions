class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        int offset = sum;
        int[] prev = new int[2 * sum + 1];
        prev[offset] = 1;
        for (int i = 0; i < n; i++) {
            int[] curr = new int[2 * sum + 1];
            for (int t = -sum; t <= sum; t++) {
                int ways = prev[t + offset];
                if (ways == 0) {
                    continue;
                }
                curr[t + nums[i] + offset] += ways;
                curr[t - nums[i] + offset] += ways;
            }
            prev = curr;
        }
        return prev[target + offset];
    }
}