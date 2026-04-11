class Solution {
    public boolean validPalindrome(String s) {

        int n = s.length();

        return solve(s, 0, n-1, false);
    }

    public boolean solve(String s, int l, int r, boolean skip) {
        if(l > r){
            return true;
        }

        if(!isValid(s.charAt(l))){
            return solve(s, l+1, r, skip);
        } else if(!isValid(s.charAt(r))){
            return solve(s, l, r-1, skip);
        } else {
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                if(skip){
                    return false;
                } else {
                    return solve(s, l+1, r, true) || solve(s, l, r-1, true);
                }
            }
        }

        return solve(s, l+1, r-1, skip);
    }

    private boolean isValid(char c){
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c<= 'z');
    }
}