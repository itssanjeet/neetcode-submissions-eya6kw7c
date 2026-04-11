class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] ed: edges){
            adjList.get(ed[0]).add(ed[1]);
            adjList.get(ed[1]).add(ed[0]);
        }

        int res = 0;
        boolean[] visit = new boolean[n];
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

        for(int nei:adjList.get(node)){
            if(!visit[nei]){
                dfs(adjList, nei, visit);
            }
        }
    }
}
