class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            int[] pointI = points[i];
            int x1 = pointI[0];
            int y1 = pointI[1];
            for(int j = i+1; j<n; j++){
                int[] pointJ = points[j];

                int x2 = pointJ[0];
                int y2 = pointJ[1];
                int d = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                adj.get(i).add(new int[]{j, d});
                adj.get(j).add(new int[]{i, d});
            }
        }

        PriorityQueue<int[]> min_heap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        min_heap.offer(new int[]{0,0});
        
        boolean[] visited = new boolean[n];
        int res = 0;
        while(!min_heap.isEmpty()){
            int[] crr = min_heap.poll();
            int node = crr[0];
            int d = crr[1];

            if(visited[node]){
                continue;
            }

            visited[node] = true;
            res += d;

            for(int[] nbr: adj.get(node)){
                int nei = nbr[0];
                int nd = nbr[1];

                min_heap.offer(new int[]{nei, nd});
            }
        }

        return res;
    }
}
