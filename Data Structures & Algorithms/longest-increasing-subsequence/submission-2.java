class Solution {
    public int lengthOfLIS(int[] nums) {
        return dfs(nums, 0, -1);
    }

    private int dfs(int[] nums, int i, int j){
        if(i == nums.length){
            return 0;
        }

        int res = dfs(nums, i+1, j);

        if(j == -1 || nums[j] < nums[i]){
            res = Math.max(res, 1 + dfs(nums, i+1, i));
        }

        return res;
    }
}
