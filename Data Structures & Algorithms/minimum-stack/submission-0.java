class MinStack {
    Stack<int []> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()) {
            st.push(new int[]{val, val});
            return;
        }
        int newMin = Math.min(st.peek()[1], val);
        st.push(new int[]{val, newMin});
    }
    
    public void pop() {
        if(!st.isEmpty()) st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}
