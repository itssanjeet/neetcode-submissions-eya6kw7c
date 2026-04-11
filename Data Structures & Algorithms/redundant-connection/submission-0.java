class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] ed:edges){
            int u = ed[0];
            int v = ed[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            boolean[] visited = new boolean[n+1];

            if(isCyclic(adjList, u, visited, -1)){
                return ed;
            }
        }

        return new int[0];
    }

    private boolean isCyclic(List<List<Integer>> adjList, int node, boolean[] visited, int parent){
        if(visited[node]){
            return true;
        }
        
        visited[node] = true;
        for(int nbr:adjList.get(node)){
            if(parent == nbr){
                continue;
            }

            if(isCyclic(adjList, nbr, visited, node)){
                return true;
            }
        }

        return false;
    }
}
