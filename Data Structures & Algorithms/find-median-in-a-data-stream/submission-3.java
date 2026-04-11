class MedianFinder {

    List<Double> list;
    
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add((double)num);
    }
    
    public double findMedian() {
        list.sort((a,b) -> a>b?1:-1);
        int size = list.size();
        if(size % 2 == 1){
            return list.get(size/2);
        }

        int half = size/2;

        return (list.get(half-1) + list.get(half))/2;
    }
}
