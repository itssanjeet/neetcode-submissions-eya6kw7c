class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            int[] point1 = points[i];
            int x1 = point1[0];
            int y1 = point1[1];
            for(int j=i+1; j<n; j++){
                int[] point2 = points[j];
                int x2 = point2[0];
                int y2 = point2[1];

                int d = Math.abs(x1-x2) + Math.abs(y1-y2);

                adj.get(i).add(new int[]{d, j});
                adj.get(j).add(new int[]{d, i});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0,0});
        boolean[] visit = new boolean[n];
        int res = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int wt = curr[0];
            int node = curr[1];
            if(visit[node]){
                continue;
            }

            visit[node] = true;
            res += wt;

            for(int nbr[]:adj.get(node)){
                int nbrNode = nbr[1];
                int nbrWt = nbr[0];
                if(!visit[nbrNode]){
                    pq.add(new int[]{nbrWt, nbrNode});
                }
            }
        }

        return res;
    }
}
