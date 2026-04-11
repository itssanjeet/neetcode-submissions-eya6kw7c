class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] pair:edges){
            adjList.get(pair[0]).add(pair[1]);
            adjList.get(pair[1]).add(pair[0]);
        }

        boolean[] visit = new boolean[n];
        int res = 0;
        for(int i=0; i<n; i++){
            if(!visit[i]){
                res++;
                dfs(adjList, i, visit);
            }
        }

        return res;
    }

    private void dfs(List<List<Integer>> adjList, int node, boolean[] visit){
        visit[node] = true;
        for(int nbr:adjList.get(node)){
            if(!visit[nbr]){
                dfs(adjList, nbr, visit);
            }
        }
    }
}
