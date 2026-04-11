class Solution {
    int[] memo = null;
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(s, 0);
    }

    private int dfs(String s, int i){
        if(i == s.length()){
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        if(memo[i] != -1){
            return memo[i];
        }

        int count = dfs(s, i+1);
        if(i+1 < s.length()){
            int number = Integer.parseInt(s.substring(i, i+2));
            if(number <= 26){
                count += dfs(s, i+2);
            }
        }

        memo[i] = count;
        return count;
    }
}
