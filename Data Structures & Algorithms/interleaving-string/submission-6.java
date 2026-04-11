class Solution {

    Map<String, Boolean> memo = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if(l1 + l2 != l3){
            return false;
        }

        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[l1][l2] = true;
        for(int i=l1; i>=0; i--){
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
