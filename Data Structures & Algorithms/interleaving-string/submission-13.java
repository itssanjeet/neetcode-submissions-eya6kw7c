class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }

        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[l1][l2] = true;
        for(int i=l1; i>= 0; i--){
            for(int j=l2; j>=0; j--){
                if(i < l1 && s1.charAt(i) == s3.charAt(i+j) && dp[i+1][j]){
                    dp[i][j] = true;
                }

                if(j < l2 && s2.charAt(j) == s3.charAt(i+j) && dp[i][j+1]){
                    dp[i][j] = true;
                }
            }
        }

        return dp[0][0];
    }
}
