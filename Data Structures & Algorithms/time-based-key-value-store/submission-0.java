class TimeMap {
    Map<String, Map<Integer, String>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hm.putIfAbsent(key, new HashMap<>());
        hm.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)){
            return "";
        }
        
        Map<Integer, String> values = hm.get(key);
        while(timestamp > 0 && !values.containsKey(timestamp)){
            timestamp--;
        }

        return values.getOrDefault(timestamp, "");
    }
}
