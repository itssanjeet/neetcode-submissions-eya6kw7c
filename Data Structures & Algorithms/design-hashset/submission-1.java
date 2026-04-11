class MyHashSet {

    int M;
    List<List<Integer>> list;

    public MyHashSet() {
        M = 15000;
        list = new ArrayList<>(M);
        for(int i=0; i<M; i++){
            list.add(new ArrayList<>());
        }
    }
    
    public void add(int key) {
        int idx = findIndex(key);

        int idx2 = list.get(idx).indexOf(key);

        if(idx2 == -1){
            list.get(idx).add(key);
        }
    }
    
    public void remove(int key) {
        int idx = findIndex(key);

        List<Integer> list2 = list.get(idx);

        int idx2 = list2.indexOf(key);
        if(idx2 != -1){
            list2.remove(idx2);
        }

        list.add(list2);
    }
    
    public boolean contains(int key) {
        int idx = findIndex(key);

        List<Integer> list2 = list.get(idx);

        return list2.contains(key);
    }

    int findIndex(int key){
        return key % M;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */