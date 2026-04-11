class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l=0, r = n-1;

        int max = 0;
        while(l < r){
            int res = (r-l) * Math.min(heights[l], heights[r]);
            max = Math.max(res, max);

            if(heights[l] < heights[r]){
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
