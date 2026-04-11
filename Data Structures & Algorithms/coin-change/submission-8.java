class Solution {

    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        memo.put(0,0);
        int res = dfs(coins, amount);
        return res == 1e9? -1:res;
    }

    private int dfs(int[] coins, int amount){
        if(memo.containsKey(amount)){
            return memo.get(amount);
        }
        
        int res = (int) 1e9;
        for(int c:coins){
            if(amount - c >= 0){
                res = Math.min(res, 1 + dfs(coins, amount-c));
            }
        }

        memo.put(amount, res);
        return res;
    }
}
