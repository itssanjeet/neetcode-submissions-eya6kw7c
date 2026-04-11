class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n-1;

        while(l < r){
            if(!isValid(s.charAt(l))){
                l++;
                continue;
            } else if(!isValid(s.charAt(r))){
                r--;
                continue;
            } else {
                if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                    return false;
                }

                l++; r--;
            }
        }

        return true;
    }

    private boolean isValid(char c){
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'); 
    }
}
