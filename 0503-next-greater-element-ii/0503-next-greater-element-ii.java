class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        if(n==0) return new int[n];
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int j = 2*n-1;j>=0;j--){
            int i = j % n;
            while(!st.empty() && st.peek() <= nums[i]) st.pop();
            if(j<n){
                if(st.empty()){
                    nge[i] = -1;
                }
                else nge[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return nge;
    }
}