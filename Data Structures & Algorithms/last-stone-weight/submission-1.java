class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int n:stones){
            pq.add(n);
        }

        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();

            int z = y-x;
            if(z != 0){
                pq.add(z);
            }
        }

        return pq.size() == 0? 0:pq.peek();
    }
}
