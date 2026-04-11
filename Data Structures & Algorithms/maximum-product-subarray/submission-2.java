class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        for(int n:nums){
            if(n > res){
                res = n;
            }
        }

        int minProd = 1, maxProd = 1;
        for(int n:nums){
            if(n == 0){
                minProd = 1;
                maxProd = 1;
                continue;
            }

            int temp = maxProd * n;
            maxProd = Math.max(n, Math.max(minProd * n, maxProd * n));
            minProd = Math.min(n, Math.min(minProd * n, temp));

            res = Math.max(maxProd, res);
        }

        return res;
    }
}
