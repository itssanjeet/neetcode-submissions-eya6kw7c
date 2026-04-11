class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] leftProd = new int[n];
        int left = 1;
        int[] rightProd = new int[n];
        int right = 1;
        for(int i=0; i<n; i++){
            left *= nums[i];
            right *= nums[n-i-1];

            leftProd[i] = left;
            rightProd[n-i-1] = right;
        }

        int[] res = new int[n];
        for(int i=0; i<n; i++){
            int leftProdVal = 1;
            if(i > 0){
                leftProdVal = leftProd[i-1];
            }

            int rightProdVal = 1;
            if(i < n-1){
                rightProdVal = rightProd[i+1];
            }

            res[i] = leftProdVal * rightProdVal;
        }

        return res;
    }
}  
