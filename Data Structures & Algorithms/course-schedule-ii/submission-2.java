class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        boolean[] visit = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<numCourses; i++){
            if(!visit[i]){
                if(dfs(adj, i, path, visit, st)){
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

    private boolean dfs(List<List<Integer>> adj, int node, boolean[] path, boolean[] visit,
        Stack<Integer> st){
        
        path[node] = true;
        visit[node] = true;

        for(int nei: adj.get(node)){
            if(!visit[nei]){
                if(dfs(adj, nei, path, visit, st)){
                    return true;
                }
            } else if(path[nei]){
                return true;
            }
        }

        path[node] = false;
        st.push(node);

        return false;
    }
}
