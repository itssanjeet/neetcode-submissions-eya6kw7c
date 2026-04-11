class Solution {
    int sum = 0;

    public boolean canPartition(int[] nums) {
        sum = 0;
        for(int x:nums){
            sum += x;
        }

        return dfs(nums, 0, 0);
    }

    private boolean dfs(int[] nums, int i, int subsum){
        if(sum - subsum == subsum){
            return true;
        }

        if(i == nums.length){
            return false;
        }

        return dfs(nums, i+1, subsum + nums[i]) || dfs(nums, i+1, subsum);
    }
}
