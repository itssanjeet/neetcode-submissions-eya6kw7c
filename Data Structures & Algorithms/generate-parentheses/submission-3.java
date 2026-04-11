class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();

        dfs(n, 0, 0, "");

        return res;
    }

    private void dfs(int n, int open, int close, String str){
        if(open == close && open == n){
            res.add(new String(str));
            return;
        }

        if(open < n){
            dfs(n, open + 1, close, str + "(");
        }

        if(close < open){
            dfs(n, open, close + 1, str + ")");
        }
    }
}
