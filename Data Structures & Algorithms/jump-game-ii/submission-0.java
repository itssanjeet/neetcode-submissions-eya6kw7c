class Solution {

    int ans = Integer.MAX_VALUE;
    public int jump(int[] nums) {
        dfs(0, nums, 0);
        return ans;
    }

    private void dfs(int idx, int[] nums, int jumps){
        if(idx >= nums.length-1){
            ans = Math.min(ans, jumps);
            return;
        }

        for(int i = nums[idx]+idx; i > idx; i--){
            dfs(i, nums, jumps+1);
        }
    }
}
