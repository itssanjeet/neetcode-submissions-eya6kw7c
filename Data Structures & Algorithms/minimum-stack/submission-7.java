class MinStack {

    Stack<Integer> normal_stack;
    Stack<Integer> min_stack;

    public MinStack() {
        normal_stack = new Stack<>();
        min_stack = new Stack<>();
    }
    
    public void push(int val) {
        normal_stack.push(val);
        
        if(min_stack.isEmpty() || min_stack.peek() >= val){
            min_stack.push(val);
        }
    }
    
    public void pop() {
        int val = normal_stack.pop();
        if(!min_stack.isEmpty() && val == min_stack.peek()){
            min_stack.pop();
        }
    }
    
    public int top() {
        return normal_stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}
