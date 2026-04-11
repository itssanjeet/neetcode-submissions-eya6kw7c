class Solution {
    public int numDecodings(String s) {
        return solve(s, 0);
    }

    private int solve(String s, int idx){
        if(idx >= s.length()){
            return 1;
        }

        if(s.charAt(idx) == '0'){
            return 0;
        }

        int res = solve(s, idx+1);
        if(idx + 1 < s.length() && (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx+1) < '7'))){
            res += solve(s, idx+2);
        }

        return res;
    }
}
