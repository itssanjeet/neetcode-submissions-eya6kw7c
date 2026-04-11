class LRUCache {
    Map<Integer, Integer> hm;
    Queue<Integer> q;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
        q = new LinkedList<>();
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            q.remove(key);
            q.add(key);
            return hm.get(key);
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            hm.put(key, value);
            q.remove(key);
            q.add(key);
            return;
        }
        
        hm.put(key, value);
        q.add(key);
        if(q.size() > capacity){
            int removedKey = q.poll();
            hm.remove(removedKey);
        }
    }
}
