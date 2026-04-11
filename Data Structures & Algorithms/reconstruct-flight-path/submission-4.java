class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for(List<String> ticket:tickets){
            String src = ticket.get(0);
            String dst = ticket.get(1);
            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).add(dst);
        }

        List<String> res = new ArrayList<>();
        dfs(adj, "JFK", res);

        Collections.reverse(res);

        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> adj, String node, List<String> res){

        PriorityQueue<String> queue = adj.getOrDefault(node, new PriorityQueue<>());
        while(!queue.isEmpty()){
            dfs(adj, queue.poll(), res);
        }

        res.add(node);
    }
}
