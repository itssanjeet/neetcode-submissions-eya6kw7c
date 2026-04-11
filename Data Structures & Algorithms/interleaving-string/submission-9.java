class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();

        if(l1 + l2 != l3){
            return false;
        }

        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[l1][l2] = true;

        for(int r=l1; r>= 0; r--){
            for(int c=l2; c>= 0; c--){
                if(r < l1 && s1.charAt(r) == s3.charAt(r+c)){
                    dp[r][c] = dp[r+1][c];
                } 

                if(c < l2 && s2.charAt(c) == s3.charAt(r+c)){
                    dp[r][c] = dp[r][c+1];
                }
            }
        }

        return dp[0][0];
    }
}
