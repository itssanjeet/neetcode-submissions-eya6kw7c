class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] pair:edges){
            adjList.get(pair[0]).add(pair[1]);
            adjList.get(pair[1]).add(pair[0]);
        }

        boolean[] visit = new boolean[n];

        if(!dfs(adjList, 0, visit, -1)){
            return false;
        }

        System.out.println(Arrays.toString(visit));
        for(boolean b:visit){
            if(!b){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> adjList, int node, boolean[] visit, int pre){
        if(visit[node]){
            return false;
        }

        visit[node] = true;

        for(int nei: adjList.get(node)){
            if(nei == pre){
                continue;
            }

            if(!dfs(adjList, nei, visit, node)){
                return false;
            }
        }

        return true;
    }
}
