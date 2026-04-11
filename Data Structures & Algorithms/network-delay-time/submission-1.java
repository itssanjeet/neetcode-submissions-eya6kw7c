class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[k-1] = 0;

        for(int i=0; i<n-1; i++){
            int[] temp = cost.clone();

            for(int[] time:times){
                int u = time[0]-1, v = time[1] - 1, w = time[2];
                if(cost[u] == Integer.MAX_VALUE){
                    continue;
                }

                if(cost[u] + w < temp[v]){
                    temp[v] = cost[u] + w;
                }
            }

            cost = temp;
        }

        int res = Arrays.stream(cost).max().getAsInt();
        
        return res == Integer.MAX_VALUE? -1:res;
    }
}
