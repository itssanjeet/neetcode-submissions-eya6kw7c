
class Solution {
    int[] memo;
    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n+1];
        Arrays.fill(memo, -1);

        return solve(nums, 0);
    }

    private int solve(int[] nums, int idx){
        if(idx >= nums.length){
            return 0;
        }

        if(memo[idx] != -1){
            return memo[idx];
        }

        int res = solve(nums, idx+1);
        if(idx < nums.length){
            res = Math.max(res, nums[idx] + solve(nums, idx+2));
        }

        memo[idx] = res;

        return res;
    }
}
