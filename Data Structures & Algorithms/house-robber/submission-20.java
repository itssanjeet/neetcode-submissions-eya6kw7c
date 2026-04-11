
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int one = 0, two = nums[n-1];

        for(int i=n-2; i>= 0; i--){
            int three = Math.max(one + nums[i], two);
            one = two;
            two = three;
        }

        return two;
    }

}
