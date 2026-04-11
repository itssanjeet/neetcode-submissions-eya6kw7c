class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] ed:edges){
            adj.get(ed[0]).add(ed[1]);
            adj.get(ed[1]).add(ed[0]);
        }

        boolean[] visit = new boolean[n];
        boolean[] path = new boolean[n];
        if(dfs(adj, 0, -1, visit, path))
            return false;

        for(boolean b:visit){
            if(!b){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> adj, int node, int previous, boolean[] visit
        , boolean[] path){
        visit[node] = true;
        path[node] = true;

        for(int nei:adj.get(node)){
            if(previous == nei){
                continue;
            }

            if(!visit[nei]){
                if(dfs(adj, nei, node, visit, path)){
                    return true;
                }
            } else if(path[nei]){
                return true;
            }
        }

        path[node] = false;

        return false;
    }
}
