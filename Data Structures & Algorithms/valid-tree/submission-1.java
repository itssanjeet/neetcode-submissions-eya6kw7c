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

        Set<Integer> visit = new HashSet<>();

        if(!dfs(adjList, 0, visit, -1)){
            return false;
        }

        System.out.println(visit);

        return n == visit.size();
    }

    private boolean dfs(List<List<Integer>> adjList, int node, Set<Integer> visit, int pre){
        if(visit.contains(node)){
            return false;
        }

        visit.add(node);

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
