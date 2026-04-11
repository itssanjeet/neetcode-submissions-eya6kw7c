class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;


        for(int i=n-1; i>= 0; i--){
            List<List<Integer>> adj = new ArrayList<>();
            for(int j=0; j<n; j++){
                adj.add(new ArrayList<>());
            }

            for(int j=n-1; j>= 0; j--){
                if(i == j){
                    continue;
                }
                int[] ed = edges[j];
                int u = ed[0] - 1;
                int v = ed[1] - 1;

                adj.get(u).add(v);
                adj.get(v).add(u);
            }
                
            System.out.println(adj);

            boolean[] visit = new boolean[n];
            dfs(adj, 0, visit);
            
            boolean allVisit = true;
            for(boolean b:visit){
                if(!b){
                    allVisit = false;
                }
            }

            if(allVisit){
                return edges[i];
            }
        }

        return new int[0];
    }

    private void dfs(List<List<Integer>> adj, int node, boolean[] visit){
        visit[node] = true;

        for(int nei: adj.get(node)){
            if(!visit[nei]){
                dfs(adj, nei, visit);
            }
        }
    }
}
