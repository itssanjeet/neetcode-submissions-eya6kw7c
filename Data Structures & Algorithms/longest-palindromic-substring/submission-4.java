class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        
        String result = "";
        int resLen = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(palindrom(s.substring(i, j+1)) && j-i+1 > resLen){
                    resLen = j-i+1;
                    result = s.substring(i, j+1);
                }
            }
        }

        return result;
    }

    boolean palindrom(String s){
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++; r--;
        }

        return true;
    }
}
