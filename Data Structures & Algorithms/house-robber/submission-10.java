class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return nums[0];
        }
        
        int[] dp = new int[n+1];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[n-1];
    }

    // private int dfs(int[] nums, int i){
    //     if(i >= nums.length){
    //         return 0;
    //     }
    //     if(memo[i] != -1){
    //         return memo[i];
    //     }

    //     memo[i] = Math.max(dfs(nums, i+1), nums[i] + dfs(nums, i+2));

    //     return memo[i];
    // }
}
