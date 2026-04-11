class Solution {
    public int numDistinct(String s, String t) {
        int s1 = s.length(), t1 = t.length();

        if(t1 > s1){
            return 0;
        }

        int[] dp = new int[t1+1];
        dp[t1] = 1;
        for(int i=s1-1; i >= 0; i--){
            int[] newdp = new int[t1+1];
            newdp[t1] = 1;
            for(int j=t1-1; j>=0; j--){
                newdp[j] = dp[j];
                if(s.charAt(i) == t.charAt(j)){
                    newdp[j] += dp[j+1];
                }
            }
            dp = newdp;
        }

        return dp[0];
    }
}
