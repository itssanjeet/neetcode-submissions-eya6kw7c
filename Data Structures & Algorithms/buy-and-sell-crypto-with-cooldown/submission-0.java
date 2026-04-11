class Solution {

    Map<String, Integer> memo = new HashMap<>();

    public int maxProfit(int[] prices) {
        return dfs(prices, 0, true);
    }

    private int dfs(int[] prices, int i, boolean buying){
        if(i>= prices.length){
            return 0;
        }

        String key = i + "-" + buying;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        int cooldown = dfs(prices, i+1, buying);
        if(buying){
            int buy = dfs(prices, i+1, false) - prices[i];
            memo.put(key, Math.max(cooldown, buy));
        } else {
            int sell = dfs(prices, i+2, true) + prices[i];
            memo.put(key, Math.max(cooldown, sell));
        }

        return memo.get(key);
    }
}
