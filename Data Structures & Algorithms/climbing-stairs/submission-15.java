class Solution {
    int[] memo;

    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        
        memo = new int[n+1];

        Arrays.fill(memo, -1);
        solve(n);

        return memo[n];
    }

    private int solve(int n){
        if(memo[n] != -1){
            return memo[n];
        }

        if(n <= 1){
            return 1;
        }

        memo[n] = solve(n-1) + solve(n-2);

        return memo[n];
    }
}
