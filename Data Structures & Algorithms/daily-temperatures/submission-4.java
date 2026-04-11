class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        for(int i=temperatures.length-1; i>= 0; i--){
            while(!st.isEmpty() && temperatures[i] >= st.peek()[0]){
                st.pop();
            }

            int val = 0;
            if(!st.isEmpty()){
                int top = st.peek()[1];
                val = top - i;
            }

            st.push(new int[]{temperatures[i], i});
            temperatures[i] = val;
        }

        return temperatures;
    }
}
