class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        Map<Character, Character> hm = new HashMap<>();
        hm.put('(', ')');
        hm.put('{', '}');
        hm.put('[', ']');

        Stack<Character> st = new Stack<>();
        int idx = 0;
        while(idx < n){
            if(!st.isEmpty() && hm.getOrDefault(st.peek(), '0') == s.charAt(idx)){
                st.pop();
            } else {
                st.push(s.charAt(idx));
            }
            
            idx++;
        }



        return st.isEmpty();
    }
}
