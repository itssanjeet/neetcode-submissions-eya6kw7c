class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;

        for(int i=0; i<n; i++){
            int minVal = Integer.MAX_VALUE;
            for(int j=i; j<n; j++){
                minVal = Math.min(minVal, heights[j]);
                max = Math.max(max, minVal * (j-i+1));
            }
        }

        return max;
    }
}
