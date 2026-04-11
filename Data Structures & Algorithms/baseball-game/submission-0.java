class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;

        Stack<Integer> st = new Stack<>();

        for(String op: operations){
            if(op.charAt(0) == 'D'){
                st.push(st.peek() * 2);
            } else if(op.charAt(0) == 'C'){
                st.pop();
            } else if(op.charAt(0) == '+'){
                int last = st.pop();
                int sum = last + st.peek();
                st.push(last);
                st.push(sum);
            } else {
                int val = Integer.valueOf(op);
                st.push(val);  
            }
        }

        int res = 0;
        while(!st.isEmpty()){
            res += st.pop();
        }

        return res;
    }
}