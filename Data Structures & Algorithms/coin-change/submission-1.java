class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int res = dfs(coins, amount);
        return (res >=1e9)? -1:res;
    }

    private int dfs(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }

        if(map.containsKey(amount)){
            return map.get(amount);
        }

        int res = (int) 1e9;
        for(int c:coins){
            if(amount - c >= 0){
                res = Math.min(res, 1 + dfs(coins, amount - c));
            }
        }

        map.put(amount, res);
        return res;
    }
}
