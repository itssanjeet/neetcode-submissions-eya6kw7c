class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        return Math.max(nums[0], 
            Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length-1)), helper(Arrays.copyOfRange(nums, 1, nums.length))));
    }

    private int helper(int[] nums){
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int one = nums[0];
        int two = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            int three = Math.max(one + nums[i], two);
            one = two;
            two = three;
        }

        return two;
    }
}
