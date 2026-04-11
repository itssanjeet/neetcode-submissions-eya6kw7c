class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[k-1] = 0;

        for(int i=0; i<n; i++){
            int[] temp = cost.clone();

            for(int[] time: times){
                int u = time[0] - 1;
                int v = time[1] - 1;
                int w = time[2];

                if(cost[u] == Integer.MAX_VALUE){
                    continue;
                }

                if(temp[v] > w + cost[u]){
                    temp[v] = w + cost[u];
                }
            }

            cost = temp;
        }

        int max = Arrays.stream(cost).max().getAsInt();

        return max == Integer.MAX_VALUE? -1: max;
    }
}
