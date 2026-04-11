class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, target, 0);
    }

    private int solve(int[] nums, int idx, int t, int sum){
        if(idx == nums.length){
            return sum == t? 1:0;
        }

        return solve(nums, idx+1, t, sum - nums[idx]) 
                + solve(nums, idx+1, t, sum + nums[idx]);
    }
}
