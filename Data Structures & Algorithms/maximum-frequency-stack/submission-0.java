class FreqStack {
    
    Map<Integer, Integer> count;
    List<Integer> list;
    public FreqStack() {
        count = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        count.put(val, count.getOrDefault(val, 0) + 1);
        list.add(val);
    }
    
    public int pop() {
        int maxCount = Collections.max(count.values());

        int i = list.size() - 1;
        while(count.get(list.get(i)) != maxCount){
            i--;
        }

        int val = list.remove(i);
        count.put(val, count.get(val) - 1);

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */