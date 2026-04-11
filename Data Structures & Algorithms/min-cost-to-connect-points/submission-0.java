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
            for(int j=i+1; j<n; j++){
                int[] pointJ = points[j];
                int x2 = pointJ[0];
                int y2 = pointJ[1];
                int d = Math.abs(x1-x2) + Math.abs(y1-y2);

                adj.get(i).add(new int[]{j, d});
                adj.get(j).add(new int[]{i, d});

            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0,0});
        Set<Integer> visited = new HashSet<>();

        int res = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];

            if(visited.contains(node)){
                continue;
            }
            visited.add(node);

            res += d;
            for(int[] nbrNode:adj.get(node)){
                int nbrD = nbrNode[1];
                int nbr = nbrNode[0];
                
                pq.add(new int[]{nbrD, nbr});
            }
        }

        return res;
    }
}
