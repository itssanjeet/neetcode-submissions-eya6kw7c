class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b) -> b-a);
        maxHeap = new PriorityQueue<>((a,b) -> a-b);
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        if(minHeap.size() - maxHeap.size() > 1 || !maxHeap.isEmpty() 
            && minHeap.peek() > maxHeap.peek()){
            maxHeap.add(minHeap.poll());
        }

        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        if(minSize == maxSize){
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }

        if(minSize > maxSize){
            return (double) minHeap.peek();
        }

        return (double)maxHeap.peek();
    }
}
