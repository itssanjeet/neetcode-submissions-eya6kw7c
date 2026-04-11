class Solution {
    int[] memo = null;
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(s, 0);
    }

    int dfs(String s, int i){
        if(i >= s.length()){
            return 1;
        }

        if(memo[i] != -1){
            return memo[i];
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        int res = dfs(s, i+1);
        if(i+1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))){
            res += dfs(s, i+2);
        }

        memo[i] = res;
        return res;
    }
}
