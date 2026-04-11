class KthLargest {
    int k;
    List<Integer> list;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        list = new ArrayList<>();
        for(int n:nums){
            list.add(n);
        }
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size()-k);
    }
}
