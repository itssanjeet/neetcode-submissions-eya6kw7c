class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int res = 0;
        int l=0, r = n-1;
        while(l < r){
            int min = Math.min(heights[l], heights[r]);
            res = Math.max(res, (r-l) * min);

            if(heights[l] < heights[r]){
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}
