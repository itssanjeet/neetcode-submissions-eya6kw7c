class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int max = 0;
        for(int i=0; i<n; i++){
            int min = heights[i];
            max = Math.max(max, min);
            for(int j=i+1; j<n; j++){
                if(min > heights[j]){
                    min = heights[j];
                }

                max = Math.max(max, min * (j-i+1));
            }
        }

        return max;
    }
}
