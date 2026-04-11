class Solution {
    String s1, s2, s3;
    Map<String, Boolean> memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        memo = new HashMap<>();

        return solve(0, 0);
    }

    private boolean solve(int i, int j){
        if(i == s1.length() && j == s2.length()){
            return true;
        }

        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j) && solve(i+1, j)){
            return true;
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j) && solve(i, j+1)){
            return true;
        }

        return false;
    }
}
