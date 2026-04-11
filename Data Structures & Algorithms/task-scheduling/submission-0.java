class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> hm = new HashMap<>();

        for(char c:tasks){
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->Integer.compare(b,a));

        for(Map.Entry<Character, Integer> entry:hm.entrySet()){
            pq.add(entry.getValue());
        }

        Queue<int[]> q = new ArrayDeque<>();
        int res = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            res++;

            if(pq.isEmpty()){
                res = q.peek()[1];
            } else {
                int count = pq.poll()-1;
                if(count > 0){
                    q.add(new int[]{count, res + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == res){
                pq.add(q.poll()[0]);
            }
        }

        return res;
    }
}
