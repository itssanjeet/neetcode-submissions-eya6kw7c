class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] pre:prerequisites){
            adjList.get(pre[0]).add(pre[1]);
        }

        boolean[] path = new boolean[numCourses];
        boolean[] visit = new boolean[numCourses];
        
        Queue<Integer> st = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(!visit[i]){
                if(dfs(adjList, i, visit, path, st)){
                    return new int[]{};
                }
            }
        }

        int[] res = new int[numCourses];
        int idx=0;
        while(!st.isEmpty()){
            res[idx++] = st.poll();
        }

        return res;
    }

    private boolean dfs(List<List<Integer>> adjList, int node, boolean[] visit, 
        boolean[] path, Queue<Integer> st){
        path[node] = true;
        visit[node] = true;
        for(int nei:adjList.get(node)){
            if(!visit[nei]){
                if(dfs(adjList, nei, visit, path, st)){
                    return true;
                }
            } else if(path[nei]){
                return true;
            }
        }

        path[node] = false;
        st.add(node);
        return false;
    }
}
