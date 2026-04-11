class Solution {
    public int numDistinct(String s, String t) {
        int s1 = s.length();
        int t1 = t.length();
        if(t1 > s1){
            return 0;
        }

        int[][] dp = new int[s1+1][t1+1];
        for(int i=0; i<=s1; i++){
            dp[i][t1] = 1;
        }

        for(int r=s1-1; r>=0; r--){
            for(int c=t1-1; c>=0; c--){
                dp[r][c] = dp[r+1][c];
                if(s.charAt(r) == t.charAt(c)){
                    dp[r][c] += dp[r+1][c+1];
                }
            }
        }

        return dp[0][0];
    }
}
