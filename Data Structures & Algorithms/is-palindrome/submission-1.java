class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.isEmpty()){
            return false;
        }

        int l = 0, r = s.length() - 1;
        while(l < r){
            if(!isValid(s.charAt(l))){
                l++;
            } else if(!isValid(s.charAt(r))){
                r--;
            } else {
                if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                    return false;
                }
                l++;
                r--;
            }

        }

        return true;
    }

    boolean isValid(char c){
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
