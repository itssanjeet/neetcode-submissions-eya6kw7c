class MinStack {
    Stack<Integer> st;
    Stack<Integer> min_stack;

    public MinStack() {
        st = new Stack<>();
        min_stack = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);

        if(min_stack.isEmpty() || min_stack.peek() >= val){
            min_stack.push(val);
        }
    }
    
    public void pop() {
        // if(st.isEmpty()){
        //     return;
        // }

        int val = st.pop();
        
        if(!min_stack.isEmpty() && min_stack.peek() == val){
            min_stack.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}
