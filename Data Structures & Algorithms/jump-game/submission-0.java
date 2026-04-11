class Solution {
    public boolean canJump(int[] nums) {
        return dfs(0, nums);
    }

    private boolean dfs(int idx, int[] nums){
        int n = nums.length;
        if(idx >= n-1){
            return true;
        }

        for(int i = nums[idx] + idx; i > idx; i--){
            if(dfs(i, nums)){
                return true;
            }
        }

        return false;
    }
}
