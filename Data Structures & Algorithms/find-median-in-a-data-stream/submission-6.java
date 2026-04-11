class MedianFinder {
    PriorityQueue<Integer> minHeap;// = new PriorityQueue<>((a,b) -> b-a);
    PriorityQueue<Integer> maxHeap;// = new PriorityQueue<>((a,b) -> a-b);

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b) -> b-a);
        maxHeap = new PriorityQueue<>((a,b) -> a-b);
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        if(minHeap.size() > maxHeap.size() || 
            !maxHeap.isEmpty() && maxHeap.peek() < minHeap.peek()){
            maxHeap.add(minHeap.poll());
        }

        if(maxHeap.size() > minHeap.size()){
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        int minHeapSize = minHeap.size();
        int maxHeapSize = maxHeap.size();
        if(minHeapSize > maxHeapSize){
            return minHeap.peek();
        } else if(minHeapSize < maxHeapSize){
            return maxHeap.peek();
        }

        return (minHeap.peek() + maxHeap.peek()) / 2.0;
         
    }
}
