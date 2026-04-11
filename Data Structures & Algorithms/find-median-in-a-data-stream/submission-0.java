class MedianFinder {

    List<Integer> list;

    public MedianFinder() {
        this.list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        Collections.sort(list);
        int size = list.size();
        if(size % 2 == 0){
            int mid = size/2;
            double res = (double)(list.get(mid-1) + list.get(mid))/2;
            return res;
        } else {
            return list.get(size/2);
        }
    }
}
