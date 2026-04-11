class Solution {
    
    int[][] memo = null;

    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        if(l1 == 0 || l2 == 0){
            return 0;
        }

        memo = new int[l1+1][l2+1];
        for(int i=0; i<=l1; i++){
            Arrays.fill(memo[i], -1);
        }

        return dfs(text1, text2, 0, 0);
    }

    private int dfs(String s1, String s2, int i, int j){
        if(i == s1.length() || j == s2.length()){
            return 0;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int res = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            res = 1 + dfs(s1, s2, i+1, j+1);
        } else {
            res = Math.max(dfs(s1, s2, i+1, j), dfs(s1, s2, i, j+1));
        }

        memo[i][j] = res;
        return res;
    }
}
