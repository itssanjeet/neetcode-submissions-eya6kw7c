class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0){
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for(int h:hand){
            count.put(h, count.getOrDefault(h, 0)+1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(count.keySet());

        while(!minHeap.isEmpty()){
            int first = minHeap.peek();

            for(int i=first; i< first+groupSize; i++){
                int currCount = count.getOrDefault(i, 0) - 1;
                if(currCount == -1){
                    return false;
                }
                
                count.put(i, currCount);
                if(currCount == 0){
                    if(i != minHeap.peek()){
                        return false;
                    }
                    minHeap.poll();
                }
            }
        }

        return true;
    }
}
