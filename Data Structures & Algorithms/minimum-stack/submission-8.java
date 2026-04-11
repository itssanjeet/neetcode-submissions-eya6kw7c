class MinStack {

    Stack<Integer> normal;
    Stack<Integer> minStack;
    public MinStack() {
        normal = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        normal.push(val);
        if(minStack.isEmpty() || val < minStack.peek()){
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        normal.pop();
        minStack.pop();
    }
    
    public int top() {
        return normal.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
