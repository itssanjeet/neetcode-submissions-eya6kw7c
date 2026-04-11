class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> hm = new HashMap<>();
        for(int n: nums){
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            pq.add(new int[]{entry.getKey(), entry.getValue()});
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int[] res = new int[k];
        int idx = 0;
        while(!pq.isEmpty()){
            res[idx++] = pq.poll()[0];
        }

        return res;
    }
}
