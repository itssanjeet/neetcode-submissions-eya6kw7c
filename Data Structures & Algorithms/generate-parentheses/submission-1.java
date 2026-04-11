class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        
        dfs(0, 0, n, "");

        return res;
    }

    private void dfs(int open, int close, int n, String s){
        if(open == n && close == n){
            res.add(s);
            return;
        }


        if(open < n){
            dfs(open+1, close, n, s + "(");
        }

        if(close < open){
            dfs(open, close+1, n, s + ")");
        }
    }
}
