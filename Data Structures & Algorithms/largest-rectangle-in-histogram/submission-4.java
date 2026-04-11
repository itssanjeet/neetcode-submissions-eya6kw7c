class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for(int i=0; i<=n; i++){
            
            while(!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])){
                int height = heights[st.pop()];
                int width = st.isEmpty()? i: i - st.peek() - 1;

                res = Math.max(res, height * width);
            }

            st.push(i);
        }

        return res;
    }
}
