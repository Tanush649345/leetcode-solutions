class Solution {
    int[] findpse(int[] nums){
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
    int[] findnse(int[] nums){
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        if(n == 0) return 0;
        long total = 0;
        int mod = 1000000007;
        int[] pse = findpse(arr);
        int[] nse = findnse(arr);
        for(int i=0;i<n;i++){
            long left = i - pse[i];
            long right = nse[i] - i;
            total = (total + (left * right *arr[i])%mod)%mod;
        }
        return (int)total;
    }
}