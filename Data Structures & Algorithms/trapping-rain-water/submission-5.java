class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int max = 0;

        for(int i = 1; i<n-1; i++){
            int leftMax = height[i];
            for(int j = i-1; j>= 0; j--){
                leftMax = Math.max(leftMax, height[j]);
            }

            int rightMax = height[i];
            for(int j=i+1; j<n; j++){
                rightMax = Math.max(rightMax, height[j]);
            }

            max += Math.min(rightMax, leftMax) - height[i];
        }

        return max;
    }
}
