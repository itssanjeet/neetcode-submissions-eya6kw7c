class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for(List<String> ticket:tickets){
            String src = ticket.get(0);
            String dst = ticket.get(1);
            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).add(dst);
        }

        Stack<String> st = new Stack<>();
        dfs(adj, "JFK", st);
        List<String> res = new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.pop());
        }

        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> adj, String node, Stack<String> st){

        PriorityQueue<String> queue = adj.getOrDefault(node, new PriorityQueue<>());
        while(!queue.isEmpty()){
            dfs(adj, queue.poll(), st);
        }

        st.push(node);
    }
}
