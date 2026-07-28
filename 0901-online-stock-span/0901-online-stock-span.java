class StockSpanner {
    Stack<int[]> st;
    int index;
    public StockSpanner() {
        st = new Stack<>();
        index = -1;
    }
    
    public int next(int price) {
        index += 1;
        while(!st.isEmpty() && st.peek()[0] <= price){
            st.pop();
        }
        int span = st.isEmpty() ? index + 1 : (index - st.peek()[1]);
        st.push(new int[]{price,index});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */