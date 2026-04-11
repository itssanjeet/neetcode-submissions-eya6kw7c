class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int j=0; j<n; j++){
            adj.add(new ArrayList<>());
        }

        for(int[] ed:edges){
            int u = ed[0]-1;
            int v = ed[1]-1;
            adj.get(u).add(v);
            adj.get(v).add(u);

            boolean[] visit = new boolean[n];

            if(dfs(adj, u, -1, visit)){
                return ed;
            }
        }

        return new int[0];
    }

    private boolean dfs(List<List<Integer>> adj, int node, int previous ,boolean[] visit){
        if(visit[node]){
            return true;
        }

        visit[node] = true;
        for(int nei: adj.get(node)){
            if(previous == nei){
                continue;
            }

            if(dfs(adj, nei, node, visit)){
                return true;
            }
        }

        return false;
    }
}
