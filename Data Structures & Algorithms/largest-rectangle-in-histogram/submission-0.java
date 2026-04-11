class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        int min = Integer.MAX_VALUE;

        int max = 0;
        for(int i= 0; i<n; i++){
            int h = heights[i];
            st.push(h);
            if(min > h){
                min = h;
            }

            max = Math.max(max, min*st.size());

            int min2 = h;
            while(!st.isEmpty() && st.peek() > min){
                int h2 = st.pop();
                st2.push(h2);
                if(min2 > h2){
                    min2 = h2;
                }

                max = Math.max(min2*st2.size(), max);
            }

            while(!st2.isEmpty()){
                st.push(st2.pop());
            }
        }

        return max;
    }
}
