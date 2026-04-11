class Solution {

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int one = nums[0];
        int two = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            int three = Math.max(nums[i] + one, two);
            one = two;
            two = three;
        }

        return two;
    }

    // private int dfs(int[] nums, int i){
    //     if(i >= nums.length){
    //         return 0;
    //     }
    //     if(memo[i] != -1){
    //         return memo[i];
    //     }

    //     memo[i] = Math.max(dfs(nums, i+1), nums[i] + dfs(nums, i+2));

    //     return memo[i];
    // }
}
