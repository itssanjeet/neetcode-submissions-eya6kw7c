class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int leftProd = 1, rightProd = 1, res = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(leftProd == 0){
                leftProd = 1;
            }
            if(rightProd == 0){
                rightProd = 1;
            }

            leftProd *= nums[i];
            rightProd *= nums[n-i-1];
            
            res = Math.max(res, Math.max(leftProd, rightProd));
        }

        return res;
    }
}
