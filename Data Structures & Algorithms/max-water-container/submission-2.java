class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        if(n == 0 || n == 1){
            return 0;
        }

        int l = 0, r = n-1;
        int max = 0;
        while(l < r){
            int height = Math.min(heights[l], heights[r]);
            int width = r - l;
            max = Math.max(max, height*width);
            if(heights[l] < heights[r]){
                l++;
            } else {
                r--;
            }
        }

        return max;
        /*
        1 7 2 5 4 7 3 6
        0 1 2 3 4 5 6 7
        */
    }
}
