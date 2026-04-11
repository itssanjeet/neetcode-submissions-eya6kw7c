class MedianFinder {

    PriorityQueue<Integer> min_heap;
    PriorityQueue<Integer> max_heap;

    public MedianFinder() {
        min_heap = new PriorityQueue<>();  
        max_heap = new PriorityQueue<>((a,b) -> b-a); 
        /**
        ["MedianFinder", "addNum", "-1", "addNum", "-2", "findMedian", "addNum", "-3", "findMedian", "addNum", "-4", "findMedian", "addNum", "-5", "findMedian"]
        max: -3, -4, -5
        min: -2, -1

        your: [null,null,null,-1.5,null,-3.0,null,-2.5,null,-5.0]
        expected: [null,null,null,-1.5,null,-2.0,null,-2.5,null,-3.0]
        */

    }
    
    public void addNum(int num) {
        System.out.println("min_heap: "+min_heap);
        System.out.println("max_heap: "+max_heap);
        max_heap.offer(num);
        if(max_heap.size() > min_heap.size() 
            || !min_heap.isEmpty() && min_heap.peek() < max_heap.peek()){
            min_heap.offer(max_heap.poll());
        }

        if(min_heap.size() > max_heap.size()){
            max_heap.offer(min_heap.poll());
        }
    }
    
    public double findMedian() {
        System.out.println("findMedian(), min_heap: "+min_heap);
        System.out.println("findMedian(), max_heap: "+max_heap);

        if(min_heap.size() == max_heap.size()){
            return (min_heap.peek() + max_heap.peek())/2.0;
        }
        
        // if(min_heap.size() > max_heap.size()){
        //     return min_heap.peek();
        // }

        return max_heap.peek();
    }
}
