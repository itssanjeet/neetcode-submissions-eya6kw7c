class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int res = 0;
        for(int i=0; i<n; i++){
            int min = heights[i];
            for(int j=i; j<n; j++){
                min = Math.min(min, heights[j]);
                res = Math.max(res, min * (j-i+1));
            }
        }

        return res;
    }
}
