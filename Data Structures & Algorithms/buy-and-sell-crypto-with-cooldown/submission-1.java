class Solution {
    public int maxProfit(int[] prices) {
        return dfs(prices, 0, true);
    }

    private int dfs(int[] prices, int i, boolean buying){
        if(i >= prices.length){
            return 0;
        }

        int cooldown = dfs(prices, i+1, buying);
        if(buying){
            int buy = dfs(prices, i+1, false) - prices[i];
            return Math.max(cooldown, buy);
        } else {
            int sell = dfs(prices, i+2, true) + prices[i];
            return Math.max(cooldown, sell);
        }
    }
}
