class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            int[] pre = prerequisites[i];
            adjList.get(pre[0]).add(pre[1]);
        }

        boolean[] path = new boolean[numCourses];
        boolean[] visit = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!visit[i]){
                if(isCyclic(adjList, i, visit, path)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isCyclic(List<List<Integer>> adjList, int node, boolean[] visit, boolean[] path){
        path[node] = true;
        visit[node] = true;
        for(int nei:adjList.get(node)){
            if(!visit[nei]){
                if(isCyclic(adjList, nei, visit, path)){
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
