class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> hm = new HashMap<>();

        for(List<String> ticket: tickets){
            hm.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            hm.get(ticket.get(0)).offer(ticket.get(1));
        }

        Stack<String> st = new Stack<>();
        dfs(hm, "JFK", st);

        List<String> res = new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.pop());
        }

        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> hm, String node, Stack<String> st){
        PriorityQueue<String> pq = hm.getOrDefault(node, new PriorityQueue<>());

        while(!pq.isEmpty()){
            dfs(hm, pq.poll(), st);
        }

        st.push(node);
    }
}
