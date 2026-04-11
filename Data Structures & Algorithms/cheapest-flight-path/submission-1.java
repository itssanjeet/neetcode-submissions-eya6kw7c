class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for(int i=0; i<k+1; i++){
            int temp[] = cost.clone();
            for(int[] flight:flights){
                int s = flight[0];
                int d = flight[1];
                int wt = flight[2];
                if(cost[s] == Integer.MAX_VALUE){
                    continue;
                }

                if(temp[d] > wt + cost[s]){
                    temp[d] = wt + cost[s];
                }
            }

            cost = temp;
        }
        System.out.println(Arrays.toString(cost));
        
        int res = cost[dst];

        return res == Integer.MAX_VALUE? -1:res;
    }
}
