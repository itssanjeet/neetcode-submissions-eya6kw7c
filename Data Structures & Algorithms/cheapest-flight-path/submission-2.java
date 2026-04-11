class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for(int i=0; i<=k; i++){
            int[] temp = cost.clone();

            for(int[] flight: flights){
                int u = flight[0];
                int v = flight[1];
                int p = flight[2];

                if(cost[u] == Integer.MAX_VALUE){
                    continue;
                }

                if(temp[v] > p + cost[u]){
                    temp[v] = p + cost[u];
                }
            }

            cost = temp;
        }

        int max = cost[dst];

        return max == Integer.MAX_VALUE? -1: max;
    }
}
