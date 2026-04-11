class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int r=0; r<l1; r++){
            dp[r][l2] = l1-r;
        }

        for(int c=0; c<l2; c++){
            dp[l1][c] = l2-c;
        }

        for(int r=l1-1; r>=0; r--){
            for(int c=l2-1; c>=0; c--){
                if(word1.charAt(r) == word2.charAt(c)){
                    dp[r][c] = dp[r+1][c+1];
                } else {
                    dp[r][c] = 1 + Math.min(dp[r+1][c], Math.min(dp[r][c+1], dp[r+1][c+1]));
                }
            }
        }

        return dp[0][0];
    }
}
