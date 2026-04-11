class Solution {

    Map<String, Boolean> memo = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }

        return dfs(s1, s2, s3, 0, 0);
    }

    private boolean dfs(String s1, String s2, String s3, int i1, int i2){
        if(i1 == s1.length() && i2 == s2.length()){
            return true;
        }

        String key = i1 + "-" + i2;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        if(i1 < s1.length() && s1.charAt(i1) == s3.charAt(i1+i2) && dfs(s1, s2, s3, i1+1, i2)){
            return true;
        }

        if(i2 < s2.length() && s2.charAt(i2) == s3.charAt(i1+i2) && dfs(s1, s2, s3, i1, i2+1)){
            return true;
        }

        memo.put(key, false);
        return false;
    }
}
