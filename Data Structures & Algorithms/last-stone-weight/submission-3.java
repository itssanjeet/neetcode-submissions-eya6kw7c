class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int stone: stones){
            pq.add(stone);
        }

        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();

            int z = Math.abs(y-x);
            if(z > 0){
                pq.add(z);
            }
        }
        
        return pq.size() > 0? pq.peek():0;
    }
}
