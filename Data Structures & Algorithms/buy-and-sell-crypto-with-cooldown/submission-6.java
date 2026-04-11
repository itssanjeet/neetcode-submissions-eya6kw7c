class Solution {

    Map<String, Integer> memo = new HashMap<>();
    public int maxProfit(int[] prices) {
        return solve(prices, 0, true);
    }

    private int solve(int[] prices, int idx, boolean buying){
        if(idx >= prices.length){
            return 0;
        }

        String key = idx + "-" + buying;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int res = Integer.MIN_VALUE;
        int cooldown = solve(prices, idx+1, buying);
        res = Math.max(res, cooldown);
        if(buying){
            int buy = solve(prices, idx+1, false) - prices[idx];
            res = Math.max(res, buy);
        } else {
            int sell = solve(prices, idx+2, true) + prices[idx];
            res = Math.max(res, sell);
        }

        memo.put(key, res);
        return res;
    }
}
