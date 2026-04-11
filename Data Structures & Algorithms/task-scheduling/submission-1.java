class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char t:tasks){
            count[t-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int c:count){
            if(c > 0){
                pq.add(c);
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;

            if(pq.isEmpty()){
                time = q.peek()[1];
            } else {
                int cnt = pq.poll() -1;
                if(cnt > 0){
                    q.add(new int[]{cnt, time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.poll()[0]);
            }
        }

        return time;
    }
}
