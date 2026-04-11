class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        Stack<int[]> st = new Stack<>();
        int[] res = new int[n];

        for(int i=n-1; i>= 0; i--){
            int val = temperatures[i];
            while(!st.isEmpty() && st.peek()[0] <= val){
                st.pop();
            }

            if(st.isEmpty())
                res[i] = 0;
            else {
                res[i] = st.peek()[1] - i;
            }

            st.push(new int[]{val, i});
        }

        return res;
    }
}
