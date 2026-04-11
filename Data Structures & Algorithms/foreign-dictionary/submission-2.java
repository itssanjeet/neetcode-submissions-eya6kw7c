class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;

        Map<Character, Set<Character>> adj = new HashMap<>();

        for(String w:words){
            for(char c:w.toCharArray()){
                adj.put(c, new HashSet<>());
            }
        }

        for(int i=0; i<n-1; i++){
            String w1 = words[i];
            String w2 = words[i+1];

            int minLen = Math.min(w1.length(), w2.length());

            if(w1.length() > w2.length() && 
                w1.substring(0, minLen).equals(w2.substring(0, minLen))){
                    return "";
                }

            for(int j=0; j< minLen; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        Map<Character, Boolean> visit = new HashMap<>();
        Stack<Character> st = new Stack<>();
        for(char c: adj.keySet()){
            if(dfs(adj, c, visit, st)){
                return "";
            }
        }

        String res = "";
        while(!st.isEmpty()){
            res += st.pop();
        }

        return res;
    }

    private boolean dfs(Map<Character, Set<Character>> adj, char node, 
        Map<Character, Boolean> visit, Stack<Character> st){
        if(visit.containsKey(node)){
            return visit.get(node);
        }

        visit.put(node, true);

        for(char nbr: adj.getOrDefault(node, new HashSet<>())){
            if(dfs(adj, nbr, visit, st)){
                return true;
            }
        }

        visit.put(node, false);
        st.push(node);

        return false;
    }
}



