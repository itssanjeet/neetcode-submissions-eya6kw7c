class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return nums[0];
        }
        return Math.max(helper(nums, 1, n-1), helper(nums, 0, n-2));
    }

    private int helper(int[] nums, int l, int r){
        int one = 0, two = 0;

        for(int i=l; i<=r; i++){
            int temp = Math.max(one + nums[i], two);
            one = two;
            two = temp;
        }

        return two;
    }
}
