class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for(List<String> ticket: tickets){
            String src = ticket.get(0);
            String dst = ticket.get(1);
            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).offer(dst);
        }

        System.out.println(adj);

        List<String> res = new ArrayList<>();

        Stack<String> st = new Stack<>();
        st.push("JFK");
        while(!st.isEmpty()){
            String src = st.peek();
            if(!adj.containsKey(src) || adj.get(src).isEmpty()){
                res.add(st.pop());
            } else {
                st.push(adj.get(src).poll());
            }
        }

        // dfs(adj, "JFK", res);

        Collections.reverse(res);

        return res;
    }

    // private void dfs(Map<String, PriorityQueue<String>> adj, String node, List<String> res){
    //     PriorityQueue<String> queue = adj.get(node);
        
    //     while(queue != null && !queue.isEmpty()){
    //         String dst = queue.poll();
    //         dfs(adj, dst, res);
    //     }

    //     res.add(node);
    // }
}
