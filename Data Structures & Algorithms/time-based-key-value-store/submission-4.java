class TimeMap {

    Map<String, List<String[]>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hm.putIfAbsent(key, new ArrayList<>());
        hm.get(key).add(new String[]{value, String.valueOf(timestamp)});
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)){
            return "";
        }

        List<String[]> values = hm.get(key);
        int l = 0, r = values.size() - 1;

        String res = "";
        while(l <=r){
            int m = l + (r-l)/2;
            int ts = Integer.valueOf(values.get(m)[1]);
            if(ts <= timestamp){
                res = values.get(m)[0];
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }
}
