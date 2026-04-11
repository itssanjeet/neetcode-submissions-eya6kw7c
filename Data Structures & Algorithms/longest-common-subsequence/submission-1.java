class Solution {
    int[][] memo = null;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for(int[] me:memo){
            Arrays.fill(me, -1);
            System.out.println(Arrays.toString(me));
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

        if(s1.charAt(i) == s2.charAt(j)){
            return 1 + dfs(s1, s2, i+1, j+1);
        }

        memo[i][j] = Math.max(dfs(s1, s2, i+1, j), dfs(s1, s2, i, j+1));
        return memo[i][j];
    }
}
