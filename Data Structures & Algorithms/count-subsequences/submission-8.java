class Solution {
    public int numDistinct(String s, String t) {
        int s1 = s.length(), t1 = t.length();
        if(t1 > s1){
            return 0;
        }
        int[][] dp = new int[s1+1][t1+1];
        for(int i=0; i<=s1; i++){
            dp[i][t1] = 1;
        }

        for(int i=s1-1; i>= 0; i--){
            for(int j=t1-1; j>= 0; j--){
                dp[i][j] = dp[i+1][j];
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] += dp[i+1][j+1];
                }
            }
        }
        
        return dp[0][0];
    }

    // private int solve(String s, String t, int i, int j){
    //     if(j == t.length()){
    //         return 1;
    //     }

    //     if(i == s.length()){
    //         return 0;
    //     }

    //     int res = solve(s, t, i+1, j);
    //     if(s.charAt(i) == t.charAt(j)){
    //         res += solve(s, t, i+1, j+1);
    //     }

    //     return res;
    // }
}
