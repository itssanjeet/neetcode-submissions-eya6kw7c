class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] ed:edges){
            adj.get(ed[0]).add(ed[1]);
            adj.get(ed[1]).add(ed[0]);
        }

        boolean[] visit = new boolean[n];
        int res = 0;
        for(int i=0; i<n; i++){
            if(!visit[i]){
                res++;
                dfs(adj, i, visit);
            }
        }

        return res;
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
