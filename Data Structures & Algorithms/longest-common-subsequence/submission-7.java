class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        if(l1 == 0 || l2 == 0){
            return 0;
        }

        int[][] dp = new int[l1+1][l2+1];

        for(int r=l1-1; r>=0; r--){
            for(int c=l2-1; c>=0; c--){
                if(text1.charAt(r) == text2.charAt(c)){
                    dp[r][c] = 1 + dp[r+1][c+1];
                } else {
                    dp[r][c] = Math.max(dp[r+1][c], dp[r][c+1]);
                }
            }
        }
        
        return dp[0][0];
    }
}
