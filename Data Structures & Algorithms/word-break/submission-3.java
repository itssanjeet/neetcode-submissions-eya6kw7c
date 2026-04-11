class Solution {
    // Map<Integer, Boolean> memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        for(int i=n-1; i>= 0; i--){
            for(String w:wordDict){
                if((i+w.length()) <= s.length() && 
                    s.substring(i, i+w.length()).equals(w)){
                        dp[i] = dp[i+w.length()];
                    }

                if(dp[i]){
                    break;
                }
            }
        }

        return dp[0];
    }

    // private boolean dfs(String s, List<String> wordDict, int i){
    //     if(memo.containsKey(i)){
    //         return memo.get(i);
    //     }

    //     for(String w:wordDict){
    //         if(i+w.length() <= s.length() && wordDict.contains(s.substring(i, i+w.length()))){
    //             if(dfs(s, wordDict, i+w.length())){
    //                 memo.put(i, true);
    //                 return true;
    //             }
    //         }
    //     }

    //     memo.put(i, false);
    //     return false;
    // }
}
