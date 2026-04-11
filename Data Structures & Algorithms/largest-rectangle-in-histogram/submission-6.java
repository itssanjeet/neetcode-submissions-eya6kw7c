class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int res = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<=n; i++){

            while(!st.isEmpty() &&(i == n || heights[st.peek()] >= heights[i])){
                int h = heights[st.pop()];

                int w = st.isEmpty()? i: i-st.peek()-1;

                res = Math.max(res, h * w);
            }

            st.push(i);
        }

        return res;
    }
}
