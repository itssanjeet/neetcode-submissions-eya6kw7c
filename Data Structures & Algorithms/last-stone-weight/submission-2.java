class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int s:stones){
            pq.add(s);
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
