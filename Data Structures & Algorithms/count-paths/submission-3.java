class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int r=1; r<m; r++){
            int[] newdp = new int[n];
            newdp[0] = 1;
            for(int c=1; c<n; c++){
                newdp[c] = dp[c] + newdp[c-1];
            }
            dp = newdp;
        }

        return dp[n-1];
    }
}
