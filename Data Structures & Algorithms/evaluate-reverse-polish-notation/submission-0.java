class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+"); set.add("-"); set.add("*"); set.add("/");

        for(String t:tokens){
            if(set.contains(t)){
                int y = st.pop();
                int x = st.pop();
                int z = 0;
                System.out.println("t: "+t);
                if(t.equals("+")){
                    z = x + y;
                } else if(t.equals("-")){
                    z = x - y;
                } else if(t.equals("*")){
                    z = x * y;
                } else {
                    if(y == 0){
                        z = x;
                    } else 
                        z = x / y;
                }
                st.push(z);
            } else {
                st.push(Integer.parseInt(t));
            }
            System.out.println("st: "+st);
        }

        return st.isEmpty()? 0:st.peek();     
    }
}
