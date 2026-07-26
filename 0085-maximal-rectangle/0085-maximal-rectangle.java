class Solution {
    int largestRectangleArea(int[] nums){
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int nse,pse,curr,maxArea=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                curr = st.peek();st.pop();
                nse = i;
                pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea,(nums[curr]*(nse - pse - 1)));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            curr = st.peek();st.pop();
            nse = n;
            pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea,(nums[curr]*(nse - pse - 1)));
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] psum = new int[m][n];
        for(int i=0;i<n;i++){
            int sum= 0;
            for(int j=0;j<m;j++){
                if(matrix[j][i] == '0') sum = 0;
                else sum += 1;
                psum[j][i] = sum;
            }
        }
        int largerRectangle = 0;
        for(int i=0;i<m;i++){
            largerRectangle = Math.max(largerRectangle,largestRectangleArea(psum[i]));
        }
        return largerRectangle;
    }
}