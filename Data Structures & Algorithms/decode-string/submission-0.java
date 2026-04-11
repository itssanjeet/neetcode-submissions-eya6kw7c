class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();

        for(char c: s.toCharArray()){
            if(c != ']'){
                st.push(String.valueOf(c));
            } else {
                String sub = "";
                while(!st.peek().equals("[")){
                    sub = st.pop() + sub;
                }
                st.pop();

                String numStr = "";
                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0))){
                    numStr = st.pop() + numStr;
                }

                int num = Integer.valueOf(numStr);

                String substr = "";
                for(int i=0; i<num; i++){
                    substr += sub;
                }

                st.push(substr);
            }
        }

        return String.join("", st);
    }
}