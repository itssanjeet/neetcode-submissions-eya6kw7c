class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

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
            for(int j=0; j<n; j++){
                if(j == node){
                    continue;
                }
                int[] point1= points[node];
                int x1 = point1[0], y1 = point1[1];
    
                int[] point2 = points[j];
                int x2 = point2[0], y2 = point2[1];

                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);

                pq.add(new int[]{dist, j});
            }
        }

        return res;
    }
}
