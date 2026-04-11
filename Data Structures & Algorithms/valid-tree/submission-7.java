class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] pair:edges){
            adjList.get(pair[0]).add(pair[1]);
            adjList.get(pair[1]).add(pair[0]);
        }

        boolean[] path = new boolean[n];
        boolean[] visit = new boolean[n];
        
        // for(int i=0; i<n; i++){
        //     if(!visit[i]){
        //         if(dfs(adjList, i, visit, path, -1)){
        //             return false;
        //         }
        //     }
        // }

        if(dfs(adjList, 0, visit, path, -1))
            return false;

        for(boolean b:visit){
            if(!b){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> adjList, int node, boolean[] visit, boolean[] path, int parent){
        visit[node] = true;
        path[node] = true;
        for(int nbr:adjList.get(node)){
            if(!visit[nbr]){
                if(dfs(adjList, nbr, visit, path, node)){
                    return true;
                }
            } else if(path[nbr] && nbr != parent){
                return true;
            }
        }

        path[node] = false;

        return false;
    }
}
