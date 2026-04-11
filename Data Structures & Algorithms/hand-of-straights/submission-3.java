class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0){
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for(int i:hand){
            count.put(i, count.getOrDefault(i, 0) + 1);
        } 

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(count.keySet());

        while(!minHeap.isEmpty()){
            int minVal = minHeap.peek();

            for(int i=minVal; i < minVal + groupSize; i++){
                int currCount = count.getOrDefault(i, 0);
                if(currCount == 0){
                    return false;
                }

                currCount--;
                count.put(i, currCount);
                if(currCount == 0){
                    if(minHeap.peek() != i){
                        return false;
                    }
                    minHeap.poll();
                }
            }
        }        

        return true;
    }
}
