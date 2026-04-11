class Solution {
    int[] memo = null;
    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i){
        if( i >= nums.length){
            return 0;
        }

        if(memo[i] != -1){
            return memo[i];
        }

        memo[i] = Math.max(dfs(nums, i+1), nums[i]+ dfs(nums, i+2));;
        return memo[i];
    }
}
