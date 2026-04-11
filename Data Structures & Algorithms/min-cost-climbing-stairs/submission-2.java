class Solution {
    int[] memo = null;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(findPath(cost, 0), findPath(cost, 1));
    }

    private int findPath(int[] cost, int i){
        if(i >= cost.length){
            return 0;
        }

        if(memo[i] != -1){
            return memo[i];
        }

        memo[i] = cost[i] + Math.min(findPath(cost, i+1), findPath(cost, i+2));
        return memo[i];
    }
}
