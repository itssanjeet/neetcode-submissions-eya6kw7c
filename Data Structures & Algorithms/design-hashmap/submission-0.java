class MyHashMap {

    int m;
    List<List<int[]>> list;

    public MyHashMap() {
        this.m = 15000;
        list = new ArrayList<>();
        for(int i=0; i<this.m; i++){
            list.add(new ArrayList<>());
        }
    }
    
    public void put(int key, int value) {
        int idx = findIndex(key);

        List<int[]> list2 = list.get(idx);
        boolean foundKey = false;
        for(int[] li: list2){
            if(li[0] == key){
                foundKey = true;
                li[1] = value;
                break;
            }
        }

        if(!foundKey){
            list2.add(new int[]{key, value});
        }
    }
    
    public int get(int key) {
        int idx = findIndex(key);

        List<int[]> list2 = list.get(idx);
        for(int[] li: list2){
            if(li[0] == key){
                return li[1];
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        int idx = findIndex(key);

        List<int[]> list2 = list.get(idx);
        for(int i=0; i<list2.size(); i++){
            if(list2.get(i)[0] == key){
                list2.remove(i);
                break;
            }
        }
    }

    int findIndex(int key){
        return key % this.m;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */