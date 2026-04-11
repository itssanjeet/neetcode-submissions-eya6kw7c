class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        
        return dfs(s1, s2, s3, 0, 0);
    }

    private boolean dfs(String s1, String s2, String s3, int i1, int i2){
        int i3 = i1+i2;
        if(i3 == s3.length()){
            return true;
        }

        boolean res = false;
        if(i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)){
            res = dfs(s1, s2, s3, i1+1, i2);
        }

        if(i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)){
            res = dfs(s1, s2, s3, i1, i2+1);
        }

        return res;
    }
}
