class MyHashSet {
    
    int size;
    List<List<Integer>> list;

    public MyHashSet() {
        this.size = 100000;
        list = new ArrayList<>(this.size);

        for(int i=0; i<this.size; i++){
            list.add(new ArrayList<>());
        }
    }
    
    public void add(int key) {
        int idx = getIndex(key);
        int elementIdx = list.get(idx).indexOf(key);

        if(elementIdx == -1){
            list.get(idx).add(key);
        }
    }
    
    public void remove(int key) {
        int idx = getIndex(key);
        int elementIdx = list.get(idx).indexOf(key);

        if(elementIdx != -1){
            list.get(idx).remove(elementIdx);
        }
    }
    
    public boolean contains(int key) {
        int hashCode = getIndex(key);
        return list.get(hashCode).contains(key);
    }

    private int getIndex(int key){
        return key % this.size;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */