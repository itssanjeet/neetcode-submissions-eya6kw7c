class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0 || prerequisites[0].length == 0){
            return true;
        }

        int ROWS = prerequisites.length, COLS = prerequisites[0].length;

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
            if(!visit[i] && dfs(adjList, i, visit, path, st)){
                return false;
            }
        }

        // System.out.println(st);
        for(boolean b:visit){
            if(!b){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> adjList, int node, boolean[] visit, boolean[] path, Stack<Integer> st){
        path[node] = true;
        visit[node] = true;
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
        st.add(node);

        return false;
    }
}
