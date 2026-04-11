class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for(int n:nums){
            maxHeap.offer(n);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }
}
