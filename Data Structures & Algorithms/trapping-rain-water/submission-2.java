class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int res = 0;
        for(int i=1; i<n; i++){
            int leftMax = height[i];
            for(int j = i-1; j>=0; j--){
                leftMax = Math.max(leftMax, height[j]);
            }

            int rightMax = height[i];
            for(int k=i+1; k<n; k++){
                rightMax = Math.max(rightMax, height[k]);
            }

            res += Math.min(leftMax, rightMax) - height[i];
        }

        return res;
    }
}
