class MinStack {
    List<Integer> list;

    public MinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
    }
    
    public void pop() {
        list.remove(list.size()-1);
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        int min = list.stream().min((a,b) -> Integer.compare(a,b)).get();
        return min;
    }
}
