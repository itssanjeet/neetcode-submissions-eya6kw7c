class Solution {
    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1){
            return false;
        }

        return solve(nums, 0, sum/2);
    }

    private boolean solve(int[] nums, int i, int sum){
        if(i == nums.length){
            return sum == 0;
        }

        boolean res = solve(nums, i+1, sum - nums[i]);
        res = res || solve(nums, i+1, sum);

        return res;
    }
}
