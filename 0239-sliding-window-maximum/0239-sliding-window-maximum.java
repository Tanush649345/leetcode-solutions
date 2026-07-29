class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n==1) return new int[]{nums[0]};
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) dq.pollLast();
            if(!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            dq.offerLast(i);
            if(i >= k-1) ans[i-k+1]=nums[dq.peekFirst()];
        }
        return ans;
    }
}