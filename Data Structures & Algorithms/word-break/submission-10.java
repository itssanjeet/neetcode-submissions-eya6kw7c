class Solution {

    Map<Integer, Boolean> memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        memo = new HashMap<>();
        memo.put(n, true);
        solve(s, 0, wordDict);
        return memo.get(0);
    }

    private boolean solve(String s, int idx, List<String> wordDict){
        if(memo.containsKey(idx)){
            return memo.get(idx);
        }

        boolean res = false;
        for(String w: wordDict){
            if(idx + w.length() <= s.length() && w.equals(s.substring(idx, idx + w.length()))){
                res = res || solve(s, idx + w.length(), wordDict);
            }
        }

        memo.put(idx, res);

        return res;
    }
}
