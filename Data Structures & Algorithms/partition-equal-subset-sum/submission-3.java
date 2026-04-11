class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if(sum % 2 == 1){
            return false;
        }

        int target = sum / 2;

        return dfs(nums, 0, target);
    }

    private boolean dfs(int[] nums, int i, int target){
        if(target == 0){
            return true;
        }

        if(i == nums.length){
            return false;
        }

        return dfs(nums, i+1, target) || dfs(nums, i+1, target - nums[i]);
    }
}
