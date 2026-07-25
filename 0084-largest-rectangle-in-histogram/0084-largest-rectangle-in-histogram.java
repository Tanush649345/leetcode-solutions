class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n==1) return heights[0];
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int nse,pse,curr;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                curr = st.peek();st.pop();
                pse = st.isEmpty() ? -1 : st.peek();
                nse = i;
                maxArea = Math.max(maxArea,heights[curr] * (nse - pse - 1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            curr = st.peek();st.pop();
            nse = n;
            pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea,heights[curr] * (nse - pse - 1));
        }
        return maxArea;
    }
}