class Solution {

    Map<String, Integer> memo;
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);

        memo = new HashMap<>();

        return solve(coins, 0, amount);
    }

    private int solve(int[] coins, int idx, int a){
        if(a == 0){
            return 1;
        }
        String key = idx + "-" + a;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int res = 0;
        for(int j=idx; j<coins.length; j++){
            if(coins[j] <= a){
                res += solve(coins, j, a - coins[j]);
            }
        }

        memo.put(key, res);

        return res;
    }
}
