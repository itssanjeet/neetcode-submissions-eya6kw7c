class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] pair:prerequisites){
            adjList.get(pair[1]).add(pair[0]);
        }

        boolean[] visit = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<numCourses; i++){
            if(!visit[i]){
                if(dfs(adjList, i, visit, path, st)){
                    return new int[0];
                }
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;
        while(!st.isEmpty()){
            res[idx++] = st.pop();
        }

        return res;
    }

    private boolean dfs(List<List<Integer>> adjList, int node, boolean[] visit, boolean[] path, Stack<Integer> st){
        visit[node] = true;
        path[node] = true;
        for(int nbr:adjList.get(node)){
            if(!visit[nbr]){
                if(dfs(adjList, nbr, visit, path, st)){
                    return true;
                }
            } else if(path[nbr]){
                return true;
            }
        }

        path[node] = false;
        st.push(node);
        return false;
    }
}
