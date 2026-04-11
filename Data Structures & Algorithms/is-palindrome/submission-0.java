class Solution {
    public boolean isPalindrome(String s) {
        int l=0, r=s.length()-1;
        s = s.toLowerCase();

        while(l<r){
            if(!isValid(s.charAt(l))){
                l++;
                continue;
            }

            if(!isValid(s.charAt(r))){
                r--;
                continue;
            }

            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    boolean isValid(char c){
        if((c >= 'a' || c >= 'A') && (c <= 'z' || c <= 'Z') || (c >= '0' && c <= '9')){
            return true;
        } 

        return false;
    }
}
