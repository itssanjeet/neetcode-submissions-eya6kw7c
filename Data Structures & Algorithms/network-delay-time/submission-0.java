class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] time:times){
            adjList.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{k,0});
        int[] visited = new int[n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[k] = 0;
        visited[0] = 0;

        // int res = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int wt = curr[1];

            for(int[] nbrNode:adjList.get(node)){
                int nbr = nbrNode[0];
                int nbrWt = nbrNode[1];
                if(wt + nbrWt < visited[nbr]){
                    // res += nbrWt;
                    visited[nbr] = wt + nbrWt;
                    pq.add(new int[]{nbr, wt + nbrWt});
                }
            }
        }

        int res = Arrays.stream(visited).max().getAsInt();
        return res >= Integer.MAX_VALUE? -1:res;
    }
}
