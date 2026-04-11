class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return nums[0];
        }

        int left = 1, right = 1, res = 0;
        for(int i=0; i<n; i++){
            if(left == 0){
                left = 1;
            }

            if(right == 0){
                right = 1;
            }

            left *= nums[i];
            right *= nums[n-i-1];
            res = Math.max(res, Math.max(left, right));
        }

        return res;
    }
}
