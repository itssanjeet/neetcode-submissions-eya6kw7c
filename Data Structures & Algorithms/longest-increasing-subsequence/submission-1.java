class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=n-1; i>= 0; i--){
            for(int j=i+1; j<n; j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    // private int dfs(int[] nums, int i, int j){
    //     if(i == nums.length){
    //         return 0;
    //     }

    //     int res = dfs(nums, i+1, j);

    //     if(j == -1 || nums[j] < nums[i]){
    //         res = Math.max(res, 1+dfs(nums, i+1, i));
    //     }

    //     return res;
    // }
}
