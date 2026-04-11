class TimeMap {
    Map<String, List<Pair<Integer, String>>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hm.putIfAbsent(key, new ArrayList<>());
        hm.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)){
            return "";
        }
        
        List<Pair<Integer, String>> values = hm.get(key);
        int l =0, r = values.size() - 1;
        String res = "";
        while(l <= r){
            int m = l + (r-l)/2;
            if(values.get(m).getKey() <= timestamp){
                res = values.get(m).getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }

    class Pair<K, V>{
        private final K key;
        private final V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return this.key;
        }

        public V getValue(){
            return this.value;
        }
    }
}
