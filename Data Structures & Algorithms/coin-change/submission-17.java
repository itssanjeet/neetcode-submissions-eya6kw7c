class Solution {
    Map<Integer, Integer> hm;
    public int coinChange(int[] coins, int amount) {
        hm = new HashMap<>();
        hm.put(0, 0);
        int res = solve(coins, amount);
        return res == (int)1e9? -1: res;
    }

    private int solve(int[] coins, int a){
        if(hm.containsKey(a)){
            return hm.get(a);
        }

        int res = (int)1e9;
        for(int c:coins){
            if(c <= a){
                res = Math.min(res, 1 + solve(coins, a - c));
            }
        }

        hm.put(a, res);

        return res;
    }
}
