class Solution {

    Map<String, Integer> memo = new HashMap<>();

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);

        return dfs(coins, 0, amount);
    }

    private int dfs(int[] coins, int i, int a){
        if(a==0){
            return 1;
        }

        if(i >= coins.length){
            return 0;
        }

        String key = i +"-"+ a;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int res = 0;
        if(a >= coins[i]){
            res = dfs(coins, i+1, a);
            res += dfs(coins, i, a-coins[i]);
        }

        memo.put(key, res);
        return res;
    }
}
