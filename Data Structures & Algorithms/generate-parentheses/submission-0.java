class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        backTracking(n, 0, 0, new StringBuilder(), res);

        return res;
    }

    private void backTracking(int n, int closeN, int openN, StringBuilder sb
        , List<String> res){
        if(openN == closeN && openN == n){
            res.add(new String(sb));
            return;
        }

        if(openN < n){
            sb.append("(");
            backTracking(n, closeN, openN+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }

        if(closeN < openN){
            sb.append(")");
            backTracking(n, closeN+1, openN, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
