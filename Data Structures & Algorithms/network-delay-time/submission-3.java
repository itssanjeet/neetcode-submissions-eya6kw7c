class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time: times){
            int u = time[0] - 1;
            int v = time[1] - 1;
            int t = time[2];

            adj.get(u).add(new int[]{v, t});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{k-1, 0});

        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[k-1] = 0;

        while(!pq.isEmpty()){
            int[] crr = pq.poll();
            int u = crr[0];
            int t = crr[1];

            for(int[] nbr: adj.get(u)){
                int v = nbr[0];
                int tv = nbr[1];

                if(res[v] > t + tv){
                    res[v] = t + tv;
                    pq.add(new int[]{v, t+ tv});
                }
            }
        }

        int max = Arrays.stream(res).max().getAsInt();

        return max == Integer.MAX_VALUE? -1: max;
    }
}
