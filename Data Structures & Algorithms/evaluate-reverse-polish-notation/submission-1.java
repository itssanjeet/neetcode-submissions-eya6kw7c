class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        Stack<Integer> st = new Stack<>();
        int res = 0;
        for(String s:tokens){
            if("+-*/".contains(s)){
                int x = st.pop();
                int y = st.pop();
                if("+".equals(s)){
                    st.push(x+y);
                } else if("-".equals(s)){
                    st.push(y-x);
                } else if("*".equals(s)){
                    st.push(x*y);
                } else {
                    if(x != 0)
                        st.push((int)y/x);
                }
            } else {
                st.push(Integer.valueOf(s));
            }
        }

        return st.peek();
    }
}
