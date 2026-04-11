class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for(int i=0; i<=k; i++){
            int[] temp = cost.clone();
            for(int[] flight:flights){
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];

                System.out.println(Arrays.toString(cost));

                if(cost[s] == Integer.MAX_VALUE){
                    continue;
                }

                if(cost[s] + p < temp[d]){
                    temp[d] = cost[s] + p;
                }
            }

            cost = temp;
        }
        int res = cost[dst];

        return res == Integer.MAX_VALUE? -1:res;
    }
}
