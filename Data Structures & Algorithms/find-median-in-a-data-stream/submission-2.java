class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(minHeap.isEmpty() || num > minHeap.peek()){
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();

        if(Math.abs(maxHeapSize - minHeapSize) > 1){
            if(maxHeapSize > minHeapSize){
                minHeap.offer(maxHeap.poll());
            } else {
                maxHeap.offer(minHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        } else if(maxHeap.size() < minHeap.size()){
            return minHeap.peek();
        } else {
            return (double) (maxHeap.peek() + minHeap.peek())/2;
        }
    }
}
