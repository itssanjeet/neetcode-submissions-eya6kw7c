class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            adjList.get(pre[1]).add(pre[0]);
        }

        System.out.println(adjList);
        boolean[] visit = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!visit[i]){
                if(dfs(adjList, i, path, visit)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> adj, int node, boolean[] path, boolean[] visit){
        path[node] = true;
        visit[node] = true;

        for(int nei: adj.get(node)){
            if(!visit[nei]){
                if(dfs(adj, nei, path, visit)){
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
