class Solution {
    int[] memo = null;
    public int numDecodings(String s) {
        int n = s.length();
        memo = new int[n+1];
        memo[n] = 1;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '0'){
                memo[i] = 0;
            } else {
                memo[i] = memo[i+1];
                if(i+1 < n && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))){
                    memo[i] += memo[i+2];
                }
            }
        }

        // return dfs(s, 0);
        return memo[0];
    }

    // private int dfs(String s, int i){
    //     if(i == s.length()){
    //         return 1;
    //     }

    //     if(s.charAt(i) == '0'){
    //         return 0;
    //     }

    //     if(memo[i] != -1){
    //         return memo[i];
    //     }

    //     int count = dfs(s, i+1);
    //     if(i+1 < s.length()){
    //         int number = Integer.parseInt(s.substring(i, i+2));
    //         if(number <= 26){
    //             count += dfs(s, i+2);
    //         }
    //     }

    //     memo[i] = count;
    //     return count;
    // }
}
